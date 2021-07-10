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
	    
	    
	    //�ڿ���Ľӿ��ඨ��
	    @Autowired
	    private OwnLibraryService ownLibraryService;
	    @Autowired
	    private PekingLibraryService pekingLibraryService;
	    @Autowired 
	    private ScdLibraryService scdLibraryService;
	    @Autowired
	    private SsciLibraryService ssciLibraryService;
	    //����ϵ�ļ��ϱ���
	    private List<Department> departs = null;
	    
	    private TeachingPaper teachingPaper = null;
	    
	    private List<TeachingPaper> teachingPapers = null;
	    //��ҳ�ඨ��
	    private Page<TeachingPaper> page=null;
	    //ÿһҳ�����ļ��϶���
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
	    	
	    	
	    	//�����жϽ��������Ƿ��Ѿ�����
	    	teachingPaper = teachingPaperService.getTeachingPaperByTitleAndNum(teacher_num, paper_title);
	        //˵��������һ�δ��ý�������
	    	if(teachingPaper==null){
	    		
	    		view.addObject("result", "<script>alert('��ɹ�!')</script>");
	    		
	    		//���������Ĵ���
				//ȷ���ļ�������Ҫ����Ψһ��
				String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
				
				//�ļ��洢������
				String paper_path=teacher_num+"-"+date+"-"+"��������"+upfile.getOriginalFilename();   
				//���ϴ����ļ����浽������Ŀ¼��
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
	    		
	    		view.addObject("result", "<script>alert('��������Ŀ�Ѿ�����!')</script>");
	    	}
	    	/*
	    	 * 
	    	 * ���ݽ�ʦ¼�����Ϣ���½������������Ϣ��
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
					                                              "��δ���", 
					                                              "", 
					                                              "��δ���", 
					                                              paper_title, 
					                                              teacher_num
					                                              );
			
			departs = departmentService.getDeparts();
		    view.addObject("departs", departs);
	    	
	    	return view;
	    }
	    			
	    //����������������
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
					
			//��������ʦ�����ļ��Ϸ��ظ�ǰ�˽���
			view.addObject("pageTeachingPapers", pageTeachingPapers);
			
			return view;
		}
	    
	  //�޸Ľ��������޸�ҳ�����
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
			teachingPaper = teachingPaperService.getTeachingPaperByTitleAndNum(teacher_num, paper_title);
			departs = departmentService.getDeparts();
			
			ModelAndView view = new ModelAndView("home/teachingAndResearchPaper/teaching_paper_modify");
			view.addObject("departs", departs);
			view.addObject("teachingPaper", teachingPaper);
			return view;
		}  
	    //�����޸ĺ�Ľ�������
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


                        view.addObject("result", "<script>alert('�޸ĳɹ�!')</script>");
						//�޸ĳɹ�֮�󲢽����ݷ���ǰ̨
						TeachingPaper teachingPaper =  teachingPaperService.getTeachingPaperByTitleAndNum(teacher_num, paper_title);
						departs = departmentService.getDeparts();
						view.addObject("teachingPaper", teachingPaper);	
						view.addObject("departs", departs);
						return view;
			}
	    
	    
	
}
