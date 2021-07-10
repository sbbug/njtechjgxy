package com.njtechjgxy.home.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.njtechjgxy.service.ItemCheckResultService;
import com.njtechjgxy.vo.ItemCheckResult;

@Controller
@RequestMapping(value="/tea_item_check_result")
public class itemTeacherCheckResultController {

	   @Autowired
	   private ItemCheckResultService itemCheckResultService;
	
	   private ItemCheckResult itemCheckResult = null;
	
	   //项目审核结果界面显示
		@RequestMapping(value="/index")
		public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			ModelAndView view = null;
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
			String item_title = null;
						
			//判断教师是否 已经登录，防止非法用户进入主页面
			if(request.getSession().getAttribute("teacher_num").equals("")){
				view = new ModelAndView("home/teacher_login");
			}else{
				 try {
					item_title = new String(request.getParameter("item_title").getBytes("iso-8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				itemCheckResult =  itemCheckResultService.getItemCheckResultByNumAndTitle(teacher_num, item_title);
				 
				 
				view = new ModelAndView("home/teacherItem/teacher_item_check_result");
				view.addObject("item_check_result", itemCheckResult);
			}
			return view;
		}
}
