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
import com.njtechjgxy.vo.Page;
import com.njtechjgxy.vo.library.ScdLibrary;

@Controller
@RequestMapping(value="/admin_scd")
public class ManageScdController {
    
	@Autowired
	private ScdLibraryService scdLibraryService;
	
	private Page<ScdLibrary> page = null;
	private List<ScdLibrary> scds = null;
	private List<ScdLibrary> pageScds = null;
	
	private ScdLibrary  scdLibrary=null;
	//������ҳ����ʾ�ķ���
   	@RequestMapping(value="/show_scd")
   	public ModelAndView index(
   			                 HttpServletResponse response,
   			                 HttpServletRequest request,
   			                 @RequestParam(value = "which",required=true, defaultValue="hello") String  which
   			                 ){
   		response.setCharacterEncoding("utf-8");
   		ModelAndView view  = new ModelAndView("admin/managePeriod/Scd/showPeriod");
   	    			
   		scds = scdLibraryService.getAllScdLibrary();
   					
   		if(page==null){
   	    	  page = new Page<ScdLibrary>(0,10,scds.size(),scds);
   	    }else{
   	    	  page.setAllNum(scds.size());
   	    	  page.setDatas(scds);
   	    }		  
   	    
   	    if(which.equals("pre")){
   	    	pageScds = page.prePage();
   		}else if(which.equals("next")){
   			pageScds  = page.nextPage();
   		}else{
   			pageScds= page.firstPage();
   		}		   		    	  
   			
   	    //��������ʦ�����ļ��Ϸ��ظ�ǰ�˽���
   	    view.addObject("pageScds",pageScds);
   		
   		
   		return view;
   	}
	@RequestMapping(value="/show_add")
   	public ModelAndView show_add(
   			                 HttpServletResponse response,
   			                 HttpServletRequest request
   			                
   			                 ){
   		response.setCharacterEncoding("utf-8");
   		ModelAndView view  = new ModelAndView("admin/managePeriod/Scd/addPeriod");
   	    			  		
   		return view;
   	}
	//��ӵ�����¼
  	@RequestMapping(value="/add_scd")
     	public ModelAndView add_scd(
     			                 HttpServletResponse response,
     			                 HttpServletRequest request,
     			                 @RequestParam("scd_name") String scd_name,
     			                 @RequestParam("scd_issn") String scd_issn,
     			                 @RequestParam("scd_cn") String scd_cn
     			                
     			                 ){
     		response.setCharacterEncoding("utf-8");
     		ModelAndView view  = new ModelAndView("admin/managePeriod/Scd/addPeriod");
     	    
     		if(scdLibraryService.selectByScdName(scd_name)==null){
     			scdLibraryService.insertScdLibrary(scd_name, scd_issn, scd_cn, 1);
         		view.addObject("result", "<script>alert('��ӳɹ�!')</script>");
     		}else{
     			view.addObject("result", "<script>alert('�Ѿ�����!')</script>");
     		}
     		
     		
     		return view;
     	}
  	@RequestMapping(value="/modify_scd")
	public ModelAndView modify_scd(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
		
		ModelAndView view = new ModelAndView("admin/managePeriod/Scd/modifyPeriod");				
		String scd_name=null;
		
		try {
			//�������ַ�ʽ��ȡ���ݵĲ�������ֹ��������
			scd_name = new String(request.getParameter("scd_name").getBytes("iso-8859-1"),"utf-8");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scdLibrary = scdLibraryService.selectByScdName(scd_name);				
		
		view.addObject("scd", scdLibrary);
		return view;						
	}
  	@RequestMapping(value="/save_modify_scd")
   	public ModelAndView save_modify_scd(
   			                 HttpServletResponse response,
   			                 HttpServletRequest request,
   			                 @RequestParam("scd_name") String scd_name,
			                 @RequestParam("scd_issn") String scd_issn,
			                 @RequestParam("scd_cn") String scd_cn,
   			                
   			                  @RequestParam("scd_status") String scd_status
   			                 ){
   		response.setCharacterEncoding("utf-8");
   		ModelAndView view  = new ModelAndView("admin/managePeriod/Scd/modifyPeriod");
   	    			  
   		scdLibraryService.updateByScdName(scd_name, scd_issn, scd_cn, Integer.parseInt(scd_status));
   		scdLibrary = scdLibraryService.selectByScdName(scd_name);
   		view.addObject("result", "<script>alert('�޸ĳɹ�!')</script>");
   		view.addObject("scd", scdLibrary);
   		return view;
   	}
  //excel��������
  	@RequestMapping(value="/show_excel")
     	public ModelAndView show_excel(
     			                 HttpServletResponse response,
     			                 HttpServletRequest request
     			                
     			                 ){
     		response.setCharacterEncoding("utf-8");
     		ModelAndView view  = new ModelAndView("admin/managePeriod/Scd/excelAddPeriod");
     	    			  		
     		return view;
     	}
}
