package com.njtechjgxy.home.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.njtechjgxy.service.LoginLogService;
import com.njtechjgxy.service.TeacherLoginService;
import com.njtechjgxy.service.TeacherService;
import com.njtechjgxy.vo.Page;
import com.njtechjgxy.vo.Paper;
import com.njtechjgxy.vo.Teacher;
import com.njtechjgxy.vo.TeacherLoginLog;

@Controller
@RequestMapping(value="/tea_login")
public class loginTeacherController {
	
	
	@Autowired
	private TeacherService teacherService;
	@Autowired
	//ע������ÿһ�����ݿ���ģ�Ͷ�Ҫ��Ӧһ���Զ�ע���ǩ
	private LoginLogService loginLogService;
	@Autowired
	private TeacherLoginService teacherLoginService;
	
	private List<TeacherLoginLog> AllLoginLogs = null;
	private List<TeacherLoginLog> PageLoginLogs = null;
	private Page<TeacherLoginLog> page = null;
	
	
	//��¼ҳ�����
	@RequestMapping(value="/index")
	public ModelAndView login(HttpServletResponse response){
		response.setCharacterEncoding("utf-8");

		return new ModelAndView("home/teacher_login");
	}
	//�����û���¼,��ת���û���ҳ��
	@RequestMapping(value="/judge",method=RequestMethod.POST)
	@ResponseBody
	//�������ԭʼ����ķ�������json�ַ���
	public void  judge(@RequestParam("teacher_num") String teacher_num,
			           @RequestParam("teacher_password") String teacher_password,
			           @RequestParam("log_ip") String log_ip,
			           @RequestParam("log_time") String log_time,
			           HttpServletResponse response,
			           HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
    
		//�Ƚ���¼��ʱ����ip��ַ���뵽���ݿ���
		
		//���뵽���ݿ�
		
		if(log_ip==null){
			log_ip="1.1.1.1";
		}
		System.out.println("log_ip"+log_ip);
		System.out.println("log_time"+log_time);
		loginLogService.insertLog(log_time,log_ip);
		
		//���������
		
			
				try {
					teacher_password = ComFunctions.EncoderByMd5(teacher_password);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
		
		System.out.println("==============================teacher_password======="+teacher_password);
		//Ȼ�����жϵ�¼���Ƿ��Ѿ���Ȩ
		Teacher teacher = teacherService.getTeacherUsingId(teacher_num, teacher_password);
		//����json�ַ���
		JsonObjectBuilder resBuilder = Json.createObjectBuilder();
		if(teacher==null){
			//�û������������
			resBuilder.add("result", "A");
		}else if(teacher.getTeacher_status()==0){
			//�û��Ѿ�������
			resBuilder.add("result", "B");
		}else{
			//��¼�ɹ�
			resBuilder.add("result", "C");
			
			//�������ݱ�����session��
			HttpSession session = request.getSession();
			session.setAttribute("teacher_num", teacher.getTeacher_num());
		    
			Date day=new Date();    
			
			System.out.println();   
			teacherLoginService.insertLog(teacher_num, day);
		}
		JsonObject json = resBuilder.build();
		
		//����ʹ��
		//System.out.println("==="+teacher_num+teacher_password);
	
		try {
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�˳���ע��session
	@RequestMapping(value="/quit")
	public String quit(HttpServletRequest request,HttpServletResponse response){
		
		//ע����¼�˺�
		request.getSession().setAttribute("teacher_num", "");
		
		return  "home/teacher_login";
	}
	//��ʾ��ʦ��¼��Ϣ
	@RequestMapping(value="/show_login_log")
	public ModelAndView show_login_log(HttpServletRequest request,HttpServletResponse response, @RequestParam(value = "which",required=true, defaultValue="hello") String  which){
		response.setCharacterEncoding("utf-8");
		
		ModelAndView view = new ModelAndView("home/teacherInfo/teacher_show_login_log");
		//��ȡ��ʦ����
		String teacher_num = (String)request.getSession().getAttribute("teacher_num");
		AllLoginLogs =  teacherLoginService.SelectLog(teacher_num);
		
		
		if(page==null){
	    	  page = new Page<TeacherLoginLog>(0,6,AllLoginLogs.size(),AllLoginLogs);
	    }else{
	    	  page.setAllNum(AllLoginLogs.size());
	    	  page.setDatas(AllLoginLogs);
	    }
	  
	    
	    if(which.equals("pre")){
	    	 PageLoginLogs = page.prePage();
		}else if(which.equals("next")){
			 PageLoginLogs = page.nextPage();
		}else{
			 PageLoginLogs = page.firstPage();
		}		   	
		
		
		
		view.addObject("PageLoginLogs",  PageLoginLogs);
		
		
		return  view;
	}
	
}
