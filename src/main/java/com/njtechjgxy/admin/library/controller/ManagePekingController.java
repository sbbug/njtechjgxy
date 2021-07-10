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

import com.njtechjgxy.service.library.PekingLibraryService;
import com.njtechjgxy.service.library.ScdLibraryService;
import com.njtechjgxy.vo.Page;
import com.njtechjgxy.vo.library.PekingLibrary;
import com.njtechjgxy.vo.library.ScdLibrary;
import com.njtechjgxy.vo.library.SsciLibrary;

@Controller
@RequestMapping(value="/admin_peking")
public class ManagePekingController {

	@Autowired
	private PekingLibraryService pekingLibraryService;
	
	private Page<PekingLibrary> page = null;
	private List<PekingLibrary> pekings = null;
	private List<PekingLibrary> pagePekings = null;
	
	private PekingLibrary pekingLibrary=null;
	//用于主页面显示的方法
   	@RequestMapping(value="/show_peking")
   	public ModelAndView index(
   			                 HttpServletResponse response,
   			                 HttpServletRequest request,
   			                 @RequestParam(value = "which",required=true, defaultValue="hello") String  which
   			                 ){
   		response.setCharacterEncoding("utf-8");
   		ModelAndView view  = new ModelAndView("admin/managePeriod/Peking/showPeriod");
   	    			
   		pekings = pekingLibraryService.getAllPekingLibrary();
   					
   		if(page==null){
   	    	  page = new Page<PekingLibrary>(0,10,pekings.size(),pekings);
   	    }else{
   	    	  page.setAllNum(pekings.size());
   	    	  page.setDatas(pekings);
   	    }		  
   	    
   	    if(which.equals("pre")){
   	    	pagePekings = page.prePage();
   		}else if(which.equals("next")){
   			pagePekings  = page.nextPage();
   		}else{
   			pagePekings= page.firstPage();
   		}		   		    	  
   			
   	    //将单个教师的论文集合返回给前端界面
   	    view.addObject("pagePekings",pagePekings);
   		
   		
   		return view;
   	}
   	@RequestMapping(value="/show_add")
   	public ModelAndView show_add(
   			                 HttpServletResponse response,
   			                 HttpServletRequest request
   			                
   			                 ){
   		response.setCharacterEncoding("utf-8");
   		ModelAndView view  = new ModelAndView("admin/managePeriod/Peking/addPeriod");
   	    			  		
   		return view;
   	}
  //添加单条记录
  	@RequestMapping(value="/add_peking")
     	public ModelAndView add_own(
     			                 HttpServletResponse response,
     			                 HttpServletRequest request,
     			                 @RequestParam("peking_area") String peking_area,
     			                 @RequestParam("peking_series") String peking_series,
     			                 @RequestParam("peking_name") String peking_name
     			                
     			                 ){
     		response.setCharacterEncoding("utf-8");
     		ModelAndView view  = new ModelAndView("admin/managePeriod/Peking/addPeriod");
     	    
     		if(pekingLibraryService.selectByPekingName(peking_name)==null){
     			pekingLibraryService.insertPekingLibrary(peking_area, peking_series, peking_name, 1);
         		view.addObject("result", "<script>alert('添加成功!')</script>");
     		}else{
     			view.addObject("result", "<script>alert('已经存在!')</script>");
     		}
     		
     		
     		return view;
     	}
  	 //期刊修改
	 
	@RequestMapping(value="/modify_peking")
	public ModelAndView modify_own(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
		
		ModelAndView view = new ModelAndView("admin/managePeriod/Peking/modifyPeriod");
		
		
		
		String peking_name=null;
		
		try {
			//采用这种方式获取传递的参数，防止出现乱码
			peking_name = new String(request.getParameter("peking_name").getBytes("iso-8859-1"),"utf-8");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pekingLibrary = pekingLibraryService.selectByPekingName(peking_name);
		
		view.addObject("peking", pekingLibrary);
		return view;						
	}
	@RequestMapping(value="/save_modify_peking")
   	public ModelAndView save_modify_own(
   			                 HttpServletResponse response,
   			                 HttpServletRequest request,
   			                 @RequestParam("peking_area") String peking_area,
			                 @RequestParam("peking_series") String peking_series,
			                 @RequestParam("peking_name") String peking_name,
   			                
   			                  @RequestParam("peking_status") String peking_status
   			                 ){
   		response.setCharacterEncoding("utf-8");
   		ModelAndView view  = new ModelAndView("admin/managePeriod/Peking/modifyPeriod");
   	    			  
   		pekingLibraryService.updateByPekingName(
   				                              peking_area, 
   				                              peking_series, 
   				                              peking_name, 
   				                              Integer.parseInt(peking_status));
   		pekingLibrary = pekingLibraryService.selectByPekingName(peking_name);
   		view.addObject("result", "<script>alert('修改成功!')</script>");
   		view.addObject("peking", pekingLibrary);
   		return view;
   	}
	
	
  //excel表格导入添加
  	@RequestMapping(value="/show_excel")
     	public ModelAndView show_excel(
     			                 HttpServletResponse response,
     			                 HttpServletRequest request
     			                
     			                 ){
     		response.setCharacterEncoding("utf-8");
     		ModelAndView view  = new ModelAndView("admin/managePeriod/Peking/excelAddPeriod");
     	    			  		
     		return view;
     	}
}
