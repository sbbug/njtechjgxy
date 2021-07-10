package com.njtechjgxy.admin.library.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.njtechjgxy.service.library.OwnLibraryService;
import com.njtechjgxy.vo.Achievement;
import com.njtechjgxy.vo.AchievementCheckResult;
import com.njtechjgxy.vo.Page;
import com.njtechjgxy.vo.library.OwnLibrary;

@Controller
@RequestMapping(value="/admin_own")
public class ManageOwnController {

	@Autowired
	private OwnLibraryService ownLibraryService;
	
	private Page<OwnLibrary> page = null;
	private List<OwnLibrary> owns = null;
	private List<OwnLibrary> pageOwns = null;
    
	private OwnLibrary ownLibrary =null;
	//用于主页面显示的方法
   	@RequestMapping(value="/show_own")
   	public ModelAndView index(
   			                 HttpServletResponse response,
   			                 HttpServletRequest request,
   			                 @RequestParam(value = "which",required=true, defaultValue="hello") String  which
   			                 ){
   		response.setCharacterEncoding("utf-8");
   		ModelAndView view  = new ModelAndView("admin/managePeriod/Own/showPeriod");
   	    			
   		owns = ownLibraryService.getAllOwnLibrary();
   					
   		if(page==null){
   	    	  page = new Page<OwnLibrary>(0,10,owns.size(),owns);
   	    }else{
   	    	  page.setAllNum(owns.size());
   	    	  page.setDatas(owns);
   	    }		  
   	    
   	    if(which.equals("pre")){
   	    	pageOwns = page.prePage();
   		}else if(which.equals("next")){
   			pageOwns  = page.nextPage();
   		}else{
   			pageOwns= page.firstPage();
   		}		   		    	  
   			
   	    //将单个教师的论文集合返回给前端界面
   	    view.addObject("pageOwns",pageOwns);
   		
   		
   		return view;
   	}
	@RequestMapping(value="/show_add")
   	public ModelAndView show_add(
   			                 HttpServletResponse response,
   			                 HttpServletRequest request
   			                
   			                 ){
   		response.setCharacterEncoding("utf-8");
   		ModelAndView view  = new ModelAndView("admin/managePeriod/Own/addPeriod");
   	    			  		
   		return view;
   	}
	//添加单条记录
	@RequestMapping(value="/add_own")
   	public ModelAndView add_own(
   			                 HttpServletResponse response,
   			                 HttpServletRequest request,
   			                 @RequestParam("own_issn") String own_issn,
   			                 @RequestParam("own_name") String own_name,
   			                 @RequestParam("own_area") String own_area,
   			                 @RequestParam("own_fullname") String own_fullname,
   			                 @RequestParam("own_rank") String own_rank
   			                 ){
   		response.setCharacterEncoding("utf-8");
   		ModelAndView view  = new ModelAndView("admin/managePeriod/Own/addPeriod");
   	    
   		if(ownLibraryService.selectByName(own_name)==null){
   			ownLibraryService.insertOwnLibrary(
                       own_issn, 
                       own_name, 
                       Integer.parseInt(own_area), 
                       own_fullname, 
                       own_rank, 
                       1);
   			view.addObject("result", "<script>alert('添加成功!')</script>");
   		}else{
   			view.addObject("result", "<script>alert('已经存在!')</script>");
   		}
   		  		   				
   		return view;
   	}
	    //期刊修改
	 
		@RequestMapping(value="/modify_own")
		public ModelAndView modify_own(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			
			ModelAndView view = new ModelAndView("admin/managePeriod/Own/modifyPeriod");
			
			
			
			String own_name=null;
			
			try {
				//采用这种方式获取传递的参数，防止出现乱码
				own_name = new String(request.getParameter("own_name").getBytes("iso-8859-1"),"utf-8");
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ownLibrary = ownLibraryService.selectByName(own_name);
			
			view.addObject("own", ownLibrary);
			return view;						
		}
	//excel表格导入添加
	@RequestMapping(value="/show_excel")
   	public ModelAndView show_excel(
   			                 HttpServletResponse response,
   			                 HttpServletRequest request
   			                
   			                 ){
   		response.setCharacterEncoding("utf-8");
   		ModelAndView view  = new ModelAndView("admin/managePeriod/Own/excelAddPeriod");
   	    			  		
   		return view;
   	}
	//修改期刊条目
	
		@RequestMapping(value="/save_modify_own")
	   	public ModelAndView save_modify_own(
	   			                 HttpServletResponse response,
	   			                 HttpServletRequest request,
	   			                 @RequestParam("own_issn") String own_issn,
	   			                 @RequestParam("own_name") String own_name,
	   			                 @RequestParam("own_area") String own_area,
	   			                 @RequestParam("own_fullname") String own_fullname,
	   			                 @RequestParam("own_rank") String own_rank,
	   			              @RequestParam("own_status") String own_status
	   			                 ){
	   		response.setCharacterEncoding("utf-8");
	   		ModelAndView view  = new ModelAndView("admin/managePeriod/Own/modifyPeriod");
	   	    			  
	   		ownLibraryService.updateByName(
	   				                     own_issn, 
	   				                     own_name, 
	   				                     Integer.parseInt(own_area), 
	   				                     own_fullname, 
	   				                     own_rank, 
	   				                     Integer.parseInt(own_status));
	   		ownLibrary = ownLibraryService.selectByName(own_name);
	   		view.addObject("result", "<script>alert('修改成功!')</script>");
	   		view.addObject("own", ownLibrary);
	   		return view;
	   	}
	
	
}
