package com.njtechjgxy.home.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.njtechjgxy.service.DepartmentService;
import com.njtechjgxy.service.TeachingPaperCheckResultService;
import com.njtechjgxy.service.TeachingPaperService;
import com.njtechjgxy.service.library.OwnLibraryService;
import com.njtechjgxy.service.library.PekingLibraryService;
import com.njtechjgxy.service.library.ScdLibraryService;
import com.njtechjgxy.service.library.SsciLibraryService;
import com.njtechjgxy.vo.Department;
import com.njtechjgxy.vo.Page;
import com.njtechjgxy.vo.Paper;
import com.njtechjgxy.vo.TeachingPaper;


@Controller
@RequestMapping(value="/teaching_paper")
public class teachingAndResearchController {

	
	    @Autowired
	    private DepartmentService departmentService;
	    @Autowired
	    private TeachingPaperService teachingPaperService;
	    @Autowired
	    private TeachingPaperCheckResultService teachingPaperCheckResultService;
	    
	    
	    //期刊库的接口类定义
	    @Autowired
	    private OwnLibraryService ownLibraryService;
	    @Autowired
	    private PekingLibraryService pekingLibraryService;
	    @Autowired 
	    private ScdLibraryService scdLibraryService;
	    @Autowired
	    private SsciLibraryService ssciLibraryService;
	    //定义系的集合变量
	    private List<Department> departs = null;
	    
	    private TeachingPaper teachingPaper = null;
	    
	    private List<TeachingPaper> teachingPapers = null;
	    //分页类定义
	    private Page<TeachingPaper> page=null;
	    //每一页的论文集合定义
	    private List<TeachingPaper> pageTeachingPapers = null;
	    
	    
	    @RequestMapping(value="/index")
	    public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			
		    ModelAndView view = new ModelAndView("home/teachingAndResearchPaper/teaching_paper_submit");
		    
		    departs = departmentService.getDeparts();
		    view.addObject("departs", departs);
		    
