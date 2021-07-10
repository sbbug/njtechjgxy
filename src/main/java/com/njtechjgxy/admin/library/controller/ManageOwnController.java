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
	//������ҳ����ʾ�ķ���
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
   			
   	    //��������ʦ�����ļ��Ϸ��ظ�ǰ�˽���
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
	//��ӵ�����¼
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
   			view.addObject("result", "<script>alert('��ӳɹ�!')</script>");
   		}else{
   			view.addObject("result", "<script>alert('�Ѿ�����!')</script>");
   		}
   		  		   				
   		return view;
   	}
	    //�ڿ��޸�
	 
		@RequestMapping(value="/modify_own")
		public ModelAndView modify_own(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			
			ModelAndView view = new ModelAndView("admin/managePeriod/Own/modifyPeriod");
			
			
			
			String own_name=null;
			
			try {
				//�������ַ�ʽ��ȡ���ݵĲ�������ֹ��������
				own_name = new String(request.getParameter("own_name").getBytes("iso-8859-1"),"utf-8");
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ownLibrary = ownLibraryService.selectByName(own_name);
			
			view.addObject("own", ownLibrary);
			return view;						
		}
	//excel��������
	@RequestMapping(value="/show_excel")
   	public ModelAndView show_excel(
   			                 HttpServletResponse response,
   			                 HttpServletRequest request
   			                
   			                 ){
   		response.setCharacterEncoding("utf-8");
   		ModelAndView view  = new ModelAndView("admin/managePeriod/Own/excelAddPeriod");
   	    			  		
   		return view;
   	}
	//�޸��ڿ���Ŀ
	
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
	   		view.addObject("result", "<script>alert('�޸ĳɹ�!')</script>");
	   		view.addObject("own", ownLibrary);
	   		return view;
	   	}
	
	
}
