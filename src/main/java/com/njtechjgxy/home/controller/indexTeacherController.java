package com.njtechjgxy.home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/tea_index")
public class indexTeacherController {
	
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
		
		String path=null;
		//����ʹ��
		System.out.println("==="+request.getSession().getAttribute("teacher_num"));
		//�жϽ�ʦ�Ƿ� �Ѿ���¼����ֹ�Ƿ��û�������ҳ��
		if(request.getSession().getAttribute("teacher_num").equals("")){
			path="home/teacher_login";
		}else{
			path="home/teacher_index";
		}
		return new ModelAndView(path);
	}
}
