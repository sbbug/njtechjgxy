package com.njtechjgxy.admin.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.njtechjgxy.home.controller.ComFunctions;
import com.njtechjgxy.service.BookCheckResultService;
import com.njtechjgxy.service.BookService;
import com.njtechjgxy.vo.Book;
import com.njtechjgxy.vo.BookCheckResult;
import com.njtechjgxy.vo.Page;


@Controller
@RequestMapping(value="/admin_book")
public class ManageTeacherBookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private BookCheckResultService bookCheckResultService ;

	private Page<Book> page = null;
	private List<Book> books = null;
	private List<Book> pageBooks = null;
    private BookCheckResult bookCheckResult;
    
    //������ҳ����ʾ�ķ���
	@RequestMapping(value="/show_book")
	public ModelAndView index(
			                 HttpServletResponse response,
			                 HttpServletRequest request,
			                 @RequestParam(value = "which",required=true, defaultValue="hello") String  which
			                 ){
		response.setCharacterEncoding("utf-8");
		ModelAndView view  = new ModelAndView("admin/manageTeacherBook/show_teacher_book");
	    			
		books = bookService.getAllBooks();
					
		if(page==null){
	    	  page = new Page<Book>(0,6,books.size(),books);
	    }else{
	    	  page.setAllNum(books.size());
	    	  page.setDatas(books);
	    }		  
	    
	    if(which.equals("pre")){
		    		pageBooks = page.prePage();
		}else if(which.equals("next")){
			        pageBooks  = page.nextPage();
		}else{
			        pageBooks= page.firstPage();
		}		   		    	  
			
	    //��������ʦ�����ļ��Ϸ��ظ�ǰ�˽���
	    view.addObject("pageBooks",pageBooks);
		
		
		return view;
	}
	//�������ؽӿ�
	@RequestMapping(value="/download_data")
	public void download_date(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
					
		//��ȡ���ص�������
		String book_path=null;
		try {
			//�������ַ�ʽ��ȡ���ݵĲ�������ֹ��������
			book_path = new String(request.getParameter("book_path").getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   //�����������ط���
		ComFunctions.download(response, request, book_path);
								
	}
	 //�������������ȡ�ӿ�
	@RequestMapping(value="/get_book_check")
	public ModelAndView get_paper_check(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
		
		ModelAndView view = new ModelAndView("admin/manageTeacherBook/check_teacher_book");
		
		
		//��ȡ���ص�������
		String book_name=null;
		String teacher_num = null;
		try {
			//�������ַ�ʽ��ȡ���ݵĲ�������ֹ��������
			book_name = new String(request.getParameter("book_name").getBytes("iso-8859-1"),"utf-8");
			teacher_num = new String(request.getParameter("teacher_num").getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		bookCheckResult = bookCheckResultService.getBookCheckResultByNameAndNum(book_name, teacher_num);
		
		view.addObject("bookCheckResult", bookCheckResult);
		
		return view;						
	}
	 //����������ݱ���ӿ�
	@RequestMapping(value="/save_result")
	public ModelAndView save_result(
			                       HttpServletResponse response,
			                       HttpServletRequest request,
			                       @RequestParam("result_total_reward") String result_total_reward,
			                       @RequestParam("result_reward_from_depart") String result_reward_from_depart,
			                       @RequestParam("result_is_ok") String result_is_ok,
			                       @RequestParam("result_message") String result_message,
			                       @RequestParam("book_name") String book_name,
			                       @RequestParam("teacher_num") String teacher_num
			                       
			){
		response.setCharacterEncoding("utf-8");
		
		ModelAndView view = new ModelAndView("admin/manageTeacherBook/check_teacher_book");
		
		
		bookCheckResultService.UpdateBookCheckResultByNumAndName(
				                                                result_total_reward, 
				                                                result_reward_from_depart,
				                                                result_message, 
				                                                Integer.parseInt(result_is_ok), 
				                                                book_name, 
				                                                teacher_num);
		
		bookCheckResult = bookCheckResultService.getBookCheckResultByNameAndNum(book_name, teacher_num);
		view.addObject("bookCheckResult", bookCheckResult);
		view.addObject("result", "<script>alert('��˳ɹ�!')</script>");
		
		return view;						
	}	
	
}
