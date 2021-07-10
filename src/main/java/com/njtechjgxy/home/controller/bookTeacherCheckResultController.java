package com.njtechjgxy.home.controller;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.njtechjgxy.service.BookCheckResultService;
import com.njtechjgxy.vo.BookCheckResult;


@Controller
@RequestMapping(value="/tea_book_check_result")
public class bookTeacherCheckResultController {

	   @Autowired
	   private BookCheckResultService bookCheckResultService;
	
	   private BookCheckResult bookCheckResult = null;
	
	
	 //��Ŀ��˽��������ʾ
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
		ModelAndView view = null;
		String teacher_num = (String)request.getSession().getAttribute("teacher_num");
		String book_name = null;
					
		//�жϽ�ʦ�Ƿ� �Ѿ���¼����ֹ�Ƿ��û�������ҳ��
		if(request.getSession().getAttribute("teacher_num").equals("")){
			view = new ModelAndView("home/teacher_login");
		}else{
			 try {
				book_name = new String(request.getParameter("book_name").getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			 bookCheckResult =  bookCheckResultService.getBookCheckResultByNameAndNum(book_name, teacher_num);
			 
			 
			view = new ModelAndView("home/teacherBook/teacher_book_check_result");
			view.addObject("book_check_result", bookCheckResult);
		}
		return view;
	}
}
