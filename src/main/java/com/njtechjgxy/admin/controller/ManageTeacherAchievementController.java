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
import com.njtechjgxy.service.AchievementCheckResultService;
import com.njtechjgxy.service.AchievementService;
import com.njtechjgxy.vo.Achievement;
import com.njtechjgxy.vo.AchievementCheckResult;
import com.njtechjgxy.vo.Book;
import com.njtechjgxy.vo.Page;
@Controller
@RequestMapping(value="/admin_achievement")
public class ManageTeacherAchievementController {

	@Autowired
	private AchievementService achievementService;
	@Autowired
	private AchievementCheckResultService achievementCheckResultService ;

	private Page<Achievement> page = null;
	private List<Achievement> achievements = null;
	private List<Achievement> pageAchievements = null;
    private AchievementCheckResult achievementCheckResult;
	
    //用于主页面显示的方法
   	@RequestMapping(value="/show_achievement")
   	public ModelAndView index(
   			                 HttpServletResponse response,
   			                 HttpServletRequest request,
   			                 @RequestParam(value = "which",required=true, defaultValue="hello") String  which
   			                 ){
   		response.setCharacterEncoding("utf-8");
   		ModelAndView view  = new ModelAndView("admin/manageTeacherAchievement/show_teacher_achievement");
   	    			
   		achievements = achievementService.getAchievements();
   					
   		if(page==null){
   	    	  page = new Page<Achievement>(0,6,achievements.size(),achievements);
   	    }else{
   	    	  page.setAllNum(achievements.size());
   	    	  page.setDatas(achievements);
   	    }		  
   	    
   	    if(which.equals("pre")){
   	    	pageAchievements = page.prePage();
   		}else if(which.equals("next")){
   			pageAchievements  = page.nextPage();
   		}else{
   			pageAchievements= page.firstPage();
   		}		   		    	  
   			
   	    //将单个教师的论文集合返回给前端界面
   	    view.addObject("pageAchievements",pageAchievements);
   		
   		
   		return view;
   	}
   	@RequestMapping(value="/download_data")
	public void download_date(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
					
		//获取下载的资料名
		String achieve_path=null;
		try {
			//采用这种方式获取传递的参数，防止出现乱码
			achieve_path = new String(request.getParameter("achieve_path").getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   //调用资料下载方法
		ComFunctions.download(response, request, achieve_path);
								
	}
    //论文审核数据提取接口
   	@RequestMapping(value="/get_achievement_check")
   	public ModelAndView get_paper_check(HttpServletResponse response,HttpServletRequest request){
   		response.setCharacterEncoding("utf-8");
   		
   		ModelAndView view = new ModelAndView("admin/manageTeacherAchievement/check_teacher_achievement");
   		
   		
   		//获取下载的资料名
   		String achieve_title=null;
   		String teacher_num = null;
   		try {
   			//采用这种方式获取传递的参数，防止出现乱码
   			achieve_title = new String(request.getParameter("achieve_title").getBytes("iso-8859-1"),"utf-8");
   			teacher_num = new String(request.getParameter("teacher_num").getBytes("iso-8859-1"),"utf-8");
   		} catch (UnsupportedEncodingException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   	   
   		achievementCheckResult = achievementCheckResultService.getAchievementCheckResultByNumAndId(teacher_num, achieve_title);
   		
   		view.addObject("achievementCheckResult", achievementCheckResult);
   		
   		return view;						
   	}
    //论文审核数据保存接口
   	@RequestMapping(value="/save_result")
   	public ModelAndView save_result(
   			                       HttpServletResponse response,
   			                       HttpServletRequest request,
   			                       @RequestParam("result_ranked") String result_ranked,
   			                       @RequestParam("result_message") String result_message,
   			                       @RequestParam("result_is_ok") String result_is_ok,		                     
   			                       @RequestParam("achieve_title") String achieve_title,
   			                       @RequestParam("teacher_num") String teacher_num
   			                       
   			){
   		response.setCharacterEncoding("utf-8");
   		
   		ModelAndView view = new ModelAndView("admin/manageTeacherAchievement/check_teacher_achievement");
   		achievementCheckResultService.updateAchieveCheckResultByTitleAndNum(result_ranked, Integer.parseInt(result_is_ok), achieve_title, teacher_num, result_message);		
   		
   		achievementCheckResult = achievementCheckResultService.getAchievementCheckResultByNumAndId(teacher_num, achieve_title);
   		view.addObject("achievementCheckResult", achievementCheckResult);
   		view.addObject("result", "<script>alert('审核成功!')</script>");
   		
   		return view;						
   	}	
}
