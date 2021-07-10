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
	//������д��Ŀ��Ϣ����
		@RequestMapping(value="/index")
		public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			ModelAndView view = null;
			
						
			//����ʹ��
			System.out.println("==="+request.getSession().getAttribute("teacher_num"));
			//�жϽ�ʦ�Ƿ� �Ѿ���¼����ֹ�Ƿ��û�������ҳ��
			if(request.getSession().getAttribute("teacher_num")==null){
				view = new ModelAndView("home/teacher_login");
			}else{
				
				departs = departmentService.getDeparts();
				view = new ModelAndView("home/teacherAchievement/teacher_achievement");
				view.addObject("departs", departs);
			}
			return view;
		}
		//�ύ��Ϣ����
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
               //��ʦ���ż�¼
							String teacher_num = (String)request.getSession().getAttribute("teacher_num");
							
							achievement = achievementService.getAchievementsByNumAndTitle(teacher_num, achieve_title);
											
							//��book==nullʱ��˵����δ�
							if(achievement==null){
							
							view.addObject("result", "<script>alert('��ɹ�!')</script>");
							
							//���������Ĵ���
							//ȷ���ļ�������Ҫ����Ψһ��
							String achieve_date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
							
							//�ļ��洢������
							String achieve_path=teacher_num+"-"+achieve_date+"-"+"�ɹ��걨�걨"+upfile.getOriginalFilename();   
							//���ϴ����ļ����浽������Ŀ¼��
							ComFunctions.upload(upfile, session, response, achieve_path);
							//�����ݼ�¼���뵽���ݿ�
							//�������ݸ�ʽת��
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
							view.addObject("result", "<script>alert('�óɹ��Ѿ�����!')</script>");
							}
							achievementCheckResultService.insertTeachingAndSearchAchievementCheckResult("��δ���", "��δ���", 1, achieve_title, teacher_num);
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
							
					//��������ʦ�����ļ��Ϸ��ظ�ǰ�˽���
					view.addObject("pageAchievements", pageAchievements);
					
					return view;
				}
				
				//�����޸����ݲ���
				@RequestMapping(value="/modify_achieve")
				public ModelAndView modify(HttpServletResponse response,HttpServletRequest request){
					response.setCharacterEncoding("utf-8");
					ModelAndView view = null;
					String achieve_title=null;
					String teacher_num = (String)request.getSession().getAttribute("teacher_num");			
					
					//�жϽ�ʦ�Ƿ� �Ѿ���¼����ֹ�Ƿ��û�������ҳ��
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
				//�ύ��Ϣ����
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
		               //��ʦ���ż�¼
									String teacher_num = (String)request.getSession().getAttribute("teacher_num");
																																														
									view.addObject("result", "<script>alert('�޸ĳɹ�!')</script>");
									
									//���������Ĵ���
									//ȷ���ļ�������Ҫ����Ψһ��
									String achieve_date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
									
									//�ļ��洢������
									String achieve_path=teacher_num+"-"+achieve_date+"-"+"�ɹ��걨"+upfile.getOriginalFilename();   
									//���ϴ����ļ����浽������Ŀ¼��
									ComFunctions.upload(upfile, session, response, achieve_path);
									//�����ݼ�¼���뵽���ݿ�
									//�������ݸ�ʽת��
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
