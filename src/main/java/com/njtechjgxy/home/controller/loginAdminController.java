package com.njtechjgxy.home.controller;

import java.io.IOException;
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
import com.njtechjgxy.service.AdminService;
import com.njtechjgxy.service.TeacherService;
import com.njtechjgxy.vo.Admin;
import com.njtechjgxy.vo.Teacher;


@Controller
@RequestMapping(value="/adm_login")
public class loginAdminController {
	
	@Autowired
	private AdminService adminService;
	
	//��ҳ����ڴ�
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		
		return new ModelAndView("admin/admin_login");
	}
	//�������Ա��¼,��ת��������ҳ��
	@RequestMapping(value="/judge",method=RequestMethod.POST)
	@ResponseBody
		//�������ԭʼ����ķ�������json�ַ���
		public void  judge(@RequestParam("admin_num") String admin_num,@RequestParam("admin_password") String admin_password,HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
	    
			Admin admin = adminService.getAdminUsingId(admin_num, admin_password);
			//����json�ַ���
			JsonObjectBuilder resBuilder = Json.createObjectBuilder();
			if(admin==null){
				//�û������������
				resBuilder.add("result", "A");
			}else{
				//��¼�ɹ�
				resBuilder.add("result", "B");
				
				//�������ݱ�����session��
				HttpSession session = request.getSession();
				session.setAttribute("admin_num", admin.getAdmin_num());
			}
			JsonObject json = resBuilder.build();
			
			//����ʹ��
			System.out.println("==="+admin_num+admin_password);
		
			try {
				response.getWriter().write(json.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�˳���ע��session
	
		@RequestMapping(value="/quit")
		public void quit(HttpServletRequest request,HttpServletResponse response){
			
			//ע����¼�˺�
			request.getSession().setAttribute("admin_num", "");
			
			//����˳�֮�����ҳ���ض���,��������ô��ض���ò�Ʋ�����
			
			try {
				response.getWriter().write("<script type='text/javascript'>window.parent.location.href='http://127.0.0.1:8080/njtechjgxy/adm_login/index';</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
