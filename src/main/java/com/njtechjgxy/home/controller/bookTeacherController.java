package com.njtechjgxy.home.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.njtechjgxy.service.BookCheckResultService;
import com.njtechjgxy.service.BookService;
import com.njtechjgxy.service.DepartmentService;
import com.njtechjgxy.vo.Book;
import com.njtechjgxy.vo.Department;
import com.njtechjgxy.vo.Page;
import com.njtechjgxy.vo.Paper;

@Controller
@RequestMapping(value="/tea_book")
public class bookTeacherController {

	
	@Autowired 
	private DepartmentService departmentService;
	@Autowired
	private BookService bookService;
	@Autowired
	private BookCheckResultService bookCheckResultService;
	
	private List<Department> departs=null;
	private Book book=null;
	private List<Book> books = null;
	private Page<Book> page = null;
	private List<Book> pageBooks = null;
	
	//������д��Ŀ��Ϣ����
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
		ModelAndView view = null;
		
		
		String path=null;
		//����ʹ��
		System.out.println("==="+request.getSession().getAttribute("teacher_num"));
		//�жϽ�ʦ�Ƿ� �Ѿ���¼����ֹ�Ƿ��û�������ҳ��
		if(request.getSession().getAttribute("teacher_num")==null){
			view = new ModelAndView("home/teacher_login");
		}else{
			
			departs = departmentService.getDeparts();
			view = new ModelAndView("home/teacherBook/teacher_book");
			view.addObject("departs", departs);
		}
		return view;
	}
	
	//�����ʦ��д����Ϣ����
		@RequestMapping(value="/addBook")
		public ModelAndView addItem(
				                    HttpServletResponse response,
				                    HttpServletRequest request,
				                    HttpSession session,
				                    @RequestParam("book_status") String book_status,
				                    @RequestParam("book_category_class") String book_category_class,
				                    @RequestParam("book_copyright_type") String book_copyright_type,
				                    @RequestParam("book_department") String book_department,
				                    @RequestParam("book_first_author") String book_first_author,
				                    @RequestParam("book_second_author") String book_second_author,
				                    @RequestParam("book_third_author") String book_third_author,
				                    @RequestParam("book_name") String book_name,
				                    @RequestParam("book_press_name") String book_press_name,
				                    @RequestParam("book_publish_date") String book_publish_date,
				                    @RequestParam("book_words") String book_words,
				                    @RequestParam("book_which") String book_which,
				                    @RequestParam("book_remark") String book_remark,			                
				                    @RequestParam("upfile")  MultipartFile upfile
				                   ){
			response.setCharacterEncoding("utf-8");
			ModelAndView view  = new ModelAndView("home/teacherBook/teacher_book");
			//��ʦ���ż�¼
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
			
			book = bookService.getBookByNum(teacher_num, book_name);
									
			//��book==nullʱ��˵����δ�
			if(book==null){
				
				view.addObject("result", "<script>alert('��ɹ�!')</script>");
				
				//���������Ĵ���
				//ȷ���ļ�������Ҫ����Ψһ��
				String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
				
				//�ļ��洢������
				String book_path=teacher_num+"-"+date+"-"+"�鼮�걨"+upfile.getOriginalFilename();   
				//���ϴ����ļ����浽������Ŀ¼��
				ComFunctions.upload(upfile, session, response, book_path);
				//�����ݼ�¼���뵽���ݿ�
				
				Date book_date = new Date();
				bookService.insertBook(
						               Integer.parseInt(book_status),
						               book_category_class, 
						               book_copyright_type,
						               book_department,
						               book_first_author,
						               book_second_author, 
						               book_third_author, 
						               book_name, 
						               book_press_name, 
						               book_publish_date,
						               book_words, 
						               book_which, 
						               book_remark, 
						               book_path, 
						               book_date, 
						               teacher_num);
				
				
			}else{
				view.addObject("result", "<script>alert('����Ŀ�Ѿ�����!')</script>");
			}
			bookCheckResultService.insertBookCheckResult("��δ���", "��δ���", "��δ���", 1, book_name, teacher_num);
			//itemCheckResultService.insertItemCheckResult("��δ���", "��δ���", 1, item_title, teacher_num);
			departs = departmentService.getDeparts();
			view.addObject("departs", departs);
			
			return view;
		}
		//������д��Ŀ��Ϣ����
		@RequestMapping(value="/search")
		public ModelAndView search(
				                  HttpServletResponse response,
				                  HttpServletRequest request,
				                  @RequestParam(value = "which",required=true, defaultValue="hello") String  which
				                  ){
			response.setCharacterEncoding("utf-8");
			//��ȡ��ʦ����
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
			//�˴������Ż�����ֹ�ظ���ѯ���ݿ�
			
				//��ȡ���н�ʦ������ͬ�����ļ���
				
				books = bookService.getBooksByNum(teacher_num);
				
			
			    ModelAndView view = new ModelAndView("home/teacherBook/teacher_book_search");
			    
			    if(page==null){
			    	  page = new Page<Book>(0,3,books.size(),books);
			    }else{
			    	  page.setAllNum(books.size());
			    	  page.setDatas(books);
			    }
			  
			    
			    if(which.equals("pre")){
				    		books = page.prePage();
				}else if(which.equals("next")){
				    		books = page.nextPage();
				}else{
				    		books = page.firstPage();
				}		   		    	  
					
			//��������ʦ�����ļ��Ϸ��ظ�ǰ�˽���
			view.addObject("pageBooks", books);
			
			return view;
		}
		
		 //�鼮�޸�ҳ�����
				@RequestMapping(value="/modify_book")
				public ModelAndView modify_paper( 
						 HttpServletResponse response,
			             HttpServletRequest request
			            
						){
					response.setCharacterEncoding("utf-8");
					
					String book_name=null;
					try {
						//�������ַ�ʽ��ȡ���ݵĲ�������ֹ��������
						book_name = new String(request.getParameter("book_name").getBytes("iso-8859-1"),"utf-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					//��ȡ��ʦ��¼���˺�
					String teacher_num = (String)request.getSession().getAttribute("teacher_num");
					//����
					System.out.println("===========>"+book_name);
					Book book = bookService.getBookByNum(teacher_num, book_name);
					departs = departmentService.getDeparts();
					ModelAndView view = new ModelAndView("home/teacherBook/teacher_book_modify");
					view.addObject("departs", departs);
					view.addObject("book", book);
					return view;
				}
			//�����޸ĺ����Ϣ	
				@RequestMapping(value="/modify_save_book")
				public ModelAndView modify_save_book(
						                    HttpServletResponse response,
						                    HttpServletRequest request,
						                    HttpSession session,
						                    @RequestParam("book_id") String book_id,
						                    @RequestParam("book_status") String book_status,
						                    @RequestParam("book_category_class") String book_category_class,
						                    @RequestParam("book_copyright_type") String book_copyright_type,
						                    @RequestParam("book_department") String book_department,
						                    @RequestParam("book_first_author") String book_first_author,
						                    @RequestParam("book_second_author") String book_second_author,
						                    @RequestParam("book_third_author") String book_third_author,
						                    @RequestParam("book_name") String book_name,
						                    @RequestParam("book_press_name") String book_press_name,
						                    @RequestParam("book_publish_date") String book_publish_date,
						                    @RequestParam("book_words") String book_words,
						                    @RequestParam("book_which") String book_which,
						                    @RequestParam("book_remark") String book_remark,			                
						                    @RequestParam("upfile")  MultipartFile upfile
						                   ){
					response.setCharacterEncoding("utf-8");
					ModelAndView view  = new ModelAndView("home/teacherBook/teacher_book_modify");
					//��ʦ���ż�¼
					String teacher_num = (String)request.getSession().getAttribute("teacher_num");
																													
					view.addObject("result", "<script>alert('�޸ĳɹ�!')</script>");
						
					//���������Ĵ���
					//ȷ���ļ�������Ҫ����Ψһ��
					String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
						
					//�ļ��洢������
					String book_path=teacher_num+"-"+date+"-"+"�鼮�걨"+upfile.getOriginalFilename();   
						//���ϴ����ļ����浽������Ŀ¼��
						ComFunctions.upload(upfile, session, response, book_path);
						//�����ݼ�¼���뵽���ݿ�
						
						Date book_date = new Date();
						bookService.updateBookByNumAndId(
								                        Integer.parseInt(book_id), 
								                        Integer.parseInt(book_status), 
								                        book_category_class, 
								                        book_copyright_type, 
								                        book_department, 
								                        book_first_author, 
								                        book_second_author, 
								                        book_third_author,
								                        book_name,
								                        book_press_name,
								                        book_publish_date, 
								                        book_words, 
								                        book_which, 
								                        book_remark,
								                        book_path,
								                        book_date, 
								                        teacher_num);
																									
					departs = departmentService.getDeparts();
					Book book = bookService.getBookByNum(teacher_num, book_name);
					view.addObject("departs", departs);
					view.addObject("book", book);
					return view;
				}	
				
}
