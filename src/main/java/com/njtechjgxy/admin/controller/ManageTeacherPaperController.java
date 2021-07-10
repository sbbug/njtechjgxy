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
import com.njtechjgxy.service.PaperService;
import com.njtechjgxy.service.TeacherPaperCheckResultService;
import com.njtechjgxy.vo.Page;
import com.njtechjgxy.vo.Paper;
import com.njtechjgxy.vo.PaperCheckResult;



@Controller
@RequestMapping(value="/admin_paper")
public class ManageTeacherPaperController {

		@Autowired
		private PaperService paperService;
		@Autowired
		private TeacherPaperCheckResultService teacherPaperCheckResultService ;
	
		private Page<Paper> page = null;
		private List<Paper> papers = null;
		private List<Paper> pagePapers = null;
	    private PaperCheckResult paperCheckResult;
	
		
	    //用于主页面显示的方法
		@RequestMapping(value="/show_paper")
		public ModelAndView index(
				                 HttpServletResponse response,
				                 HttpServletRequest request,
				                 @RequestParam(value = "which",required=true, defaultValue="hello") String  which
				                 ){
			response.setCharacterEncoding("utf-8");
			ModelAndView view  = new ModelAndView("admin/manageTeacherPaper/show_teacher_paper");
		    			
			papers = paperService.getAllPapers();
						
			if(page==null){
		    	  page = new Page<Paper>(0,6,papers.size(),papers);
		    }else{
		    	  page.setAllNum(papers.size());
		    	  page.setDatas(papers);
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
	
		//资料下载接口
		@RequestMapping(value="/download_data")
		public void download_date(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
						
			//获取下载的资料名
			String paper_path=null;
			try {
				//采用这种方式获取传递的参数，防止出现乱码
				paper_path = new String(request.getParameter("paper_path").getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   //调用资料下载方法
			ComFunctions.download(response, request, paper_path);
									
		}
		   //论文审核数据提取接口
				@RequestMapping(value="/get_paper_check")
				public ModelAndView get_paper_check(HttpServletResponse response,HttpServletRequest request){
					response.setCharacterEncoding("utf-8");
					
					ModelAndView view = new ModelAndView("admin/manageTeacherPaper/check_teacher_paper");
					
					
					//获取下载的资料名
					String paper_title=null;
					String teacher_num = null;
					try {
						//采用这种方式获取传递的参数，防止出现乱码
						paper_title = new String(request.getParameter("paper_title").getBytes("iso-8859-1"),"utf-8");
						teacher_num = new String(request.getParameter("teacher_num").getBytes("iso-8859-1"),"utf-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   
					paperCheckResult = teacherPaperCheckResultService.getPaperByPapernameAndTeachernum(paper_title, teacher_num);
					
					view.addObject("paperCheckResult", paperCheckResult);
					
					return view;						
				}
		     //论文审核数据保存接口
				@RequestMapping(value="/save_result")
				public ModelAndView save_result(
						                       HttpServletResponse response,
						                       HttpServletRequest request,
						                       @RequestParam("is_in_own") String is_in_own,
						                       @RequestParam("is_in_peking") String is_in_peking,
						                       @RequestParam("is_in_scd") String is_in_scd,
						                       @RequestParam("is_in_ssci") String is_in_ssci,
						                       @RequestParam("result_is_ok") String result_is_ok,
						                       @RequestParam("result_level") String result_level,
						                       @RequestParam("result_message") String result_message,
						                       @RequestParam("paper_title") String paper_title,
						                       @RequestParam("teacher_num") String teacher_num
						                       
						                       
						){
					response.setCharacterEncoding("utf-8");
					
					ModelAndView view = new ModelAndView("admin/manageTeacherPaper/check_teacher_paper");
					
					
					teacherPaperCheckResultService.updatePaperCheckResultByTeachernumAndPapername(
							                                                                     Integer.parseInt(is_in_own), 
							                                                                     Integer.parseInt(is_in_peking), 
							                                                                     Integer.parseInt(is_in_scd), 
							                                                                     Integer.parseInt(is_in_ssci), 
							                                                                     Integer.parseInt(result_is_ok),
							                                                                     "", 
							                                                                     result_level, 
							                                                                     result_message,
							                                                                     paper_title, 
							                                                                     teacher_num);
				   
					paperCheckResult = teacherPaperCheckResultService.getPaperByPapernameAndTeachernum(paper_title, teacher_num);
					
					view.addObject("paperCheckResult", paperCheckResult);
					view.addObject("result", "<script>alert('审核成功!')</script>");
					
					return view;						
				}	
		
		
		
}
