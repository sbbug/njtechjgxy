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
	    //�ڿ���Ľӿ��ඨ��
	    @Autowired
	    private OwnLibraryService ownLibraryService;
	    @Autowired
	    private PekingLibraryService pekingLibraryService;
	    @Autowired 
	    private ScdLibraryService scdLibraryService;
	    @Autowired
	    private SsciLibraryService ssciLibraryService;
	    
	        
	    //רҵϵ�ļ��϶���
	    private List<Department> departs = null;
	    //������ʦ�������ļ��϶���
	    private List<Paper> allPapers = null;
	   //ÿһҳ�����ļ��϶���
	    private List<Paper> pagePapers = null;
	    //��ҳ�ඨ��
	    private Page<Paper> page=null;
	    
	    
	    
	    //�����ύҳ�����
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
		//�������������������
		//�����������ݵ���ʾ�����ڴ��ҳʵ�֣�����ֻ���ǵ�����Ŀ�Ƚ�С��û�п�����Ŀ̫��
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
					
			//��������ʦ�����ļ��Ϸ��ظ�ǰ�˽���
			view.addObject("pagePapers", pagePapers);
			
			return view;
		}
		//����������������
		@RequestMapping(value="/search_by_title")
		public ModelAndView searchByTitle(HttpServletResponse response,
				                          HttpServletRequest request,
				                          @RequestParam("paper_title") String paper_title
				                         ){
			response.setCharacterEncoding("utf-8");
			
			
			pagePapers = paperService.getPapersByTitle(paper_title);
			
			ModelAndView view = new ModelAndView("home/teacherPaper/teacher_paper_search");
			
			//��������ʦ�����ļ��Ϸ��ظ�ǰ�˽���
			view.addObject("pagePapers", pagePapers);
			
			return view;
		}
		
		
		
		//�������ݣ�����ʦ��д������Ϣ���뵽���ݿ�
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
			//��ʦ���ż�¼
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
			ModelAndView view = new ModelAndView("home/teacherPaper/teacher_paper");
			
			//�����ж�������Ŀ�Ƿ��Ѿ�����
			Paper paper = paperService.getPaperByTitleAndNum(paper_title, teacher_num);
			
			if(paper==null){
				//���������Ϣ
				
				view.addObject("result", "<script>alert('��ɹ�!')</script>");
			
				//���������Ĵ���
				//ȷ���ļ�������Ҫ����Ψһ��
				String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
				
				//�ļ��洢������
				String paper_path=teacher_num+"-"+date+"-"+"��������"+upfile.getOriginalFilename();   
				//���ϴ����ļ����浽������Ŀ¼��
				ComFunctions.upload(upfile, session, response, paper_path);
				//�ύʱ�䴦��
				Date paper_date= new Date();
																									
				//�����ݼ�¼���뵽���ݿ�
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
				//�������ݼ���
				//allPapers = paperService.getPapersByNum(teacher_num);
				
			}else{
					
				//System.out.println("�͵�����ɿ���𵳼͹���");
				view.addObject("result", "<script>alert('��������Ŀ�Ѿ�����!')</script>");
				
			}
			
			/*
			 ͨ���ڿ����жϸ�ƪ����������һ���ڿ���Ȼ����еȼ�����
			 ������˽�����ݱ���и���
			 
			 ��һ���Ǻܹؼ�����Ҫ��һ���������в��		 
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
					                                             "��δ���", 
					                                             "", 
					                                             "��δ���", 
					                                             paper_title, 
					                                             teacher_num
					                                             ); 
			
			
			
			
			
							
			return view;
		}
		//���������޸�ҳ�����
		@RequestMapping(value="/modify_paper")
		public ModelAndView modify_paper( 
				 HttpServletResponse response,
	             HttpServletRequest request
	            
				){
			response.setCharacterEncoding("utf-8");
			
			String paper_title=null;
			try {
				//�������ַ�ʽ��ȡ���ݵĲ�������ֹ��������
				paper_title = new String(request.getParameter("paper_title").getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//��ȡ��ʦ��¼���˺�
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
			//����
			System.out.println("===========>"+paper_title);
			Paper paper = paperService.getPaperByTitleAndNum(paper_title, teacher_num);
			
			ModelAndView view = new ModelAndView("home/teacherPaper/teacher_paper_modify");
			view.addObject("departs", departs);
			view.addObject("paper", paper);
			return view;
		}
		//���������޸Ĳ�����
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
			
			
			//��ʦ���ż�¼
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
			//��ȡ�ļ����Ƶ�id��
			String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			
			//�ļ��洢������
			String paper_path=teacher_num+"-"+date+"-"+"��������"+upfile.getOriginalFilename();   
			//���ϴ����ļ����浽������Ŀ¼��
			ComFunctions.upload(upfile, session, response, paper_path);
			System.out.println("�޸����ݵ����ݿ�==================paper_title"+paper_title);
			//��ʼ�޸�����
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
			//�������ݼ���
			allPapers = paperService.getPapersByNum(teacher_num);
			
			view.addObject("result", "<script>alert('�޸ĳɹ�!')</script>");
			//�޸ĳɹ�֮�󲢽����ݷ���ǰ̨
			Paper paper = paperService.getPaperByTitleAndNum(paper_title, teacher_num);
			view.addObject("paper", paper);	
			view.addObject("departs", departs);
			return view;
		}
}
