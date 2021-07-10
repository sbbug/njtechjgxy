package com.njtechjgxy.home.controller;


import java.io.UnsupportedEncodingException;
import java.text.ParseException;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.njtechjgxy.service.DepartmentService;
import com.njtechjgxy.service.TeacherPaperCheckResultService;
import com.njtechjgxy.service.PaperService;
import com.njtechjgxy.service.library.OwnLibraryService;
import com.njtechjgxy.service.library.PekingLibraryService;
import com.njtechjgxy.service.library.ScdLibraryService;
import com.njtechjgxy.service.library.SsciLibraryService;
import com.njtechjgxy.vo.Department;
import com.njtechjgxy.vo.Page;
import com.njtechjgxy.vo.Paper;


@Controller
@RequestMapping(value="/tea_paper")
public class paperTeacherController {
       
	
	    @Autowired
	    private DepartmentService departmentService;
	    @Autowired
	    private PaperService paperService;
	    @Autowired
	    private TeacherPaperCheckResultService teacherPaperCheckResultService;
	    //期刊库的接口类定义
	    @Autowired
	    private OwnLibraryService ownLibraryService;
	    @Autowired
	    private PekingLibraryService pekingLibraryService;
	    @Autowired 
	    private ScdLibraryService scdLibraryService;
	    @Autowired
	    private SsciLibraryService ssciLibraryService;
	    
	        
	    //专业系的集合定义
	    private List<Department> departs = null;
	    //单个教师所有论文集合定义
	    private List<Paper> allPapers = null;
	   //每一页的论文集合定义
	    private List<Paper> pagePapers = null;
	    //分页类定义
	    private Page<Paper> page=null;
	    
	    
	    
	    //论文提交页面入口
		@RequestMapping(value="/index")
		public ModelAndView index(HttpServletResponse response){
			response.setCharacterEncoding("utf-8");
          
			if(departs==null){
				 departs = departmentService.getDeparts();
			}		ModelAndView view = new ModelAndView("home/teacherPaper/teacher_paper");

			
			view.addObject("departs", departs);
			view.addObject("result", "");
			return view;
		}
		//科研论文搜索界面入口
		//科研论文数据的显示采用内存分页实现，这里只考虑到了项目比较小，没有考虑项目太大
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
				
				allPapers = paperService.getPapersByNum(teacher_num);
				
			
			    ModelAndView view = new ModelAndView("home/teacherPaper/teacher_paper_search");
			    
			    if(page==null){
			    	  page = new Page<Paper>(0,3,allPapers.size(),allPapers);
			    }else{
			    	  page.setAllNum(allPapers.size());
			    	  page.setDatas(allPapers);
			    }
			  
			    
			    if(which.equals("pre")){
				    		pagePapers = page.prePage();
				}else if(which.equals("next")){
				    		pagePapers = page.nextPage();
				}else{
				    		pagePapers = page.firstPage();
				}		   		    	  
					
			//将单个教师的论文集合返回给前端界面
			view.addObject("pagePapers", pagePapers);
			
