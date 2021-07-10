package com.njtechjgxy.home.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.njtechjgxy.service.PrizeCheckResultService;
import com.njtechjgxy.vo.PrizeCheckResult;


@Controller
@RequestMapping(value="/tea_prize_check_result")
public class PrizeTeacherCheckResultController {

	 @Autowired
	   private PrizeCheckResultService prizeCheckResultService;
	
	   private PrizeCheckResult prizeCheckResult = null;
	
	    
	
	
	    //项目审核结果界面显示
		@RequestMapping(value="/index")
		public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			ModelAndView view = null;
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
			String prize_uuid = null;
						
			//判断教师是否 已经登录，防止非法用户进入主页面
			if(request.getSession().getAttribute("teacher_num").equals("")){
				view = new ModelAndView("home/teacher_login");
			}else{
				 try {
					 prize_uuid = new String(request.getParameter("prize_uuid").getBytes("iso-8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				 
				 System.out.println("===============================uuid"+prize_uuid);
				 
				 prizeCheckResult =  prizeCheckResultService.getPrizeCheckResultByNumAndId(prize_uuid, teacher_num);
				 
				 
				view = new ModelAndView("home/teacherPrize/teacher_prize_check_result");
				view.addObject("prize_check_result", prizeCheckResult);
			}
			return view;
		}
	
}
