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
	
	
	        //密码修改页面入口
			@RequestMapping(value="/index")
			public ModelAndView login(HttpServletResponse response,HttpServletRequest request){
				response.setCharacterEncoding("utf-8");

				String path=null;
				//测试使用
				System.out.println("==="+request.getSession().getAttribute("teacher_num"));
				if(request.getSession().getAttribute("teacher_num").equals("")){
					path="home/teacher_login";
				}else{
					path="home/teacherInfo/teacher_modify_password";
				}
				return new ModelAndView(path);		
			}
			//密码修改并保存
			@RequestMapping(value="/edit")
			public void edit(HttpServletResponse response,HttpServletRequest request,@RequestParam("new_password") String new_password){
				response.setCharacterEncoding("utf-8");
				String teacher_num = (String)request.getSession().getAttribute("teacher_num");
				System.out.println("teacher_num====="+teacher_num);
				//生成json字符串
				JsonObjectBuilder resBuilder = Json.createObjectBuilder();
				
				String md5_password = null;
				//将新密码加密存储到数据库
				try {
					md5_password = ComFunctions.EncoderByMd5(new_password);
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//修改密码
				if(teacherService.modifyPassword(md5_password,teacher_num)!=0){//注意方法调用参数顺序不可以颠倒
					resBuilder.add("result", "yes");//修改成功
					//修改成功后需要重新登录
					request.getSession().setAttribute("teacher_num", "");
				}else{
					resBuilder.add("result", "no");//修改失败
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
