package com.njtechjgxy.home.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.njtechjgxy.service.PatentCheckResultService;
import com.njtechjgxy.vo.PatentCheckResult;

@Controller
@RequestMapping(value="/tea_patent_check_result")
public class PatentTeacherCheckResultController {

	 @Autowired
	 private PatentCheckResultService patentCheckResultService;
	 
	 private PatentCheckResult patentCheckResult = null;
	 
	 @RequestMapping(value="/index")
		public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			ModelAndView view = null;
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
			String patent_title = null;
						
			//判断教师是否 已经登录，防止非法用户进入主页面
			if(request.getSession().getAttribute("teacher_num").equals("")){
				view = new ModelAndView("home/teacher_login");
			}else{
				 try {
					 patent_title = new String(request.getParameter("patent_title").getBytes("iso-8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				
				patentCheckResult = patentCheckResultService.getCheckResultByNumAndTitle(teacher_num, patent_title);
				 
				view = new ModelAndView("home/teacherPatent/teacher_patent_check_result");
				view.addObject("patent_check_result", patentCheckResult);
			}
			return view;
		}
	
	
}
