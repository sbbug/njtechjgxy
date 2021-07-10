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
	
	//进入填写项目信息界面
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
		ModelAndView view = null;
		
		
		String path=null;
		//测试使用
		System.out.println("==="+request.getSession().getAttribute("teacher_num"));
		//判断教师是否 已经登录，防止非法用户进入主页面
		if(request.getSession().getAttribute("teacher_num")==null){
			view = new ModelAndView("home/teacher_login");
		}else{
			
			departs = departmentService.getDeparts();
			view = new ModelAndView("home/teacherBook/teacher_book");
			view.addObject("departs", departs);
		}
		return view;
	}
	
	//保存教师填写的信息方法
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
			//教师工号记录
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
			
			book = bookService.getBookByNum(teacher_num, book_name);
									
			//当book==null时，说明还未填报
			if(book==null){
				
				view.addObject("result", "<script>alert('填报成功!')</script>");
				
				//其它变量的处理
				//确定文件名并且要具有唯一性
				String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
				
				//文件存储的名字
				String book_path=teacher_num+"-"+date+"-"+"书籍申报"+upfile.getOriginalFilename();   
				//将上传的文件保存到服务器目录下
				ComFunctions.upload(upfile, session, response, book_path);
				//将数据记录插入到数据库
				
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
				view.addObject("result", "<script>alert('该项目已经存在!')</script>");
			}
			bookCheckResultService.insertBookCheckResult("还未审核", "还未审核", "还未审核", 1, book_name, teacher_num);
			//itemCheckResultService.insertItemCheckResult("还未审核", "还未审核", 1, item_title, teacher_num);
			departs = departmentService.getDeparts();
			view.addObject("departs", departs);
			
			return view;
		}
		//进入填写项目信息界面
		@RequestMapping(value="/search")
		public ModelAndView search(
				                  HttpServletResponse response,
				                  HttpServletRequest request,
				                  @RequestParam(value = "which",required=true, defaultValue="hello") String  which
				                  ){
			response.setCharacterEncoding("utf-8");
			//获取教师工号
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
			//此处进行优化，防止重复查询数据库
			
				//获取所有教师工号相同的论文集合
				
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
					
			//将单个教师的论文集合返回给前端界面
			view.addObject("pageBooks", books);
			
			return view;
		}
		
		 //书籍修改页面入口
				@RequestMapping(value="/modify_book")
				public ModelAndView modify_paper( 
						 HttpServletResponse response,
			             HttpServletRequest request
			            
						){
					response.setCharacterEncoding("utf-8");
					
					String book_name=null;
					try {
						//采用这种方式获取传递的参数，防止出现乱码
						book_name = new String(request.getParameter("book_name").getBytes("iso-8859-1"),"utf-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					//获取教师登录的账号
					String teacher_num = (String)request.getSession().getAttribute("teacher_num");
					//测试
					System.out.println("===========>"+book_name);
					Book book = bookService.getBookByNum(teacher_num, book_name);
					departs = departmentService.getDeparts();
					ModelAndView view = new ModelAndView("home/teacherBook/teacher_book_modify");
					view.addObject("departs", departs);
					view.addObject("book", book);
					return view;
				}
			//保存修改后的信息	
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
					//教师工号记录
					String teacher_num = (String)request.getSession().getAttribute("teacher_num");
																													
					view.addObject("result", "<script>alert('修改成功!')</script>");
						
					//其它变量的处理
					//确定文件名并且要具有唯一性
					String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
						
					//文件存储的名字
					String book_path=teacher_num+"-"+date+"-"+"书籍申报"+upfile.getOriginalFilename();   
						//将上传的文件保存到服务器目录下
						ComFunctions.upload(upfile, session, response, book_path);
						//将数据记录插入到数据库
						
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
