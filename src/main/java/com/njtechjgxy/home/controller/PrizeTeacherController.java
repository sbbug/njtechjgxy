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
import com.njtechjgxy.service.PrizeCheckResultService;
import com.njtechjgxy.service.PrizeService;
import com.njtechjgxy.vo.Book;
import com.njtechjgxy.vo.Department;
import com.njtechjgxy.vo.Page;
import com.njtechjgxy.vo.Prize;


@Controller
@RequestMapping(value="/tea_prize")
public class PrizeTeacherController {

	   
	  @Autowired 
	  private DepartmentService departmentService;
	  @Autowired
	  private PrizeService prizeService;
	  @Autowired
	  private PrizeCheckResultService prizeCheckResultService;
	
	   private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	   private List<Department> departs = null;
	   private Prize prize = null;
	   private List<Prize> prizes = null;
	   private Page<Prize> page = null;
	
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
				view = new ModelAndView("home/teacherPrize/teacher_prize");
				view.addObject("departs", departs);
			}
			return view;
		}
	
		//保存教师填写的信息方法
				@RequestMapping(value="/addPrize")
				public ModelAndView addPrize(
						                    HttpServletResponse response,
						                    HttpServletRequest request,
						                    HttpSession session,
						                    @RequestParam("prize_status") String prize_status,						                 
						                    @RequestParam("prize_department") String prize_department,
						                    @RequestParam("prize_member_one") String prize_member_one,
						                    @RequestParam("prize_member_two") String prize_member_two,
						                    @RequestParam("prize_member_three") String prize_member_three,
						                    @RequestParam("prize_name") String prize_name,
						                    @RequestParam("prize_give_unit") String prize_give_unit,
						                    @RequestParam("prize_rank") String prize_rank,
						                    @RequestParam("prize_get_time") String prize_get_time,
						                    @RequestParam("prize_remark") String prize_remark,					                  			                
						                    @RequestParam("upfile")  MultipartFile upfile
						                   ){
					response.setCharacterEncoding("utf-8");
					ModelAndView view  = new ModelAndView("home/teacherPrize/teacher_prize");
					//教师工号记录
					String teacher_num = (String)request.getSession().getAttribute("teacher_num");
																								
						
						view.addObject("result", "<script>alert('填报成功!')</script>");
						
						//其它变量的处理
						//确定文件名并且要具有唯一性
						String prize_date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
						
						//文件存储的名字
						String prize_path=teacher_num+"-"+prize_date+"-"+"书籍申报"+upfile.getOriginalFilename();   
						//将上传的文件保存到服务器目录下
						ComFunctions.upload(upfile, session, response, prize_path);
						//将数据记录插入到数据库
						Date prize_time=null;
						Date date=null;
						try {
							prize_time = sf.parse(prize_get_time);
							date = sf.parse(prize_date);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String prize_uuid = UUID.randomUUID().toString().replace("-", "");
						prizeService.insertPrize(
								                 Integer.parseInt(prize_status), 
								                 prize_department, 
								                 prize_member_one, 
								                 prize_member_two, 
								                 prize_member_three,
								                 prize_name, 
								                 prize_give_unit, 
								                 prize_rank,
								                 prize_time,
								                 prize_remark,
								                 prize_path, 
								                 date,
								                 teacher_num,
								                 prize_uuid                 
								);
						
					
				    prizeCheckResultService.insertPrizeCheckResult(
				    		                                       1, 
				    		                                       "还未审核", 
				    		                                       "还未审核", 
				    		                                       prize_uuid, 
				    		                                       teacher_num);
					
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
					   prizes = prizeService.getPrizeByNum(teacher_num);
						
						
					
					    ModelAndView view = new ModelAndView("home/teacherPrize/teacher_prize_search");
					    
					    if(page==null){
					    	  page = new Page<Prize>(0,3,prizes.size(),prizes);
					    }else{
					    	  page.setAllNum(prizes.size());
					    	  page.setDatas(prizes);
					    }
					  
					    
					    if(which.equals("pre")){
					    	prizes = page.prePage();
						}else if(which.equals("next")){
							prizes = page.nextPage();
						}else{
							prizes = page.firstPage();
						}		   		    	  
							
					//将单个教师的论文集合返回给前端界面
					view.addObject("pagePrizes", prizes);
					
					return view;
				}	
				
				//进入修改数据部分
				@RequestMapping(value="/modify_prize")
				public ModelAndView modify_prize(HttpServletResponse response,HttpServletRequest request){
					response.setCharacterEncoding("utf-8");
					ModelAndView view = null;
					String prize_uuid=null;
					String teacher_num = (String)request.getSession().getAttribute("teacher_num");			
					
					//判断教师是否 已经登录，防止非法用户进入主页面
					if(request.getSession().getAttribute("teacher_num")==null){
						view = new ModelAndView("home/teacher_login");
					}else{
						
						try {
							prize_uuid = new String(request.getParameter("prize_uuid").getBytes("iso-8859-1"),"utf-8");
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						prize = prizeService.getPrizeByNumAndId(teacher_num, prize_uuid);
						
						
						departs = departmentService.getDeparts();
						view = new ModelAndView("home/teacherPrize/teacher_prize_modify");
						view.addObject("departs", departs);
						view.addObject("prize", prize);
					}
					return view;
				}
				
				//保存修改后的信息	
				@RequestMapping(value="/modify_save_prize")
				public ModelAndView modify_save_prize(
						                    HttpServletResponse response,
						                    HttpServletRequest request,
						                    HttpSession session,					              
						                    @RequestParam("prize_status") String prize_status,						                 
						                    @RequestParam("prize_department") String prize_department,
						                    @RequestParam("prize_member_one") String prize_member_one,
						                    @RequestParam("prize_member_two") String prize_member_two,
						                    @RequestParam("prize_member_three") String prize_member_three,
						                    @RequestParam("prize_name") String prize_name,
						                    @RequestParam("prize_give_unit") String prize_give_unit,
						                    @RequestParam("prize_rank") String prize_rank,
						                    @RequestParam("prize_get_time") String prize_get_time,
						                    @RequestParam("prize_remark") String prize_remark,
						                    @RequestParam("prize_uuid") String prize_uuid,
						                    @RequestParam("upfile")  MultipartFile upfile
						                   ){
					response.setCharacterEncoding("utf-8");
					ModelAndView view  = new ModelAndView("home/teacherPrize/teacher_prize_modify");
					//教师工号记录
					String teacher_num = (String)request.getSession().getAttribute("teacher_num");
																													
					view.addObject("result", "<script>alert('修改成功!')</script>");
						
					//其它变量的处理
					//确定文件名并且要具有唯一性
					String prize_date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
						
					//文件存储的名字
					String prize_path=teacher_num+"-"+prize_date+"-"+"获奖申报"+upfile.getOriginalFilename();   
						//将上传的文件保存到服务器目录下
					ComFunctions.upload(upfile, session, response, prize_path);
						//将数据记录插入到数据库
					
					//首先数据格式转换
					Date prize_time=null;
					Date date=null;
					try {
						prize_time = sf.parse(prize_get_time);
						date = sf.parse(prize_date);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("=================================="+prize_time);	
					prizeService.updatePrize(
							                Integer.parseInt(prize_status),
							                prize_department, 
							                prize_member_one,
							                prize_member_two,
							                prize_member_three, 
							                prize_name, 
							                prize_give_unit,
							                prize_rank, 
							                prize_time, 
							                prize_remark, 
							                prize_path,
							                date, 
							                teacher_num, 
							                prize_uuid);
																									
					departs = departmentService.getDeparts();
					prize = prizeService.getPrizeByNumAndId(teacher_num, prize_uuid);
					view.addObject("departs", departs);
					view.addObject("prize", prize);
					return view;
				}	
}
