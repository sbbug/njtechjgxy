package com.njtechjgxy.home.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.njtechjgxy.service.PaperService;
import com.njtechjgxy.vo.Paper;


@Controller
@RequestMapping(value="/test")
public class TestController {

	    @Autowired
	    private PaperService paperService;
	   
	    @RequestMapping(value="/index")
	    public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf-8");
			//获取教师工号
			String teacher_num = (String)request.getSession().getAttribute("teacher_num");
		    ModelAndView view = new ModelAndView("Test/page");
		    List<Paper> allPapers = paperService.getPapersByNum(teacher_num);
		    
		    view.addObject("pagePapers", allPapers);
		    
			return view;
		}
	    @RequestMapping(value="/getAllPapers")
	    @ResponseBody
	    public List<Paper> getAllPapers(@RequestParam(required = false, defaultValue = "1") Integer startPage,
	            @RequestParam(required = false, defaultValue = "5") Integer PageSize) {
	        PageHelper.startPage(startPage, PageSize);
	        List<Paper> papers = new ArrayList<>();
	        papers = paperService.getAllPapers();
	        PageInfo<Paper> pi = new PageInfo<>(papers);
	        return papers;
	    }
	   
	   
	   
	   
	   
}