			return view;
		}
		//搜索单个科研论文
		@RequestMapping(value="/search_by_title")
		public ModelAndView searchByTitle(HttpServletResponse response,
				                          HttpServletRequest request,
				                          @RequestParam("paper_title") String paper_title
				                         ){
			response.setCharacterEncoding("utf-8");
			
			
			pagePapers = paperService.getPapersByTitle(paper_title);
			
			ModelAndView view = new ModelAndView("home/teacherPaper/teacher_paper_search");
			
			//将单个教师的论文集合返回给前端界面
			view.addObject("pagePapers", pagePapers);
			
			return view;
		}
		
		
		
		//处理数据，将老师填写论文信息插入到数据库
		@RequestMapping(value="addPaper",method=RequestMethod.POST)
		public ModelAndView addPaper(
				             HttpSession session,
				             HttpServletResponse response,
				             HttpServletRequest request,
				             @RequestParam("paper_status") String paper_status,
				             @RequestParam("paper_department") String paper_department,
				             @RequestParam("paper_first_author") String paper_first_author ,
				             @RequestParam("paper_second_author") String paper_second_author ,
				             @RequestParam("paper_third_author") String paper_third_author ,
				             @RequestParam("paper_title") String paper_title ,
				             @RequestParam("paper_period") String paper_period ,
				             @RequestParam("paper_period_roll") String paper_period_roll ,
				             @RequestParam("paper_period_page") String paper_period_page ,
				             @RequestParam("paper_department_kind") String paper_department_kind,
				             @RequestParam("paper_department_count") String paper_department_count ,
				             @RequestParam("paper_first_author_unit") String paper_first_author_unit ,
				             @RequestParam("paper_is_English") String paper_is_English ,
				             @RequestParam("paper_second_author_unit") String paper_second_author_unit ,
				             @RequestParam("paper_third_author_unit") String paper_third_author_unit ,
				             @RequestParam("upfile")  MultipartFile upfile
				             ){
			response.setCharacterEncoding("utf-8");
			//教师工号记录
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
			ModelAndView view = new ModelAndView("home/teacherPaper/teacher_paper");
			
			//首先判断论文题目是否已经存在
			Paper paper = paperService.getPaperByTitleAndNum(paper_title, teacher_num);
			
			if(paper==null){
				//返回相关信息
				
				view.addObject("result", "<script>alert('填报成功!')</script>");
			
				//其它变量的处理
				//确定文件名并且要具有唯一性
				String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
				
				//文件存储的名字
				String paper_path=teacher_num+"-"+date+"-"+"科研论文"+upfile.getOriginalFilename();   
				//将上传的文件保存到服务器目录下
				ComFunctions.upload(upfile, session, response, paper_path);
				//提交时间处理
				Date paper_date= new Date();
																									
				//将数据记录插入到数据库
				paperService.insertPaper(
						                 Integer.parseInt(paper_status), 
						                 paper_department, 
						                 paper_first_author, 
						                 paper_second_author, 
						                 paper_third_author, 
						                 paper_title, 
						                 paper_period, 
						                 paper_period_roll, 
						                 paper_period_page, 
						                 paper_department_kind, 
						                 paper_department_count, 
						                 paper_path,
						                 paper_first_author_unit, 
						                 Integer.parseInt(paper_is_English), 
						                 paper_second_author_unit, 
						                 paper_third_author_unit, 
						                 paper_date,
						                 teacher_num
						                 );
				//更新数据集合
				//allPapers = paperService.getPapersByNum(teacher_num);
				
			}else{
					
				//System.out.println("和第三个煽风点火党纪国法");
				view.addObject("result", "<script>alert('该论文题目已经存在!')</script>");
				
			}
			
			/*
			 通过期刊名判断该篇论文属于哪一个期刊库然后进行等级评判
			 并把审核结果数据表进行更新
			 
			 这一步是很关键和重要的一步，不得有差错		 
			 */
			
			int is_in_own=0;
			int is_in_peking=0;
			int is_in_scd=0;
			int is_in_ssci=0;
			
			if(ownLibraryService.selectByName(paper_period)!=null){
				is_in_own=1;
			}
			if(pekingLibraryService.selectByPekingName(paper_period)!=null){
				is_in_peking=1;
			}
			if(scdLibraryService.selectByScdName(paper_period)!=null){
				is_in_scd=1;
			}
			if(ssciLibraryService.selectBySsciChineseName(paper_period)!=null){
				is_in_ssci=1;
			}
			
			teacherPaperCheckResultService.insertPaperCheckResult(
					                                             is_in_own, 
					                                             is_in_peking, 
					                                             is_in_scd, 
					                                             is_in_ssci, 
					                                             1, 
					                                             "还未审核", 
					                                             "", 
					                                             "还未审核", 
					                                             paper_title, 
					                                             teacher_num
					                                             ); 
			
			
			
			
			
							
			return view;
		}
		//科研论文修改页面入口
		@RequestMapping(value="/modify_paper")
		public ModelAndView modify_paper( 
				 HttpServletResponse response,
	             HttpServletRequest request
	            
				){
			response.setCharacterEncoding("utf-8");
			
			String paper_title=null;
			try {
				//采用这种方式获取传递的参数，防止出现乱码
				paper_title = new String(request.getParameter("paper_title").getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//获取教师登录的账号
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
			//测试
			System.out.println("===========>"+paper_title);
			Paper paper = paperService.getPaperByTitleAndNum(paper_title, teacher_num);
			
			ModelAndView view = new ModelAndView("home/teacherPaper/teacher_paper_modify");
			view.addObject("departs", departs);
			view.addObject("paper", paper);
			return view;
		}
		//科研论文修改并保存
		@RequestMapping(value="/modify_save_paper")
		public ModelAndView modify_save_paper(
				                             HttpSession session,
	                                         HttpServletResponse response,
	                                         HttpServletRequest request,
	                                         @RequestParam("paper_id") String paper_id,
								             @RequestParam("paper_status") String paper_status,
								             @RequestParam("paper_department") String paper_department,
								             @RequestParam("paper_first_author") String paper_first_author ,
								             @RequestParam("paper_second_author") String paper_second_author ,
								             @RequestParam("paper_third_author") String paper_third_author ,
								             @RequestParam("paper_title") String paper_title ,
								             @RequestParam("paper_period") String paper_period ,
								             @RequestParam("paper_period_roll") String paper_period_roll ,
								             @RequestParam("paper_period_page") String paper_period_page ,
								             @RequestParam("paper_department_kind") String paper_department_kind,
								             @RequestParam("paper_department_count") String paper_department_count ,
								             @RequestParam("paper_first_author_unit") String paper_first_author_unit ,
								             @RequestParam("paper_is_English") String paper_is_English ,
								             @RequestParam("paper_second_author_unit") String paper_second_author_unit ,
								             @RequestParam("paper_third_author_unit") String paper_third_author_unit ,
								             @RequestParam("upfile")  MultipartFile upfile
				                              ){
			response.setCharacterEncoding("utf-8");
			ModelAndView view = new ModelAndView("home/teacherPaper/teacher_paper_modify");
			
			
			//教师工号记录
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
			//获取文件名称的id号
			String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			
			//文件存储的名字
			String paper_path=teacher_num+"-"+date+"-"+"科研论文"+upfile.getOriginalFilename();   
			//将上传的文件保存到服务器目录下
			ComFunctions.upload(upfile, session, response, paper_path);
			System.out.println("修改数据到数据库==================paper_title"+paper_title);
			//开始修改数据
			paperService.updatePaper(Integer.parseInt(paper_id),
					                 Integer.parseInt(paper_status),
					                 paper_department, 
					                 paper_first_author, 
					                 paper_second_author, 
					                 paper_third_author, 
					                 paper_title, 
					                 paper_period, 
					                 paper_period_roll, 
					                 paper_period_page, 
					                 paper_department_kind,
					                 paper_department_count,
					                 paper_path, 
					                 paper_first_author_unit,
					                 Integer.parseInt(paper_is_English),
					                 paper_second_author_unit, 
					                 paper_third_author_unit, 
					                 teacher_num);
			//更新数据集合
			allPapers = paperService.getPapersByNum(teacher_num);
			
			view.addObject("result", "<script>alert('修改成功!')</script>");
			//修改成功之后并将数据返回前台
			Paper paper = paperService.getPaperByTitleAndNum(paper_title, teacher_num);
			view.addObject("paper", paper);	
			view.addObject("departs", departs);
			return view;
		}
}
