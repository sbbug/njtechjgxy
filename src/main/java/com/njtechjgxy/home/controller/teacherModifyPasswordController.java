package com.njtechjgxy.home.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.njtechjgxy.service.TeacherService;


@Controller
@RequestMapping(value="/tea_password")
public class teacherModifyPasswordController {
     
	        @Autowired
	        private TeacherService teacherService;
	
	
	        //�����޸�ҳ�����
			@RequestMapping(value="/index")
			public ModelAndView login(HttpServletResponse response,HttpServletRequest request){
				response.setCharacterEncoding("utf-8");

				String path=null;
				//����ʹ��
				System.out.println("==="+request.getSession().getAttribute("teacher_num"));
				if(request.getSession().getAttribute("teacher_num").equals("")){
					path="home/teacher_login";
				}else{
					path="home/teacherInfo/teacher_modify_password";
				}
				return new ModelAndView(path);		
			}
			//�����޸Ĳ�����
			@RequestMapping(value="/edit")
			public void edit(HttpServletResponse response,HttpServletRequest request,@RequestParam("new_password") String new_password){
				response.setCharacterEncoding("utf-8");
				String teacher_num = (String)request.getSession().getAttribute("teacher_num");
				System.out.println("teacher_num====="+teacher_num);
				//����json�ַ���
				JsonObjectBuilder resBuilder = Json.createObjectBuilder();
				
				String md5_password = null;
				//����������ܴ洢�����ݿ�
				try {
					md5_password = ComFunctions.EncoderByMd5(new_password);
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//�޸�����
				if(teacherService.modifyPassword(md5_password,teacher_num)!=0){//ע�ⷽ�����ò���˳�򲻿��Եߵ�
					resBuilder.add("result", "yes");//�޸ĳɹ�
					//�޸ĳɹ�����Ҫ���µ�¼
					request.getSession().setAttribute("teacher_num", "");
				}else{
					resBuilder.add("result", "no");//�޸�ʧ��
				}
				JsonObject json = resBuilder.build();
				
				try {
					response.getWriter().write(json.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
						
}
