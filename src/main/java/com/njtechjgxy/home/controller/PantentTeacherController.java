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
	
	   //���뾺������д��Ϣ����
		@RequestMapping(value="/index")
		public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			ModelAndView view = null;
			
			
			String path=null;
			//����ʹ��
			System.out.println("==="+request.getSession().getAttribute("teacher_num"));
			//�жϽ�ʦ�Ƿ� �Ѿ���¼����ֹ�Ƿ��û�������ҳ��
			if(request.getSession().getAttribute("teacher_num")==null){
				view = new ModelAndView("home/teacher_login");
			}else{
				
				departs = departmentService.getDeparts();
				view = new ModelAndView("home/teacherPatent/teacher_patent");
				view.addObject("departs", departs);
			}
			return view;
		}
		
		//�����ʦ��д����Ϣ����
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
			//��ʦ���ż�¼
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
			Patent tempPatent = null;
			
			tempPatent = patentService.getPatent(teacher_num, patent_title);
			
			if(tempPatent==null){
				
			   
				
				view.addObject("result", "<script>alert('��ɹ�!')</script>");
				
				//���������Ĵ���
				//ȷ���ļ�������Ҫ����Ψһ��
				String patent_date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
				
				//�ļ��洢������
				String patent_path=teacher_num+"-"+patent_date+"-"+"ר���걨"+upfile.getOriginalFilename();   
				//���ϴ����ļ����浽������Ŀ¼��
				ComFunctions.upload(upfile, session, response, patent_path);
				//�����ݼ�¼���뵽���ݿ�
				
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
					                                        "��δ���", 
					                                        "��δ���", 
					                                        "", 
					                                        patent_title, 
					                                        teacher_num);
			}else{
				
				view.addObject("result", "<script>alert('�Ѿ��!')</script>");	
				
			}
			
			departs = departmentService.getDeparts();
			view.addObject("departs", departs);
			
			return view;
		}
	//����ר������
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
					
			//��������ʦ�����ļ��Ϸ��ظ�ǰ�˽���
			view.addObject("pagePatents", pagePatents);
			
			return view;
		}	
		
		//�����޸����ݲ���
		@RequestMapping(value="/modify_patent")
		public ModelAndView modify_prize(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			ModelAndView view = null;
			String patent_title=null;
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");			
			
			//�жϽ�ʦ�Ƿ� �Ѿ���¼����ֹ�Ƿ��û�������ҳ��
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
		//�����ʦ��д����Ϣ����
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
					//��ʦ���ż�¼
					String teacher_num = (String)request.getSession().getAttribute("teacher_num");
					
					
												
						view.addObject("result", "<script>alert('�޸ĳɹ�!')</script>");
						
						//���������Ĵ���
						//ȷ���ļ�������Ҫ����Ψһ��
						String patent_date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
						
						//�ļ��洢������
						String patent_path=teacher_num+"-"+patent_date+"-"+"ר���걨"+upfile.getOriginalFilename();   
						//���ϴ����ļ����浽������Ŀ¼��
						ComFunctions.upload(upfile, session, response, patent_path);
						//�����ݼ�¼���뵽���ݿ�
						
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
