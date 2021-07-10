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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.njtechjgxy.service.AchievementCheckResultService;
import com.njtechjgxy.service.AchievementService;
import com.njtechjgxy.service.DepartmentService;
import com.njtechjgxy.vo.Achievement;
import com.njtechjgxy.vo.Book;
import com.njtechjgxy.vo.Department;
import com.njtechjgxy.vo.Page;

@Controller
@RequestMapping(value="/tea_achievement")
public class AchievementTeacherController {

	@Autowired 
	private DepartmentService departmentService;
    @Autowired
    private AchievementService achievementService;
    @Autowired
    private AchievementCheckResultService achievementCheckResultService;
	
	private List<Department> departs = null;
	private Achievement achievement=null;
	private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	private List<Achievement> achievements = null;
	private Page<Achievement> page = null;
	private List<Achievement> pageAchievements = null;
	//进入填写项目信息界面
		@RequestMapping(value="/index")
		public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			ModelAndView view = null;
			
						
			//测试使用
			System.out.println("==="+request.getSession().getAttribute("teacher_num"));
			//判断教师是否 已经登录，防止非法用户进入主页面
			if(request.getSession().getAttribute("teacher_num")==null){
				view = new ModelAndView("home/teacher_login");
			}else{
				
				departs = departmentService.getDeparts();
				view = new ModelAndView("home/teacherAchievement/teacher_achievement");
				view.addObject("departs", departs);
			}
			return view;
		}
		//提交信息保存
		@RequestMapping(value="/add_achievement")
		public ModelAndView add_achievement(
                HttpServletResponse response,
                HttpServletRequest request,
                HttpSession session,
                @RequestParam("achieve_status") String achieve_status,                             
                @RequestParam("achieve_department") String achieve_department,
                @RequestParam("achieve_teacher_name") String achieve_teacher_name,
                @RequestParam("achieve_remark") String achieve_remark,    
                @RequestParam("achieve_title") String achieve_title,
                @RequestParam("achieve_class") String achieve_class,
                @RequestParam("achieve_unit_awards") String achieve_unit_awards,
                @RequestParam("achieve_get_time") String achieve_get_time,
                @RequestParam("achieve_rank") String achieve_rank,
                @RequestParam("achieve_which") String achieve_which,			                
                @RequestParam("upfile")  MultipartFile upfile
               ){
               response.setCharacterEncoding("utf-8");
               ModelAndView view  = new ModelAndView("home/teacherAchievement/teacher_achievement");
               //教师工号记录
							String teacher_num = (String)request.getSession().getAttribute("teacher_num");
							
							achievement = achievementService.getAchievementsByNumAndTitle(teacher_num, achieve_title);
											
							//当book==null时，说明还未填报
							if(achievement==null){
							
							view.addObject("result", "<script>alert('填报成功!')</script>");
							
							//其它变量的处理
							//确定文件名并且要具有唯一性
							String achieve_date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
							
							//文件存储的名字
							String achieve_path=teacher_num+"-"+achieve_date+"-"+"成果申报申报"+upfile.getOriginalFilename();   
							//将上传的文件保存到服务器目录下
							ComFunctions.upload(upfile, session, response, achieve_path);
							//将数据记录插入到数据库
							//首先数据格式转换
							Date achieve_time=null;
							Date date=null;
							try {
								achieve_time = sf.parse(achieve_get_time);
								date = sf.parse(achieve_date);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							achievementService.insertAchievement(
									                            Integer.parseInt(achieve_status), 
									                            achieve_department, 
									                            achieve_teacher_name, 
									                            achieve_title, 
									                            achieve_class, 
									                            achieve_unit_awards, 
									                            achieve_time,
									                            achieve_rank, 
									                            achieve_remark, 
									                            achieve_which, 
									                            achieve_path, 
									                            date,
									                            teacher_num);
							
							
							}else{
							view.addObject("result", "<script>alert('该成果已经存在!')</script>");
							}
							achievementCheckResultService.insertTeachingAndSearchAchievementCheckResult("还未审核", "还未审核", 1, achieve_title, teacher_num);
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
						
					   achievements = achievementService.getAchievementsByNum(teacher_num);
						
					
					    ModelAndView view = new ModelAndView("home/teacherAchievement/teacher_achievement_search");
					    
					    if(page==null){
					    	  page = new Page<Achievement>(0,3,achievements.size(),achievements);
					    }else{
					    	  page.setAllNum(achievements.size());
					    	  page.setDatas(achievements);
					    }
					  
					    
					    if(which.equals("pre")){
					    	pageAchievements = page.prePage();
						}else if(which.equals("next")){
							pageAchievements = page.nextPage();
						}else{
							pageAchievements = page.firstPage();
						}		   		    	  
							
					//将单个教师的论文集合返回给前端界面
					view.addObject("pageAchievements", pageAchievements);
					
					return view;
				}
				
				//进入修改数据部分
				@RequestMapping(value="/modify_achieve")
				public ModelAndView modify(HttpServletResponse response,HttpServletRequest request){
					response.setCharacterEncoding("utf-8");
					ModelAndView view = null;
					String achieve_title=null;
					String teacher_num = (String)request.getSession().getAttribute("teacher_num");			
					
					//判断教师是否 已经登录，防止非法用户进入主页面
					if(request.getSession().getAttribute("teacher_num")==null){
						view = new ModelAndView("home/teacher_login");
					}else{
						
						try {
							achieve_title = new String(request.getParameter("achieve_title").getBytes("iso-8859-1"),"utf-8");
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						achievement = achievementService.getAchievementsByNumAndTitle(teacher_num, achieve_title);
						
						
						departs = departmentService.getDeparts();
						view = new ModelAndView("home/teacherAchievement/teacher_achievement_modify");
						view.addObject("departs", departs);
						view.addObject("achieve", achievement);
					}
					return view;
				}
				//提交信息保存
				@RequestMapping(value="/modify_save_achieve")
				public ModelAndView modify_save_achieve(
		                HttpServletResponse response,
		                HttpServletRequest request,
		                HttpSession session,
		                @RequestParam("achieve_id") String achieve_id,       
		                @RequestParam("achieve_status") String achieve_status,                             
		                @RequestParam("achieve_department") String achieve_department,
		                @RequestParam("achieve_teacher_name") String achieve_teacher_name,
		                @RequestParam("achieve_remark") String achieve_remark,    
		                @RequestParam("achieve_title") String achieve_title,
		                @RequestParam("achieve_class") String achieve_class,
		                @RequestParam("achieve_unit_awards") String achieve_unit_awards,
		                @RequestParam("achieve_get_time") String achieve_get_time,
		                @RequestParam("achieve_rank") String achieve_rank,
		                @RequestParam("achieve_which") String achieve_which,			                
		                @RequestParam("upfile")  MultipartFile upfile
		               ){
		               response.setCharacterEncoding("utf-8");
		               ModelAndView view  = new ModelAndView("home/teacherAchievement/teacher_achievement_modify");
		               //教师工号记录
									String teacher_num = (String)request.getSession().getAttribute("teacher_num");
																																														
									view.addObject("result", "<script>alert('修改成功!')</script>");
									
									//其它变量的处理
									//确定文件名并且要具有唯一性
									String achieve_date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
									
									//文件存储的名字
									String achieve_path=teacher_num+"-"+achieve_date+"-"+"成果申报"+upfile.getOriginalFilename();   
									//将上传的文件保存到服务器目录下
									ComFunctions.upload(upfile, session, response, achieve_path);
									//将数据记录插入到数据库
									//首先数据格式转换
									Date achieve_time=null;
									Date date=null;
									try {
										achieve_time = sf.parse(achieve_get_time);
										date = sf.parse(achieve_date);
									} catch (ParseException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									achievementService.updateAchievementByNumAndId(
											                                      Integer.parseInt(achieve_id), 
											                                      Integer.parseInt(achieve_status), 
											                                      achieve_department, 
											                                      achieve_teacher_name, 
											                                      achieve_title, 
											                                      achieve_class, 
											                                      achieve_unit_awards,
											                                      achieve_time, 
											                                      achieve_rank, 
											                                      achieve_remark, 
											                                      achieve_which,
											                                      achieve_path, 
											                                      date,
											                                      teacher_num);
									
									
									
								
									departs = departmentService.getDeparts();
									view.addObject("departs", departs);
									
									return view;
									}
}
