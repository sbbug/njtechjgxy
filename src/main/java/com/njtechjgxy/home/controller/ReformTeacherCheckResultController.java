package com.njtechjgxy.home.controller;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.njtechjgxy.service.ReformCheckResultService;
import com.njtechjgxy.vo.ReformCheckResult;


@Controller
@RequestMapping(value="/tea_reform_check_result")
public class ReformTeacherCheckResultController {

	
	@Autowired
	   private ReformCheckResultService reformCheckResultService;
	
	   private ReformCheckResult reformCheckResult = null;
	
	    	
	
	    //项目审核结果界面显示
		@RequestMapping(value="/index")
		public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			ModelAndView view = null;
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
			String reform_title = null;
						
			//判断教师是否 已经登录，防止非法用户进入主页面
			if(request.getSession().getAttribute("teacher_num").equals("")){
				view = new ModelAndView("home/teacher_login");
			}else{
				 try {
					 reform_title = new String(request.getParameter("reform_title").getBytes("iso-8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				 
				 System.out.println("===============================uuid"+reform_title);
				 
				 reformCheckResult = reformCheckResultService.getResultByNumAndTitle(teacher_num, reform_title);
				 
				 
				view = new ModelAndView("home/teacherReform/teacher_reform_check_result");
				view.addObject("reform_check_result", reformCheckResult);
			}
			return view;
		}
	
}
