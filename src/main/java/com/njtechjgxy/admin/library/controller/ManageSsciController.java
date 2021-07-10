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

import com.njtechjgxy.service.library.ScdLibraryService;
import com.njtechjgxy.service.library.SsciLibraryService;
import com.njtechjgxy.vo.Page;
import com.njtechjgxy.vo.library.ScdLibrary;
import com.njtechjgxy.vo.library.SsciLibrary;

@Controller
@RequestMapping(value="/admin_ssci")
public class ManageSsciController {

	@Autowired
	private SsciLibraryService ssciLibraryService;
	
	private Page<SsciLibrary> page = null;
	private List<SsciLibrary> sscis = null;
	private List<SsciLibrary> pageSscis = null;
	
	private SsciLibrary ssciLibrary=null;
	//用于主页面显示的方法
   	@RequestMapping(value="/show_ssci")
   	public ModelAndView index(
   			                 HttpServletResponse response,
   			                 HttpServletRequest request,
   			                 @RequestParam(value = "which",required=true, defaultValue="hello") String  which
   			                 ){
   		response.setCharacterEncoding("utf-8");
   		ModelAndView view  = new ModelAndView("admin/managePeriod/Ssci/showPeriod");
   	    			
   		sscis = ssciLibraryService.getAllSsciLibrary();
   					
   		if(page==null){
   	    	  page = new Page<SsciLibrary>(0,10,sscis.size(),sscis);
   	    }else{
   	    	  page.setAllNum(sscis.size());
   	    	  page.setDatas(sscis);
   	    }		  
   	    
   	    if(which.equals("pre")){
   	    	pageSscis = page.prePage();
   		}else if(which.equals("next")){
   			pageSscis  = page.nextPage();
   		}else{
   			pageSscis= page.firstPage();
   		}		   		    	  
   			
   	    //将单个教师的论文集合返回给前端界面
   	    view.addObject("pageSscis",pageSscis);
   		
   		
   		return view;
   	}
   	@RequestMapping(value="/show_add")
   	public ModelAndView show_add(
   			                 HttpServletResponse response,
   			                 HttpServletRequest request
   			                
   			                 ){
   		response.setCharacterEncoding("utf-8");
   		ModelAndView view  = new ModelAndView("admin/managePeriod/Ssci/addPeriod");
   	    			  		
   		return view;
   	}
   	@RequestMapping(value="/add_ssci")
 	public ModelAndView add_scd(
 			                 HttpServletResponse response,
 			                 HttpServletRequest request,
 			                 @RequestParam("ssci_chinese_name") String ssci_chinese_name,
 			                 @RequestParam("ssci_Eglish_name") String ssci_Eglish_name,
 			                 @RequestParam("ssci_class") String ssci_class,
 			                 @RequestParam("ssci_issn") String ssci_issn
 			                
 			                 ){
 		response.setCharacterEncoding("utf-8");
 		ModelAndView view  = new ModelAndView("admin/managePeriod/Scd/addPeriod");
 	    
 		if(ssciLibraryService.selectBySsciChineseName(ssci_chinese_name)==null){
 			ssciLibraryService.insertSsciLibrary(ssci_chinese_name, ssci_Eglish_name, ssci_class, ssci_issn,1);
     		view.addObject("result", "<script>alert('添加成功!')</script>");
 		}else{
 			view.addObject("result", "<script>alert('已经存在!')</script>");
 		}
 		
 		
 		return view;
 	}
   	@RequestMapping(value="/modify_ssci")
	public ModelAndView modify_scd(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
		
		ModelAndView view = new ModelAndView("admin/managePeriod/Ssci/modifyPeriod");				
		String ssci_chinese_name=null;
		
		try {
			//采用这种方式获取传递的参数，防止出现乱码
			ssci_chinese_name = new String(request.getParameter("ssci_chinese_name").getBytes("iso-8859-1"),"utf-8");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ssciLibrary = ssciLibraryService.selectBySsciChineseName(ssci_chinese_name);			
		
		view.addObject("ssci", ssciLibrary);
		return view;						
	}
   	@RequestMapping(value="/save_modify_ssci")
   	public ModelAndView save_modify_scd(
   			                 HttpServletResponse response,
   			                 HttpServletRequest request,
   			                 @RequestParam("ssci_chinese_name") String ssci_chinese_name,
			                 @RequestParam("ssci_English_name") String ssci_English_name,
			                 @RequestParam("ssci_class") String ssci_class,
			                 @RequestParam("ssci_issn") String ssci_issn,
			                 @RequestParam("ssci_status") String ssci_status
   			                 ){
   		response.setCharacterEncoding("utf-8");
   		ModelAndView view  = new ModelAndView("admin/managePeriod/Ssci/modifyPeriod");
   	    			  
   		
   		ssciLibraryService.updateSsciLibrary(
   				                            ssci_chinese_name, 
   				                            ssci_English_name,
   				                            ssci_class, 
   				                            ssci_issn,
   				                            Integer.parseInt(ssci_status));
   		view.addObject("result", "<script>alert('修改成功!')</script>");
   		ssciLibrary = ssciLibraryService.selectBySsciChineseName(ssci_chinese_name);
   		view.addObject("ssci", ssciLibrary);
   		return view;
   	}
}