			return view;
		}
	    @RequestMapping(value="/addPaper",method=RequestMethod.POST)
	    public ModelAndView addPaper( 
							    	   HttpSession session,
							           HttpServletResponse response,
							           HttpServletRequest request,
							           @RequestParam("paper_status") int paper_status,
							           @RequestParam("paper_department") String paper_department,
							           @RequestParam("paper_first_author") String paper_first_author,
							           @RequestParam("paper_first_author_unit") String paper_first_author_unit,
							           @RequestParam("paper_second_author") String paper_second_author,
							           @RequestParam("paper_second_author_unit") String paper_second_author_unit,
							           @RequestParam("paper_third_author") String paper_third_author,
							           @RequestParam("paper_third_author_unit") String paper_third_author_unit,
							           @RequestParam("paper_title") String paper_title,
							           @RequestParam("paper_period") String paper_period,
							           @RequestParam("paper_period_roll") String paper_period_roll,
							           @RequestParam("paper_period_page") String paper_period_page,
							           @RequestParam("paper_department_kind") String paper_department_kind,
							           @RequestParam("upfile")  MultipartFile upfile
	    		
	    		                     ){
	    	response.setCharacterEncoding("utf-8");
	    	
	    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	String paper_time = df.format(new Date());
	    	String teacher_num = (String)request.getSession().getAttribute("teacher_num");
	    	ModelAndView view = new ModelAndView("home/teachingAndResearchPaper/teaching_paper_submit");
	    	
	    	
	    	//首先判断教研论文是否已经存在
	    	teachingPaper = teachingPaperService.getTeachingPaperByTitleAndNum(teacher_num, paper_title);
	        //说明这个教室还未填报该教研论文
	    	if(teachingPaper==null){
	    		
	    		view.addObject("result", "<script>alert('填报成功!')</script>");
	    		
	    		//其它变量的处理
				//确定文件名并且要具有唯一性
				String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
				
				//文件存储的名字
				String paper_path=teacher_num+"-"+date+"-"+"教研论文"+upfile.getOriginalFilename();   
				//将上传的文件保存到服务器目录下
				ComFunctions.upload(upfile, session, response, paper_path);
	    		
				teachingPaperService.insertTeachingAndResearch(
						                                      paper_status, 
						                                      paper_department, 
						                                      paper_first_author, 
						                                      paper_first_author_unit, 
						                                      paper_second_author, 
						                                      paper_second_author_unit, 
						                                      paper_third_author, 
						                                      paper_third_author_unit, 
						                                      paper_title, 
						                                      paper_period, 
						                                      paper_period_roll, 
						                                      paper_period_page, 
						                                      paper_path, 
						                                      paper_department_kind, 
						                                      new Date(), 
						                                      teacher_num);
	    	}else{
	    		
	    		view.addObject("result", "<script>alert('该论文题目已经存在!')</script>");
	    	}
	    	/*
	    	 * 
	    	 * 根据教师录入的信息更新教研论文审核信息表
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
	    	
			teachingPaperCheckResultService.insertPaperCheckResult(
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
			
			departs = departmentService.getDeparts();
		    view.addObject("departs", departs);
	    	
	    	return view;
	    }
	    			
	    //教研论文搜索界面
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
				
			    teachingPapers = teachingPaperService.getAllTeachingPapersByNum(teacher_num);
				
			
			    ModelAndView view = new ModelAndView("home/teachingAndResearchPaper/teaching_paper_search");
			    
			    if(page==null){
			    	  page = new Page<TeachingPaper>(0,3,teachingPapers.size(),teachingPapers);
			    }else{
			    	  page.setAllNum(teachingPapers.size());
			    	  page.setDatas(teachingPapers);
			    }
			  
			    
			    if(which.equals("pre")){
			    	pageTeachingPapers = page.prePage();
				}else if(which.equals("next")){
					pageTeachingPapers = page.nextPage();
				}else{
					pageTeachingPapers = page.firstPage();
				}		   		    	  
					
			//将单个教师的论文集合返回给前端界面
			view.addObject("pageTeachingPapers", pageTeachingPapers);
			
			return view;
		}
	    
	  //修改教研论文修改页面入口
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
			teachingPaper = teachingPaperService.getTeachingPaperByTitleAndNum(teacher_num, paper_title);
			departs = departmentService.getDeparts();
			
			ModelAndView view = new ModelAndView("home/teachingAndResearchPaper/teaching_paper_modify");
			view.addObject("departs", departs);
			view.addObject("teachingPaper", teachingPaper);
			return view;
		}  
	    //保存修改后的教研论文
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
	             @RequestParam("paper_first_author_unit") String paper_first_author_unit ,
	             @RequestParam("paper_second_author_unit") String paper_second_author_unit ,
	             @RequestParam("paper_third_author_unit") String paper_third_author_unit ,
	             @RequestParam("upfile")  MultipartFile upfile
                 ){
                 response.setCharacterEncoding("utf-8");
                 ModelAndView view = new ModelAndView("home/teachingAndResearchPaper/teaching_paper_modify");
                 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     	    	 String paper_time = df.format(new Date());

                 //教师工号记录
                 String teacher_num = (String)request.getSession().getAttribute("teacher_num");
                 //获取文件名称的id号
                 String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

                 //文件存储的名字
                 String paper_path=teacher_num+"-"+date+"-"+"教研论文"+upfile.getOriginalFilename();   
                //将上传的文件保存到服务器目录下
                ComFunctions.upload(upfile, session, response, paper_path);
                System.out.println("修改数据到数据库==================paper_title"+paper_title);
               //开始修改数据
                teachingPaperService.updateTeachingAndResearchByTitleAndNum(
                		                                                    Integer.parseInt(paper_status), 
                		                                                    paper_department, 
                		                                                    paper_first_author, 
                		                                                    paper_first_author_unit, 
                		                                                    paper_second_author, 
                		                                                    paper_second_author_unit, 
                		                                                    paper_third_author, 
                		                                                    paper_third_author_unit, 
                		                                                    paper_title, 
                		                                                    paper_period, 
                		                                                    paper_period_roll, 
                		                                                    paper_period_page, 
                		                                                    paper_path, 
                		                                                    paper_department_kind, 
                		                                                    new Date(), 
                		                                                    teacher_num);


                        view.addObject("result", "<script>alert('修改成功!')</script>");
						//修改成功之后并将数据返回前台
						TeachingPaper teachingPaper =  teachingPaperService.getTeachingPaperByTitleAndNum(teacher_num, paper_title);
						departs = departmentService.getDeparts();
						view.addObject("teachingPaper", teachingPaper);	
						view.addObject("departs", departs);
						return view;
			}
	    
	    
	
}
