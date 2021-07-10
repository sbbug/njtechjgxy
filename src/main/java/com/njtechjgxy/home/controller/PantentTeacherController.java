package com.njtechjgxy.home.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.njtechjgxy.service.DepartmentService;
import com.njtechjgxy.service.PatentCheckResultService;
import com.njtechjgxy.service.PatentService;
import com.njtechjgxy.vo.Department;
import com.njtechjgxy.vo.Page;
import com.njtechjgxy.vo.Paper;
import com.njtechjgxy.vo.Patent;


@Controller
@RequestMapping(value="/tea_patent")
public class PantentTeacherController {

	  @Autowired 
	  private DepartmentService departmentService;
	  @Autowired
	  private PatentService patentService;
	  @Autowired
	  private PatentCheckResultService patentCheckResultService;
	
	   private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	   private List<Department> departs = null;
	   private Patent patent = null;
	   private List<Patent> patents = null;
	   private Page<Patent> page = null;
	   private List<Patent> pagePatents=null;
	
	   //进入竞赛获奖填写信息界面
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
				view = new ModelAndView("home/teacherPatent/teacher_patent");
				view.addObject("departs", departs);
			}
			return view;
		}
		
		//保存教师填写的信息方法
		@RequestMapping(value="/addPatent")
		public ModelAndView addPatent(
				                    HttpServletResponse response,
				                    HttpServletRequest request,
				                    HttpSession session,
				                    @RequestParam("patent_status") String patent_status,						                 
				                    @RequestParam("patent_department") String patent_department,
				                    @RequestParam("patent_first_author") String patent_first_author,
				                    @RequestParam("patent_second_author") String patent_second_author,
				                    @RequestParam("patent_third_author") String patent_third_author,
				                    @RequestParam("patent_other_author") String patent_other_author,
				                    @RequestParam("patent_class") String patent_class,
				                    @RequestParam("patent_title") String patent_title,
				                    @RequestParam("patent_num") String patent_num,
				                    @RequestParam("patent_remark") String patent_remark,					                  			                
				                    @RequestParam("upfile")  MultipartFile upfile
				                   ){
			response.setCharacterEncoding("utf-8");
			ModelAndView view  = new ModelAndView("home/teacherPatent/teacher_patent");
			//教师工号记录
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
			Patent tempPatent = null;
			
			tempPatent = patentService.getPatent(teacher_num, patent_title);
			
			if(tempPatent==null){
				
			   
				
				view.addObject("result", "<script>alert('填报成功!')</script>");
				
				//其它变量的处理
				//确定文件名并且要具有唯一性
				String patent_date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
				
				//文件存储的名字
				String patent_path=teacher_num+"-"+patent_date+"-"+"专利申报"+upfile.getOriginalFilename();   
				//将上传的文件保存到服务器目录下
				ComFunctions.upload(upfile, session, response, patent_path);
				//将数据记录插入到数据库
				
				Date date=null;
				try {				
					date = sf.parse(patent_date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				patentService.insertPatent(
						                  Integer.parseInt(patent_status), 
						                  patent_department, 
						                  patent_first_author, 
						                  patent_second_author,
						                  patent_third_author,
						                  patent_other_author, 
						                  patent_class, 
						                  patent_title,
						                  patent_num,
						                  patent_remark, 
						                  patent_path,
						                  patent_date, 
						                  teacher_num);
				
			
			patentCheckResultService.insertPatentCheckResult(
					                                        1, 
					                                        "还未审核", 
					                                        "还未审核", 
					                                        "", 
					                                        patent_title, 
					                                        teacher_num);
			}else{
				
				view.addObject("result", "<script>alert('已经填报!')</script>");	
				
			}
			
			departs = departmentService.getDeparts();
			view.addObject("departs", departs);
			
			return view;
		}
	//搜索专利界面
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
				
				patents = patentService.getPatentsByNum(teacher_num);
				
			
			    ModelAndView view = new ModelAndView("home/teacherPatent/teacher_patent_search");
			    
			    if(page==null){
			    	  page = new Page<Patent>(0,3,patents.size(),patents);
			    }else{
			    	  page.setAllNum(patents.size());
			    	  page.setDatas(patents);
			    }
			  
			    
			    if(which.equals("pre")){
			    	pagePatents = page.prePage();
				}else if(which.equals("next")){
					pagePatents = page.nextPage();
				}else{
					pagePatents = page.firstPage();
				}		   		    	  
					
			//将单个教师的论文集合返回给前端界面
			view.addObject("pagePatents", pagePatents);
			
			return view;
		}	
		
		//进入修改数据部分
		@RequestMapping(value="/modify_patent")
		public ModelAndView modify_prize(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			ModelAndView view = null;
			String patent_title=null;
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");			
			
			//判断教师是否 已经登录，防止非法用户进入主页面
			if(request.getSession().getAttribute("teacher_num")==null){
				view = new ModelAndView("home/teacher_login");
			}else{
				
				try {
					patent_title = new String(request.getParameter("patent_title").getBytes("iso-8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				patent = patentService.getPatent(teacher_num, patent_title);
				
				
				departs = departmentService.getDeparts();
				view = new ModelAndView("home/teacherPatent/teacher_patent_modify");
				view.addObject("departs", departs);
				view.addObject("patent", patent);
			}
			return view;
		}
		//保存教师填写的信息方法
				@RequestMapping(value="/modify_save_patent")
				public ModelAndView modify_save_patent(
						                    HttpServletResponse response,
						                    HttpServletRequest request,
						                    HttpSession session,
						                    @RequestParam("patent_status") String patent_status,						                 
						                    @RequestParam("patent_department") String patent_department,
						                    @RequestParam("patent_first_author") String patent_first_author,
						                    @RequestParam("patent_second_author") String patent_second_author,
						                    @RequestParam("patent_third_author") String patent_third_author,
						                    @RequestParam("patent_other_author") String patent_other_author,
						                    @RequestParam("patent_class") String patent_class,
						                    @RequestParam("patent_title") String patent_title,
						                    @RequestParam("patent_num") String patent_num,
						                    @RequestParam("patent_remark") String patent_remark,					                  			                
						                    @RequestParam("upfile")  MultipartFile upfile
						                   ){
					response.setCharacterEncoding("utf-8");
					ModelAndView view  = new ModelAndView("home/teacherPatent/teacher_patent_modify");
					//教师工号记录
					String teacher_num = (String)request.getSession().getAttribute("teacher_num");
					
					
												
						view.addObject("result", "<script>alert('修改成功!')</script>");
						
						//其它变量的处理
						//确定文件名并且要具有唯一性
						String patent_date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
						
						//文件存储的名字
						String patent_path=teacher_num+"-"+patent_date+"-"+"专利申报"+upfile.getOriginalFilename();   
						//将上传的文件保存到服务器目录下
						ComFunctions.upload(upfile, session, response, patent_path);
						//将数据记录插入到数据库
						
						Date date=null;
						try {				
							date = sf.parse(patent_date);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						patentService.updatePatentByTitleAndNum(
								                                Integer.parseInt(patent_status), 
								                                patent_department,
								                                patent_first_author, 
								                                patent_second_author, 
								                                patent_third_author, 
								                                patent_other_author, 
								                                patent_class,
								                                patent_title,
								                                patent_num, 
								                                patent_remark,
								                                patent_path, 
								                                patent_date, 
								                                teacher_num);
						
					 patent = patentService.getPatent(teacher_num, patent_title);
				
					
					
					departs = departmentService.getDeparts();
					view.addObject("departs", departs);
					view.addObject("patent", patent);
					return view;
				}
	
}
