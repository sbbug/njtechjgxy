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
import com.njtechjgxy.service.ReformCheckResultService;
import com.njtechjgxy.service.ReformService;
import com.njtechjgxy.vo.Achievement;
import com.njtechjgxy.vo.Department;
import com.njtechjgxy.vo.Page;
import com.njtechjgxy.vo.Paper;
import com.njtechjgxy.vo.Reform;

@Controller
@RequestMapping(value="/tea_reform")
public class ReformTeacherController {

	
	@Autowired 
	private DepartmentService departmentService ;
	@Autowired
	private ReformService reformService;
	@Autowired
	private ReformCheckResultService reformCheckResultService;
	private List<Department> departs = null;
	private Reform reform = null;
	private List<Reform> allReforms = null;
	private List<Reform> pageReforms = null;
	private Page<Reform> page = null;
	private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	 //��ѧ�̸��ύҳ�����
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
      
		if(departs==null){
			 departs = departmentService.getDeparts();
		}		ModelAndView view = new ModelAndView("home/teacherReform/teacher_reform");

		
		view.addObject("departs", departs);
		view.addObject("result", "");
		return view;
	}
	   //��ѧ�̸��ύҳ�����
       @RequestMapping(value="/addReform",method=RequestMethod.POST) 		
  		public ModelAndView addReform(
  				                HttpSession session,
  				                HttpServletResponse response,
  				                HttpServletRequest request,
	  				            @RequestParam("reform_status") String reform_status,
					            @RequestParam("reform_department") String reform_department,
					            @RequestParam("reform_first_author") String reform_first_author,
					            @RequestParam("reform_second_author") String reform_second_author,
					            @RequestParam("reform_third_author") String reform_third_author,
					            @RequestParam("reform_other_author") String reform_other_author,
					            @RequestParam("reform_title") String reform_title,
					            @RequestParam("reform_give_reward_unit") String reform_give_reward_unit,
					            @RequestParam("reform_rank") String reform_rank,
					            @RequestParam("reform_money") String reform_money,
					            @RequestParam("reform_start_date") String reform_start_date,
					            @RequestParam("reform_end_date") String reform_end_date,
					            @RequestParam("reform_remark") String reform_remark,					            
  				                @RequestParam("upfile")  MultipartFile upfile
  				             ){
  			response.setCharacterEncoding("utf-8");
  			//��ʦ���ż�¼
  			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
  			ModelAndView view = new ModelAndView("home/teacherReform/teacher_reform");
  			Date start = null;
  			Date end = null;
  			Date date_time = null;
  			//�����ж�������Ŀ�Ƿ��Ѿ�����
  			reform = reformService.getReformsByNumAndTitle(teacher_num, reform_title);
  			
  			if(reform==null){
  				//���������Ϣ
  				
  				view.addObject("result", "<script>alert('��ɹ�!')</script>");
  			
  				//���������Ĵ���
  				//ȷ���ļ�������Ҫ����Ψһ��
  				String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
  				
  				//�ļ��洢������
  				String reform_path=teacher_num+"-"+date+"-"+"��ѧ�̸�"+upfile.getOriginalFilename();   
  				//���ϴ����ļ����浽������Ŀ¼��
  				ComFunctions.upload(upfile, session, response, reform_path);
  				try {
					start= sf.parse(reform_start_date);
					end = sf.parse(reform_end_date);
	  				date_time = sf.parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
  				
  				//�����ݼ�¼���뵽���ݿ�
  				reformService.insertReform(
  						                  Integer.parseInt(reform_status), 
  						                  reform_department, 
  						                  reform_first_author, 
  						                  reform_second_author, 
  						                  reform_third_author, 
  						                  reform_other_author, 
  						                  reform_title, 
  						                  reform_give_reward_unit, 
  						                  reform_rank, 
  						                  reform_money, 
  						                  start,
  						                  end,
  						                  reform_remark,
  						                  date_time,
  						                  reform_path, 
  						                  teacher_num);
  			
  				
  			}else{
  					
  				//System.out.println("�͵�����ɿ���𵳼͹���");
  				view.addObject("result", "<script>alert('����Ŀ�Ѿ�����!')</script>");
  				
  			}
  			
  			/*
  			 ͨ���ڿ����жϸ�ƪ����������һ���ڿ���Ȼ����еȼ�����
  			 ������˽�����ݱ���и���
  			 
  			 ��һ���Ǻܹؼ�����Ҫ��һ���������в��		 
  			 */
  			
  			reformCheckResultService.insertReformCheckResult(
  					                                         1,
  					                                         "��δ���", 
  					                                         "��δ���", 
  					                                         reform_title, 
  					                                         teacher_num);  			  			  			  			  			  	 			
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
				
			    allReforms  = reformService.getReformsByNum(teacher_num);
				
			
			    ModelAndView view = new ModelAndView("home/teacherReform/teacher_reform_search");
			    
			    if(page==null){
			    	  page = new Page<Reform>(0,3,allReforms.size(),allReforms);
			    }else{
			    	  page.setAllNum(allReforms.size());
			    	  page.setDatas(allReforms);
			    }
			  
			    
			    if(which.equals("pre")){
			    	pageReforms  = page.prePage();
				}else if(which.equals("next")){
					pageReforms  = page.nextPage();
				}else{
					pageReforms  = page.firstPage();
				}		   		    	  
					
			//��������ʦ�����ļ��Ϸ��ظ�ǰ�˽���
			view.addObject("pageReforms", pageReforms);
			
			return view;
		}
		//������Ϣ�޸Ľ���
		@RequestMapping(value="/modify_reform")
		public ModelAndView modify(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			ModelAndView view = null;
			String reform_title=null;
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");			
			
			//�жϽ�ʦ�Ƿ� �Ѿ���¼����ֹ�Ƿ��û�������ҳ��
			if(request.getSession().getAttribute("teacher_num")==null){
				view = new ModelAndView("home/teacher_login");
			}else{
				
				try {
					reform_title = new String(request.getParameter("reform_title").getBytes("iso-8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				reform = reformService.getReformsByNumAndTitle(teacher_num, reform_title);
				
				
				departs = departmentService.getDeparts();
				view = new ModelAndView("home/teacherReform/teacher_reform_modify");
				view.addObject("departs", departs);
				view.addObject("reform", reform);
			}
			return view;
		}
		//�����޸ĺ������
		@RequestMapping(value="/modify_save_reform")
		public ModelAndView modify_save_patent(
				                    HttpServletResponse response,
				                    HttpServletRequest request,
				                    HttpSession session,
				                    @RequestParam("reform_status") String reform_status,
						            @RequestParam("reform_department") String reform_department,
						            @RequestParam("reform_first_author") String reform_first_author,
						            @RequestParam("reform_second_author") String reform_second_author,
						            @RequestParam("reform_third_author") String reform_third_author,
						            @RequestParam("reform_other_author") String reform_other_author,
						            @RequestParam("reform_title") String reform_title,
						            @RequestParam("reform_give_reward_unit") String reform_give_reward_unit,
						            @RequestParam("reform_rank") String reform_rank,
						            @RequestParam("reform_money") String reform_money,
						            @RequestParam("reform_start_date") String reform_start_date,
						            @RequestParam("reform_end_date") String reform_end_date,
						            @RequestParam("reform_remark") String reform_remark,					            
	  				                @RequestParam("upfile")  MultipartFile upfile
				                   ){
			response.setCharacterEncoding("utf-8");
			ModelAndView view  = new ModelAndView("home/teacherReform/teacher_reform_modify");
			//��ʦ���ż�¼
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
			
			
										
				view.addObject("result", "<script>alert('�޸ĳɹ�!')</script>");
				
				//���������Ĵ���
				//ȷ���ļ�������Ҫ����Ψһ��
				String reform_date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
				
				//�ļ��洢������
				String reform_path=teacher_num+"-"+reform_date+"-"+"��ѧ�̸��걨"+upfile.getOriginalFilename();   
				//���ϴ����ļ����浽������Ŀ¼��
				ComFunctions.upload(upfile, session, response, reform_path);
				//�����ݼ�¼���뵽���ݿ�
				
				Date date=null;
				Date start_date=null;
				Date end_date = null;
				try {				
					date = sf.parse(reform_date);
					start_date = sf.parse(reform_start_date);
					end_date = sf.parse(reform_end_date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				reformService.updateReformByNumAndTitle(
						                                Integer.parseInt(reform_status), 
						                                reform_department, 
						                                reform_first_author, 
						                                reform_second_author, 
						                                reform_third_author, 
						                                reform_other_author, 
						                                reform_title, 
						                                reform_give_reward_unit,
						                                reform_rank,
						                                reform_money,
						                                start_date, 
						                                end_date, 
						                                reform_remark, 
						                                date,
						                                reform_path, 
						                                teacher_num);
				
			
			reform = reformService.getReformsByNumAndTitle(teacher_num, reform_title);	
								
			departs = departmentService.getDeparts();
			view.addObject("departs", departs);
			view.addObject("reform", reform);
			return view;
		}
		
		
}
