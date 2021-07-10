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

//�ÿ��������ڴ����ʦ��˽����Ϣ��
@Controller
@RequestMapping(value="/teaching_paper_check_result")
public class teachingAndResearchCheckResultController {

	@Autowired
	private TeachingPaperCheckResultService teachingPaperCheckResultService;
	
	
	//��ʾ���������Ϣ����
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");

		TeachingPaperCheckResult teachingPaperCheckResult = null;
		//��ȡ��ʦ��¼���˺�
		String teacher_num = (String)request.getSession().getAttribute("teacher_num");
		//��ȡ�������е���������
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
