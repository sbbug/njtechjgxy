package com.njtechjgxy.admin.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.njtechjgxy.home.controller.ComFunctions;
import com.njtechjgxy.service.ItemCheckResultService;
import com.njtechjgxy.service.ItemService;
import com.njtechjgxy.vo.Item;
import com.njtechjgxy.vo.ItemCheckResult;
import com.njtechjgxy.vo.Page;


@Controller
@RequestMapping(value="/admin_item")
public class ManageTeacherItemController {
            
			@Autowired
			private ItemService itemService;
			@Autowired
			private ItemCheckResultService itemCheckResultService ;
		
			private Page<Item> page = null;
			private List<Item> items = null;
			private List<Item> pageItems = null;
		    private ItemCheckResult itemCheckResult;
	    
	
	        //用于主页面显示的方法
			@RequestMapping(value="/show_item")
			public ModelAndView index(
					                 HttpServletResponse response,
					                 HttpServletRequest request,
					                 @RequestParam(value = "which",required=true, defaultValue="hello") String  which
					                 ){
				response.setCharacterEncoding("utf-8");
				ModelAndView view  = new ModelAndView("admin/manageTeacherItem/show_teacher_Item");
			    			
				items = itemService.getAllItems();
							
				if(page==null){
			    	  page = new Page<Item>(0,6,items.size(),items);
			    }else{
			    	  page.setAllNum(items.size());
			    	  page.setDatas(items);
			    }		  
			    
			    if(which.equals("pre")){
				    		pageItems = page.prePage();
				}else if(which.equals("next")){
				    		pageItems = page.nextPage();
				}else{
				    		pageItems = page.firstPage();
				}		   		    	  
					
			    //将单个教师的论文集合返回给前端界面
			    view.addObject("pageItems", pageItems);
				
				
				return view;
			}
			//资料下载接口
			@RequestMapping(value="/download_data")
			public void download_date(HttpServletResponse response,HttpServletRequest request){
				response.setCharacterEncoding("utf-8");
							
				//获取下载的资料名
				String item_path=null;
				try {
					//采用这种方式获取传递的参数，防止出现乱码
					item_path = new String(request.getParameter("item_path").getBytes("iso-8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   //调用资料下载方法
				ComFunctions.download(response, request, item_path);
										
			}
			
			 //论文审核数据提取接口
			@RequestMapping(value="/get_item_check")
			public ModelAndView get_paper_check(HttpServletResponse response,HttpServletRequest request){
				response.setCharacterEncoding("utf-8");
				
				ModelAndView view = new ModelAndView("admin/manageTeacherItem/check_teacher_Item");
				
				
				//获取下载的资料名
				String item_title=null;
				String teacher_num = null;
				try {
					//采用这种方式获取传递的参数，防止出现乱码
					item_title = new String(request.getParameter("item_title").getBytes("iso-8859-1"),"utf-8");
					teacher_num = new String(request.getParameter("teacher_num").getBytes("iso-8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
				itemCheckResult = itemCheckResultService.getItemCheckResultByNumAndTitle(teacher_num, item_title);
				
				view.addObject("itemCheckResult", itemCheckResult);
				
				return view;						
			}
			 //论文审核数据保存接口
			@RequestMapping(value="/save_result")
			public ModelAndView save_result(
					                       HttpServletResponse response,
					                       HttpServletRequest request,
					                       @RequestParam("result_rank") String result_rank,
					                       @RequestParam("result_message") String result_message,
					                       @RequestParam("result_is_ok") String result_is_ok,
					                       @RequestParam("item_title") String item_title,
					                       @RequestParam("teacher_num") String teacher_num
					                       
					){
				response.setCharacterEncoding("utf-8");
				
				ModelAndView view = new ModelAndView("admin/manageTeacherItem/check_teacher_Item");
				
				itemCheckResultService.updateItemCheckResultByTitleAndNum(
						                                                result_rank,
						                                                Integer.parseInt(result_is_ok),
						                                                result_message, 
						                                                item_title, 
						                                                teacher_num);
				itemCheckResult = itemCheckResultService.getItemCheckResultByNumAndTitle(teacher_num, item_title);
				view.addObject("itemCheckResult", itemCheckResult);
				view.addObject("result", "<script>alert('审核成功!')</script>");
				
				return view;						
			}	
}
