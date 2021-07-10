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
import com.njtechjgxy.service.ReformCheckResultService;
import com.njtechjgxy.service.ReformService;
import com.njtechjgxy.vo.Page;
import com.njtechjgxy.vo.Reform;
import com.njtechjgxy.vo.ReformCheckResult;

@Controller
@RequestMapping(value="/admin_reform")
public class ManageTeacherReformController {

	@Autowired
	private ReformService reformService;
	@Autowired
	private ReformCheckResultService reformCheckResultService ;

	private Page<Reform> page = null;
	private List<Reform> reforms = null;
	private List<Reform> pageReforms = null;
    private ReformCheckResult reformCheckResult;
    
    //用于主页面显示的方法
   	@RequestMapping(value="/show_reform")
   	public ModelAndView index(
   			                 HttpServletResponse response,
   			                 HttpServletRequest request,
   			                 @RequestParam(value = "which",required=true, defaultValue="hello") String  which
   			                 ){
   		response.setCharacterEncoding("utf-8");
   		ModelAndView view  = new ModelAndView("admin/manageTeacherReform/show_teacher_reform");
   	    			
   		reforms = reformService.getAllReforms();
   					
   		if(page==null){
   	    	  page = new Page<Reform>(0,6,reforms.size(),reforms);
   	    }else{
   	    	  page.setAllNum(reforms.size());
   	    	  page.setDatas(reforms);
   	    }		  
   	    
   	    if(which.equals("pre")){
   	    	pageReforms = page.prePage();
   		}else if(which.equals("next")){
   			pageReforms  = page.nextPage();
   		}else{
   			pageReforms= page.firstPage();
   		}		   		    	  
   			
   	    //将单个教师的论文集合返回给前端界面
   	    view.addObject("pageReforms",pageReforms);
   		
   		
   		return view;
   	}
    //资料下载接口
		@RequestMapping(value="/download_data")
		public void download_date(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
						
			//获取下载的资料名
			String reform_path=null;
			try {
				//采用这种方式获取传递的参数，防止出现乱码
				reform_path = new String(request.getParameter("reform_path").getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   //调用资料下载方法
			ComFunctions.download(response, request,reform_path);
									
		}
		 //论文审核数据提取接口
		@RequestMapping(value="/get_reform_check")
		public ModelAndView get_paper_check(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			
			ModelAndView view = new ModelAndView("admin/manageTeacherReform/check_teacher_reform");
			
			
			//获取下载的资料名
			String reform_title=null;
			String teacher_num = null;
			try {
				//采用这种方式获取传递的参数，防止出现乱码
				reform_title = new String(request.getParameter("reform_title").getBytes("iso-8859-1"),"utf-8");
				teacher_num = new String(request.getParameter("teacher_num").getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
			 reformCheckResult = reformCheckResultService.getResultByNumAndTitle(teacher_num, reform_title);
			
			view.addObject("reformCheckResult", reformCheckResult);
			
			return view;						
		}
		 //论文审核数据保存接口
		@RequestMapping(value="/save_result")
		public ModelAndView save_result(
				                       HttpServletResponse response,
				                       HttpServletRequest request,
				                      
				                       @RequestParam("result_ranked") String result_ranked,
				                       @RequestParam("result_is_ok") String result_is_ok,
				                       @RequestParam("result_message") String result_message,
				                       @RequestParam("reform_title") String reform_title,
				                       @RequestParam("teacher_num") String teacher_num
				                       
				){
			response.setCharacterEncoding("utf-8");
			
			ModelAndView view = new ModelAndView("admin/manageTeacherReform/check_teacher_reform");
			
			
			reformCheckResultService.updateReformCheckResultByNumAndTitle(
					                                                      Integer.parseInt(result_is_ok), 
					                                                      result_ranked, 
					                                                      result_message, 
					                                                      reform_title, 
					                                                      teacher_num);
			 
			reformCheckResult = reformCheckResultService.getResultByNumAndTitle(teacher_num, reform_title);
			view.addObject("reformCheckResult", reformCheckResult);
			view.addObject("result", "<script>alert('审核成功!')</script>");
			
			return view;						
		}	
		
}
