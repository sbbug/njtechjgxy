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
	
	//主页面入口处
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		
		return new ModelAndView("admin/admin_login");
	}
	//处理管理员登录,跳转到管理主页面
	@RequestMapping(value="/judge",method=RequestMethod.POST)
	@ResponseBody
		//这里采用原始输出的方法返回json字符串
		public void  judge(@RequestParam("admin_num") String admin_num,@RequestParam("admin_password") String admin_password,HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
	    
			Admin admin = adminService.getAdminUsingId(admin_num, admin_password);
			//生成json字符串
			JsonObjectBuilder resBuilder = Json.createObjectBuilder();
			if(admin==null){
				//用户名或密码错误
				resBuilder.add("result", "A");
			}else{
				//登录成功
				resBuilder.add("result", "B");
				
				//并将数据保存在session里
				HttpSession session = request.getSession();
				session.setAttribute("admin_num", admin.getAdmin_num());
			}
			JsonObject json = resBuilder.build();
			
			//调试使用
			System.out.println("==="+admin_num+admin_password);
		
			try {
				response.getWriter().write(json.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//退出并注销session
	
		@RequestMapping(value="/quit")
		public void quit(HttpServletRequest request,HttpServletResponse response){
			
			//注销登录账号
			request.getSession().setAttribute("admin_num", "");
			
			//点击退出之后采用页面重定向,在这里采用从重定向貌似不可以
			
			try {
				response.getWriter().write("<script type='text/javascript'>window.parent.location.href='http://127.0.0.1:8080/njtechjgxy/adm_login/index';</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
