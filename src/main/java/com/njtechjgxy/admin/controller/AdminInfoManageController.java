package com.njtechjgxy.admin.controller;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import com.njtechjgxy.home.controller.ComFunctions;
import com.njtechjgxy.service.AdminService;
import com.njtechjgxy.service.DepartmentService;
import com.njtechjgxy.service.TeacherService;
import com.njtechjgxy.vo.Book;
import com.njtechjgxy.vo.Department;
import com.njtechjgxy.vo.Page;
import com.njtechjgxy.vo.Teacher;

@Controller
@RequestMapping(value="/admin_manage")
public class AdminInfoManageController {

	
	@Autowired
	private AdminService adminService;
	@Autowired
	private TeacherService teacherService;
	@Autowired 
	private DepartmentService departmentService;
	
	private List<Department> departs = null;
	private Teacher teacher=null;
	private List<Teacher> teachers = null;
	private Page<Teacher> page = null;
	private List<Teacher> pageTeachers = null;
	//进入填写项目信息界面
		@RequestMapping(value="/entry_teacher_info")
		public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			ModelAndView view = null;
			
			
			String path=null;
			//测试使用
			System.out.println("==="+request.getSession().getAttribute("admin_num"));
			//判断教师是否 已经登录，防止非法用户进入主页面
			if(request.getSession().getAttribute("admin_num")==null){
				view = new ModelAndView("admin/admin_login");
			}else{
				
				departs = departmentService.getDeparts();
				view = new ModelAndView("admin/manageTeacherInfo/entry_teacher_info");
				view.addObject("departs", departs);
			}
			return view;
		}
	
		@RequestMapping(value="/add_teacher")
		public ModelAndView addItem(
				                    HttpServletResponse response,
				                    HttpServletRequest request,
				                    HttpSession session,
				                    @RequestParam("teacher_num") String teacher_num,
				                    @RequestParam("teacher_name") String teacher_name,
				                   
				                    @RequestParam("teacher_department") String teacher_department,
				                    @RequestParam("teacher_sex") String teacher_sex,
				                    @RequestParam("teacher_address") String teacher_address,
				                    @RequestParam("teacher_ID_Card") String teacher_ID_Card,
				                    @RequestParam("teacher_birthday") String teacher_birthday,
				                    @RequestParam("teacher_education") String teacher_education,
				                    @RequestParam("teacher_title") String teacher_title,
				                    @RequestParam("teacher_remark") String teacher_remark
				                  
				                   ){
			response.setCharacterEncoding("utf-8");
			ModelAndView view  = new ModelAndView("admin/manageTeacherInfo/entry_teacher_info");
			//教师工号记录
			String admin_num = (String)request.getSession().getAttribute("admin_num");
			
			//密码需要进行加密
			String teacher_password = teacher_ID_Card.substring(teacher_ID_Card.length()-6, teacher_ID_Card.length());
			teacher = teacherService.getTeacherByNum(teacher_num);
									
			//当teacher==null时，说明还未填报
			if(teacher==null){
				
				view.addObject("result", "<script>alert('录入成功!')</script>");
				
				//其它变量的处理
				//开始加密
				try {
					//格式化
					
				   
					
					teacher_password = ComFunctions.EncoderByMd5(teacher_password);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			    teacherService.insertTeacher(
					                    teacher_num, 
					                    teacher_name,
					                    teacher_password, 
					                    1,					                   					                    
					                    teacher_department, 					                   
					                    teacher_sex, 
					                    teacher_address, 
					                    teacher_ID_Card, 
					                    teacher_birthday,
					                    teacher_education, 
					                    teacher_title, 
					                    teacher_remark);
				
				
			}else{
				view.addObject("result", "<script>alert('该教师已经存在!')</script>");
			}
			
			view.addObject("departs", departs);
			
			return view;
		}
		//教师基本信息批量导入界面
		@RequestMapping(value="/entry_excel_teacher_info")
		public ModelAndView entry_excel_teacher_info(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			ModelAndView view = null;
			
			
			String path=null;
			//测试使用
			System.out.println("==="+request.getSession().getAttribute("admin_num"));
			//判断教师是否 已经登录，防止非法用户进入主页面
			if(request.getSession().getAttribute("admin_num")==null){
				view = new ModelAndView("admin/admin_login");
			}else{
				
				departs = departmentService.getDeparts();
				view = new ModelAndView("admin/manageTeacherInfo/excel_entry_teacher_info");
				view.addObject("departs", departs);
			}
			return view;
		}
		//信息开始导入
		@RequestMapping(value="/add_excel_teacher")
		public ModelAndView addItem(
				                    HttpServletResponse response,
				                    HttpServletRequest request,	
				                    HttpSession session,
				                    @RequestParam("upfile")  MultipartFile upfile
				                   ){
			response.setCharacterEncoding("utf-8");
			ModelAndView view  = new ModelAndView("admin/manageTeacherInfo/excel_entry_teacher_info");
			
															
			
				
				//其它变量的处理
				//确定文件名并且要具有唯一性
				String excel_date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
				
				//文件存储的名字
				String excel_name="教师基本信息"+upfile.getOriginalFilename();   
				//将上传的文件保存到服务器目录下
				String excel_path=ComFunctions.upload(upfile, session, response, excel_name);
				
				teachers = ComFunctions.getTeachersByExcel(excel_path);
				
				for(int num=0;num<teachers.size();num++){
					
					teacherService.insertTeacher(
							                      teachers.get(num).getTeacher_num(),
							                      teachers.get(num).getTeacher_name(),
							                      teachers.get(num).getTeacher_password(),
							                      teachers.get(num).getTeacher_status(), 
							                      teachers.get(num).getTeacher_department(),
							                      teachers.get(num).getTeacher_sex(), 
							                      teachers.get(num).getTeacher_address(),
							                      teachers.get(num).getTeacher_ID_Card(),
							                      teachers.get(num).getTeacher_birthday(),
							                      teachers.get(num).getTeacher_education(), 
							                      teachers.get(num).getTeacher_title(), 
							                      teachers.get(num).getTeacher_remark());
					
					
				}
				
				
				System.out.println("=============控制器获取数据"+teachers.get(4).getTeacher_address());
				
				//将数据记录插入到数据库
				view.addObject("result", "<script>alert('导入成功!')</script>");														
			return view;
		}
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
				
				teachers = teacherService.getTeahcers();
				
			
			    ModelAndView view = new ModelAndView("admin/manageTeacherInfo/show_all_teacher");
			    
			    if(page==null){
			    	  page = new Page<Teacher>(0,6,teachers.size(),teachers);
			    }else{
			    	  page.setAllNum(teachers.size());
			    	  page.setDatas(teachers);
			    }
			  
			    
			    if(which.equals("pre")){
			    	pageTeachers = page.prePage();
				}else if(which.equals("next")){
					pageTeachers = page.nextPage();
				}else{
					pageTeachers = page.firstPage();
				}		   		    	  
					
			//将单个教师的论文集合返回给前端界面
			view.addObject("pageTeachers", pageTeachers);
			
			return view;
		}
		//进入教师信息修改
		@RequestMapping(value="/modify_teacher")
		public ModelAndView modify_teacher(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			ModelAndView view = null;
			String teacher_num=null;
			
			try {
				teacher_num = new String(request.getParameter("teacher_num").getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			String path=null;
			//测试使用
			System.out.println("==="+request.getSession().getAttribute("admin_num"));
			//判断管理员是否 已经登录，防止非法用户进入主页面
			if(request.getSession().getAttribute("admin_num")==null){
				view = new ModelAndView("admin/admin_login");
			}else{
				
				teacher = teacherService.getTeacherByNum(teacher_num);
				departs = departmentService.getDeparts();
				view = new ModelAndView("admin/manageTeacherInfo/modify_teacher");
				view.addObject("departs", departs);
				view.addObject("teacher", teacher);
			}
			return view;
		}
		@RequestMapping(value="/save_teacher")
		public ModelAndView save_teacher(
				                    HttpServletResponse response,
				                    HttpServletRequest request,
				                    HttpSession session,
				                    @RequestParam("teacher_num") String teacher_num,
				                    @RequestParam("teacher_name") String teacher_name,				                   
				                    @RequestParam("teacher_department") String teacher_department,
				                    @RequestParam("teacher_sex") String teacher_sex,
				                    @RequestParam("teacher_address") String teacher_address,
				                    @RequestParam("teacher_ID_Card") String teacher_ID_Card,
				                    @RequestParam("teacher_birthday") String teacher_birthday,
				                    @RequestParam("teacher_education") String teacher_education,
				                    @RequestParam("teacher_status") String teacher_status,
				                    @RequestParam("teacher_title") String teacher_title,
				                    @RequestParam("teacher_remark") String teacher_remark
				                  
				                   ){
			response.setCharacterEncoding("utf-8");
			ModelAndView view  = new ModelAndView("admin/manageTeacherInfo/modify_teacher");
						
									
				view.addObject("result", "<script>alert('修改成功!')</script>");
				teacherService.updateTeacherByNum(
						                         teacher_num,
						                         teacher_name, 
						                         Integer.parseInt(teacher_status), 
						                         teacher_department,
						                         teacher_sex, 
						                         teacher_address,
						                         teacher_ID_Card, 
						                         teacher_birthday,
						                         teacher_education,
						                         teacher_title,
						                         teacher_remark);		
			teacher = teacherService.getTeacherByNum(teacher_num);	
			view.addObject("departs", departs);
			view.addObject("teacher", teacher);
			return view;
		}
		//密码重置功能
		@RequestMapping(value="/reset_password")
		public ModelAndView reset_password(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			ModelAndView view = null;
			String password = null;
			String teacher_password=null;
			String teacher_num=null;
			String teacher_ID_Card=null;
			try {
				teacher_num = new String(request.getParameter("teacher_num").getBytes("iso-8859-1"),"utf-8");
				teacher_ID_Card = new String(request.getParameter("teacher_ID_Card").getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
									
			//判断管理员是否 已经登录，防止非法用户进入主页面
			if(request.getSession().getAttribute("admin_num")==null){
				view = new ModelAndView("admin/admin_login");
			}else{
				
				//获取明文密码
			    teacher_password = teacher_ID_Card.substring(teacher_ID_Card.length()-6, teacher_ID_Card.length());
				//对密码进行加密
			    try {
					password = ComFunctions.EncoderByMd5(teacher_password);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//修改密码
			    teacherService.modifyPassword(password, teacher_num);
				
							
		        teachers = teacherService.getTeahcers();				
				view = new ModelAndView("admin/manageTeacherInfo/show_all_teacher");			
				view.addObject("pageTeachers", pageTeachers);
				view.addObject("result", "<script>alert('重置成功!')</script>");
			}
			return view;
		}
}
