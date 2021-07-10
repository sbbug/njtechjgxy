package com.njtechjgxy.home.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/common")
public class commonFunController {

	@RequestMapping(value="/upload")
	public ModelAndView index(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
		
		return new ModelAndView("home/teacher_upload");
	}
	@RequestMapping(value="/download")
	public void download(HttpServletResponse response,HttpServletRequest request){
		
		String filePath="/upload/love.zip";
		ComFunctions.download(response, request, filePath);
	}
	
	@RequestMapping(value="/doUpload",method = RequestMethod.POST)
	public ModelAndView file(@RequestParam("upfile") MultipartFile upfile,HttpSession session ,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		String fileName=null;
		ModelAndView model = new ModelAndView("home/file_info");
		
		//确定文件名并且要具有唯一性
		String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		fileName=date+upfile.getOriginalFilename();
		
		String result = ComFunctions.upload(upfile, session, response,fileName);
		model.addObject("fileInfo", result);
		return model;
	}
}
