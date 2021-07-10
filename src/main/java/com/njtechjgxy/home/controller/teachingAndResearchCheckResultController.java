package com.njtechjgxy.home.controller;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.njtechjgxy.service.TeachingPaperCheckResultService;
import com.njtechjgxy.vo.TeachingPaperCheckResult;

//该控制器用于处理教师审核结果信息表
@Controller
@RequestMapping(value="/teaching_paper_check_result")
public class teachingAndResearchCheckResultController {

	@Autowired
	private TeachingPaperCheckResultService teachingPaperCheckResultService;
	
	
	//显示论文审核信息界面
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");

		TeachingPaperCheckResult teachingPaperCheckResult = null;
		//获取教师登录的账号
		String teacher_num = (String)request.getSession().getAttribute("teacher_num");
		//获取超链接中的论文名称
		String paper_title=null;
		try {
			 paper_title = new String(request.getParameter("paper_title").getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("home/teachingAndResearchPaper/teaching_paper_check_result");
		
		teachingPaperCheckResult = teachingPaperCheckResultService.getTeachingPaperByPapernameAndTeachernum(paper_title, teacher_num);
		
	//	System.out.println("``````````````````"+paperCheckResult.getPaper_title());
		System.out.println("``````````````````"+paper_title+teacher_num);
		
		view.addObject("teachingPaperCheckResult",teachingPaperCheckResult);
		
		return view;
	}	
	
	
}
