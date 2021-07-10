package com.njtechjgxy.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/adm_index")
public class indexAdminController {
	
	//用于主页面显示的方法
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
		
		String path=null;
		//测试使用
		System.out.println("==="+request.getSession().getAttribute("admin_num"));
		if(request.getSession().getAttribute("admin_num")==null){
			path="admin/admin_login";
		}else{
			path="admin/admin_index";
		}
		return new ModelAndView(path);
	}
	//显示头页面的方法
	@RequestMapping(value="/head")
    public ModelAndView head(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
		
		String path=null;
		//测试使用
		System.out.println("==="+request.getSession().getAttribute("admin_num"));
		if(request.getSession().getAttribute("admin_num")==null){
			path="admin/admin_login";
		}else{
			path="admin/admin_head";
		}
		return new ModelAndView(path);
		
	}
	//显示左部页面的方法
	@RequestMapping(value="/left")
	public ModelAndView left(HttpServletResponse response,HttpServletRequest request){
          response.setCharacterEncoding("utf-8");
		
		String path=null;
		//测试使用
		System.out.println("==="+request.getSession().getAttribute("admin_num"));
		if(request.getSession().getAttribute("admin_num")==null){
			path="admin/admin_login";
		}else{
			path="admin/admin_left";
		}
		
		return new ModelAndView(path);	
	}
	@RequestMapping(value="/show_default")
	public ModelAndView show_default(HttpServletResponse response,HttpServletRequest request){
          response.setCharacterEncoding("utf-8");
		
		String path=null;
		//测试使用
		System.out.println("==="+request.getSession().getAttribute("admin_num"));
		if(request.getSession().getAttribute("admin_num")==null){
			path="admin/admin_login";
		}else{
			path="admin/main";
		}
		
		return new ModelAndView(path);	
	}
	
}