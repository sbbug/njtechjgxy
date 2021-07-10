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
import com.njtechjgxy.service.PatentCheckResultService;
import com.njtechjgxy.service.PatentService;
import com.njtechjgxy.vo.Page;
import com.njtechjgxy.vo.Patent;
import com.njtechjgxy.vo.PatentCheckResult;

@Controller
@RequestMapping(value="/admin_patent")
public class ManageTeacherPatentController {

	@Autowired
	private PatentService patentService;
	@Autowired
	private PatentCheckResultService patentCheckResultService ;

	private Page<Patent> page = null;
	private List<Patent> pantents = null;
	private List<Patent> pagePatents = null;
    private PatentCheckResult patentCheckResult;
    
    //������ҳ����ʾ�ķ���
   	@RequestMapping(value="/show_patent")
   	public ModelAndView index(
   			                 HttpServletResponse response,
   			                 HttpServletRequest request,
   			                 @RequestParam(value = "which",required=true, defaultValue="hello") String  which
   			                 ){
   		response.setCharacterEncoding("utf-8");
   		ModelAndView view  = new ModelAndView("admin/manageTeacherPatent/show_teacher_patent");
   	    			
   		pantents = patentService.getPatents();
   					
   		if(page==null){
   	    	  page = new Page<Patent>(0,6,pantents.size(),pantents);
   	    }else{
   	    	  page.setAllNum(pantents.size());
   	    	  page.setDatas(pantents);
   	    }		  
   	    
   	    if(which.equals("pre")){
   	    	pagePatents = page.prePage();
   		}else if(which.equals("next")){
   			pagePatents  = page.nextPage();
   		}else{
   			pagePatents= page.firstPage();
   		}		   		    	  
   			
   	    //��������ʦ�����ļ��Ϸ��ظ�ǰ�˽���
   	    view.addObject("pagePatents",pagePatents);
   		
   		
   		return view;
   	}
  //�������ؽӿ�
  		@RequestMapping(value="/download_data")
  		public void download_date(HttpServletResponse response,HttpServletRequest request){
  			response.setCharacterEncoding("utf-8");
  						
  			//��ȡ���ص�������
  			String patent_path=null;
  			try {
  				//�������ַ�ʽ��ȡ���ݵĲ�������ֹ��������
  				patent_path = new String(request.getParameter("patent_path").getBytes("iso-8859-1"),"utf-8");
  			} catch (UnsupportedEncodingException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  		   //�����������ط���
  			ComFunctions.download(response, request,patent_path);
  									
  		}
  		 //�������������ȡ�ӿ�
		@RequestMapping(value="/get_patent_check")
		public ModelAndView get_paper_check(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			
			ModelAndView view = new ModelAndView("admin/manageTeacherPatent/check_teacher_patent");
			
			
			//��ȡ���ص�������
			String patent_title=null;
			String teacher_num = null;
			try {
				//�������ַ�ʽ��ȡ���ݵĲ�������ֹ��������
				patent_title = new String(request.getParameter("patent_title").getBytes("iso-8859-1"),"utf-8");
				teacher_num = new String(request.getParameter("teacher_num").getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
			patentCheckResult = patentCheckResultService.getCheckResultByNumAndTitle(teacher_num, patent_title); 
			view.addObject("patentCheckResult", patentCheckResult);
			
			return view;						
		}
		 //����������ݱ���ӿ�
		@RequestMapping(value="/save_result")
		public ModelAndView save_result(
				                       HttpServletResponse response,
				                       HttpServletRequest request,
				                       @RequestParam("result_reward_from_depart") String result_reward_from_depart,
				                       @RequestParam("result_rewards") String result_rewards,
				                       @RequestParam("result_is_ok") String result_is_ok,
				                       @RequestParam("result_message") String result_message,
				                       @RequestParam("patent_title") String patent_title,
				                       @RequestParam("teacher_num") String teacher_num
				                       
				){
			response.setCharacterEncoding("utf-8");
			
			ModelAndView view = new ModelAndView("admin/manageTeacherPatent/check_teacher_patent");
			
			
			patentCheckResultService.updatePatentCheckResult(
					                                         Integer.parseInt(result_is_ok), 
					                                         result_rewards,
					                                         result_reward_from_depart, 
					                                         result_message, 
					                                         patent_title,
					                                         teacher_num);
			
			patentCheckResult = patentCheckResultService.getCheckResultByNumAndTitle(teacher_num, patent_title);
			
			view.addObject("patentCheckResult", patentCheckResult);
			view.addObject("result", "<script>alert('��˳ɹ�!')</script>");
			
			return view;						
		}	
}
