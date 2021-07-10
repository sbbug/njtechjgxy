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
import com.njtechjgxy.service.PrizeCheckResultService;
import com.njtechjgxy.service.PrizeService;
import com.njtechjgxy.vo.Achievement;
import com.njtechjgxy.vo.Page;
import com.njtechjgxy.vo.Prize;
import com.njtechjgxy.vo.PrizeCheckResult;

@Controller
@RequestMapping(value="/admin_prize")
public class ManageTeacherPrizeController {

	@Autowired
	private PrizeService prizeService;
	@Autowired
	private PrizeCheckResultService prizeCheckResultService ;

	private Page<Prize> page = null;
	private List<Prize> prizes = null;
	private List<Prize> pagePrizes = null;
    private PrizeCheckResult prizeCheckResult;
    
  //������ҳ����ʾ�ķ���
   	@RequestMapping(value="/show_prize")
   	public ModelAndView index(
   			                 HttpServletResponse response,
   			                 HttpServletRequest request,
   			                 @RequestParam(value = "which",required=true, defaultValue="hello") String  which
   			                 ){
   		response.setCharacterEncoding("utf-8");
   		ModelAndView view  = new ModelAndView("admin/manageTeacherPrize/show_teacher_prize");
   	    			
   		prizes = prizeService.getPrizes();
   					
   		if(page==null){
   	    	  page = new Page<Prize>(0,6,prizes.size(),prizes);
   	    }else{
   	    	  page.setAllNum(prizes.size());
   	    	  page.setDatas(prizes);
   	    }		  
   	    
   	    if(which.equals("pre")){
   	    	pagePrizes = page.prePage();
   		}else if(which.equals("next")){
   			pagePrizes  = page.nextPage();
   		}else{
   			pagePrizes= page.firstPage();
   		}		   		    	  
   			
   	    //��������ʦ�����ļ��Ϸ��ظ�ǰ�˽���
   	    view.addObject("pagePrizes",pagePrizes);
   		
   		
   		return view;
   	}
	@RequestMapping(value="/download_data")
	public void download_date(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
					
		//��ȡ���ص�������
		String prize_path=null;
		try {
			//�������ַ�ʽ��ȡ���ݵĲ�������ֹ��������
			prize_path = new String(request.getParameter("prize_path").getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   //�����������ط���
		ComFunctions.download(response, request, prize_path);
								
	}
	 //�������������ȡ�ӿ�
   	@RequestMapping(value="/get_prize_check")
   	public ModelAndView get_paper_check(HttpServletResponse response,HttpServletRequest request){
   		response.setCharacterEncoding("utf-8");
   		
   		ModelAndView view = new ModelAndView("admin/manageTeacherPrize/check_teacher_prize");
   		
   		
   		//��ȡ���ص�������
   		String prize_uuid=null;
   		String teacher_num = null;
   		try {
   			//�������ַ�ʽ��ȡ���ݵĲ�������ֹ��������
   			prize_uuid = new String(request.getParameter("prize_uuid").getBytes("iso-8859-1"),"utf-8");
   			teacher_num = new String(request.getParameter("teacher_num").getBytes("iso-8859-1"),"utf-8");
   		} catch (UnsupportedEncodingException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		prizeCheckResult = prizeCheckResultService.getPrizeCheckResultByNumAndId(prize_uuid, teacher_num);
   	
   		view.addObject("prizeCheckResult", prizeCheckResult);
   		
   		return view;						
   	}
  //����������ݱ���ӿ�
   	@RequestMapping(value="/save_result")
   	public ModelAndView save_result(
   			                       HttpServletResponse response,
   			                       HttpServletRequest request,
   			                       @RequestParam("result_rank") String result_rank,
   			                       @RequestParam("result_message") String result_message,
   			                       @RequestParam("result_is_ok") String result_is_ok,		                     
   			                       @RequestParam("prize_uuid") String prize_uuid,
   			                       @RequestParam("teacher_num") String teacher_num
   			                       
   			){
   		response.setCharacterEncoding("utf-8");
   		
   		ModelAndView view = new ModelAndView("admin/manageTeacherPrize/check_teacher_prize");
   		
   		prizeCheckResultService.updatePrizeCheckResult(
   				                                      Integer.parseInt(result_is_ok), 
   				                                      result_rank, 
   				                                      result_message,
   				                                      prize_uuid, 
   				                                      teacher_num);
   		prizeCheckResult = prizeCheckResultService.getPrizeCheckResultByNumAndId(prize_uuid, teacher_num);
   		view.addObject("prizeCheckResult", prizeCheckResult);
   		view.addObject("result", "<script>alert('��˳ɹ�!')</script>");
   		
   		return view;						
   	}	
}
