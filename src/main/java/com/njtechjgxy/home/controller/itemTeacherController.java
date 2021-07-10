package com.njtechjgxy.home.controller;

import java.io.UnsupportedEncodingException;
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

import com.njtechjgxy.service.DepartmentService;
import com.njtechjgxy.service.ItemCheckResultService;
import com.njtechjgxy.service.ItemService;
import com.njtechjgxy.vo.Department;
import com.njtechjgxy.vo.Item;
import com.njtechjgxy.vo.ItemCheckResult;
import com.njtechjgxy.vo.Page;
import com.njtechjgxy.vo.Paper;

@Controller
@RequestMapping(value="/tea_item")
public class itemTeacherController {

	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private ItemCheckResultService itemCheckResultService;
	 //专业系的集合定义
    private List<Department> departs = null;
	
	private Item item=null;
	
	private List<Item> allItems = null;
	private List<Item> pageItems = null;
 	private Page<Item> page = null;
	
	
	//进入填写项目信息界面
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
		ModelAndView view = null;
		
		
		String path=null;
		//测试使用
		System.out.println("==="+request.getSession().getAttribute("teacher_num"));
		//判断教师是否 已经登录，防止非法用户进入主页面
		if(request.getSession().getAttribute("teacher_num").equals("")){
			view = new ModelAndView("home/teacher_login");
		}else{
			
			departs = departmentService.getDeparts();
			view = new ModelAndView("home/teacherItem/teacher_item");
			view.addObject("departs", departs);
		}
		return view;
	}
	
	//保存教师填写的信息方法
	@RequestMapping(value="/addItem")
	public ModelAndView addItem(
			                    HttpServletResponse response,
			                    HttpServletRequest request,
			                    HttpSession session,
			                    @RequestParam("item_status") String item_status,
			                    @RequestParam("item_department") String item_department,
			                    @RequestParam("item_first_author") String item_first_author,
			                    @RequestParam("item_second_author") String item_second_author,
			                    @RequestParam("item_third_author") String item_third_author,
			                    @RequestParam("item_title") String item_title,
			                    @RequestParam("item_fund_num") String item_fund_num,
			                    @RequestParam("item_from") String item_from,
			                    @RequestParam("item_rank") String item_rank,
			                    @RequestParam("item_funds") String item_funds,
			                    @RequestParam("item_start_date") String item_start_date,
			                    @RequestParam("item_end_date") String item_end_date,
			                    @RequestParam("item_state") String item_state,
			                    @RequestParam("item_remark") String item_remark,
			                    @RequestParam("upfile")  MultipartFile upfile
			                   ){
		response.setCharacterEncoding("utf-8");
		ModelAndView view  = new ModelAndView("home/teacherItem/teacher_item");
		//教师工号记录
		String teacher_num = (String)request.getSession().getAttribute("teacher_num");
		
		
		item = itemService.getItemByNumAndTitle(teacher_num, item_title);
		//当item==null时，说明还未填报
		if(item==null){
			
			view.addObject("result", "<script>alert('填报成功!')</script>");
			
			//其它变量的处理
			//确定文件名并且要具有唯一性
			String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			
			//文件存储的名字
			String item_path=teacher_num+"-"+date+"-"+"科研项目"+upfile.getOriginalFilename();   
			//将上传的文件保存到服务器目录下
			ComFunctions.upload(upfile, session, response, item_path);
			//将数据记录插入到数据库
			Date item_date = new Date();
			itemService.insertItem(
					              Integer.parseInt(item_status), 
					              item_department, 
					              item_first_author, 
					              item_second_author, 
					              item_third_author, 
					              item_title, 
					              item_fund_num, 
					              item_from, 
					              item_rank, 
					              item_funds, 
					              item_start_date, 
					              item_end_date, 
					              item_state, 
					              item_remark, 
					              item_path, 
					              item_date, 
					              teacher_num);
			
			
		}else{
			view.addObject("result", "<script>alert('该科研项目已经存在!')</script>");
		}
		
		itemCheckResultService.insertItemCheckResult("还未审核", "还未审核", 1, item_title, teacher_num);
		departs = departmentService.getDeparts();
		view.addObject("departs", departs);
		
		return view;
	}
	//科研项目搜索
	@RequestMapping(value="/search")
	public ModelAndView search(
			                   HttpServletResponse response,
                               HttpServletRequest request,
                               HttpSession session,
                               @RequestParam(value = "which",required=true, defaultValue="hello") String  which                   
			){
		response.setCharacterEncoding("utf-8");
		ModelAndView view  = new ModelAndView("home/teacherItem/teacher_item_search");
		//获取教师工号
		String teacher_num = (String)request.getSession().getAttribute("teacher_num");
		//此处进行优化，防止重复查询数据库
		
			//获取所有教师工号相同的论文集合
			
		    allItems = itemService.getItemsByNum(teacher_num);
		
		    if(page==null){
		    	  page = new Page<Item>(0,3,allItems.size(),allItems);
		    }else{
		    	  page.setAllNum(allItems.size());
		    	  page.setDatas(allItems);
		    }
		  
		    
		    if(which.equals("pre")){
		    	pageItems = page.prePage();
			}else if(which.equals("next")){
				pageItems = page.nextPage();
			}else{
				pageItems = page.firstPage();
			}		   		    	  
				
		//将单个教师的论文集合返回给前端界面
		view.addObject("pageItems", pageItems);
		
		
		return view;
	}
	@RequestMapping(value="/modify")
	public ModelAndView modify(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
		ModelAndView view = null;
		
		
		String path=null;
		String item_title = null;
		String teacher_num = (String)request.getSession().getAttribute("teacher_num");
		//测试使用
		System.out.println("==="+teacher_num);
		//判断教师是否 已经登录，防止非法用户进入主页面
		if(request.getSession().getAttribute("teacher_num").equals("")){
			view = new ModelAndView("home/teacher_login");
		}else{
			try {
				item_title = new String(request.getParameter("item_title").getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			item = itemService.getItemByNumAndTitle(teacher_num, item_title);
			departs = departmentService.getDeparts();
			view = new ModelAndView("home/teacherItem/teacher_item_modify");
			view.addObject("departs", departs);
			view.addObject("item", item);
		}
		return view;
	}
	@RequestMapping(value="/modify_save")
	public ModelAndView modify_save(
			                        HttpServletResponse response,
			                        HttpServletRequest request,
			                        HttpSession session,
			                        @RequestParam("item_id") String  item_id,
				                    @RequestParam("item_status") String item_status,
				                    @RequestParam("item_department") String item_department,
				                    @RequestParam("item_first_author") String item_first_author,
				                    @RequestParam("item_second_author") String item_second_author,
				                    @RequestParam("item_third_author") String item_third_author,
				                    @RequestParam("item_title") String item_title,
				                    @RequestParam("item_fund_num") String item_fund_num,
				                    @RequestParam("item_from") String item_from,
				                    @RequestParam("item_rank") String item_rank,
				                    @RequestParam("item_funds") String item_funds,
				                    @RequestParam("item_start_date") String item_start_date,
				                    @RequestParam("item_end_date") String item_end_date,
				                    @RequestParam("item_state") String item_state,
				                    @RequestParam("item_remark") String item_remark,
				                    @RequestParam("upfile")  MultipartFile upfile			
			                        ){
		response.setCharacterEncoding("utf-8");
		ModelAndView view = null;
				
		String teacher_num = (String)request.getSession().getAttribute("teacher_num");
		//测试使用
		System.out.println("==="+teacher_num);
		//获取文件名称的id号
		String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		
		//文件存储的名字
		String item_path=teacher_num+"-"+date+"-"+"科研项目"+upfile.getOriginalFilename();   
		//将上传的文件保存到服务器目录下
		ComFunctions.upload(upfile, session, response, item_path);	
		
		Date item_date = new Date();
		
		itemService.updateItemByIdAndNum(Integer.parseInt(item_id), Integer.parseInt(item_status), item_department, item_first_author, item_second_author, item_third_author, item_title, item_fund_num, item_from, item_rank, item_funds, item_start_date, item_end_date, item_state, item_remark, item_path, item_date, teacher_num);
		item = itemService.getItemByNumAndTitle(teacher_num, item_title);	
			departs = departmentService.getDeparts();
			view = new ModelAndView("home/teacherItem/teacher_item_modify");
			view.addObject("result", "<script>alert('修改成功!')</script>");
			view.addObject("departs", departs);
			view.addObject("item", item);
		
		return view;
	}
}
