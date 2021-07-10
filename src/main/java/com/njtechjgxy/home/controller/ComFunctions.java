package com.njtechjgxy.home.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Hex;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.njtechjgxy.vo.Teacher;

import sun.misc.BASE64Encoder;

//工具类定义，主要封装一些经常使用的公共方法，比如文件上传与文件下载

public class ComFunctions {

	  
	   public static String upload(
			               MultipartFile upfile,
			               HttpSession session ,
			               HttpServletResponse response,
			               String fileName
			               ){
		   
		    String result=null;
		    File file = null;
			if(upfile.getSize()==0){
				result= "文件上传不得为空";
			}else if(upfile.getSize()>0){
				
				String filename = upfile.getOriginalFilename();
				
			   if(filename.endsWith(".zip") || filename.endsWith("xlsx") || filename.endsWith("xls")){
					
					String leftPath = session.getServletContext().getRealPath("upload");
					file = new File(leftPath,fileName);
					System.out.println("======"+leftPath+"===="+file.getPath());
					System.out.println("网络存储路径====>"+session.getServletContext().getContextPath());
					try {
						upfile.transferTo(file);
						result= "文件上传成功";
					} catch (IllegalStateException e) {
						
						e.printStackTrace();
						result= "文件上传出现异常";
					} catch (IOException e) {
						
						e.printStackTrace();
						result= "文件上传出现异常";
					}
				}else{
					
					result= "文件上传格式不对";
			    }	
			}
			System.out.println("======文件上传结果"+result);
			//文件存储路径
		   return file.getPath();
	   }
	   
	
	
	   public static void download(
			                      HttpServletResponse response,
			                      HttpServletRequest request,
			                      String filePath){
		   //获取文件上下文路径
		   ServletContext context = request.getServletContext();
		   String appPath = context.getRealPath("");
		   System.out.println("appPath = " + appPath);
		   
		   //文件的全部路径
		   String fullPath = appPath + "\\upload\\"+filePath;      
	       File downloadFile = new File(fullPath);
	       System.out.println("fullpath==================================="+fullPath);
	       //创建一个文件输入流，读取数据到内存
	        FileInputStream inputStream=null;
			try {
				inputStream = new FileInputStream(downloadFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//获取文件流的类型
	        String mimeType = context.getMimeType(fullPath);
	        if (mimeType == null) {
	            // set to binary type if MIME mapping not found
	            mimeType = "application/octet-stream";
	        }
	        System.out.println("MIME type: " + mimeType);
	        
	       // set content attributes for the response
	        response.setContentType(mimeType);
	        response.setContentLength((int) downloadFile.length());
	 
	        // set headers for the response
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"",
	                downloadFile.getName());
	        response.setHeader(headerKey, headerValue);
	 
	        // 获取文件输出流
	        OutputStream outStream=null;
			try {
				outStream = response.getOutputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
	        byte[] buffer = new byte[4096];
	        int bytesRead = -1;
	 
	        // write bytes read from the input stream into the output stream
	        try {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				    outStream.write(buffer, 0, bytesRead);
				}
				 inputStream.close();
				 outStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}     
	   }
	   //加密算法
	   public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
	        //确定计算方法
	        MessageDigest md5=MessageDigest.getInstance("MD5");
	        BASE64Encoder base64en = new BASE64Encoder();
	        //加密后的字符串
	        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
	        return newstr;
	    }
	   //读取教师基本信息表excel数据，并且以集合形式返回
	   public static List<Teacher> getTeachersByExcel(String excel_path){
		  
		    
		     List<Teacher> teachers = new ArrayList<Teacher>();
		     Teacher teacher=null;
			 boolean isExcel2003 = excel_path.toLowerCase().endsWith("xls")?true:false;
			 Workbook workbook = null;
			 if(isExcel2003){
							 try {
								workbook = new HSSFWorkbook(new FileInputStream(new File(excel_path)));
									} catch (FileNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
			 }else{
							 try {
								workbook = new XSSFWorkbook(new FileInputStream(new File(excel_path)));
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
			 }
			 Sheet sheet = workbook.getSheetAt(0);
			 String ID=null;
			 System.out.println("=====总行数"+sheet.getLastRowNum());
			 
			//将员工基本信息读取到集合里，并返回给控制器			 
			 for(int i=2;i<=sheet.getLastRowNum();i++){
				 Row row = sheet.getRow(i);
				 teacher = new Teacher();
				
				 teacher.setTeacher_num(row.getCell(1).toString());
				 teacher.setTeacher_department(row.getCell(2).toString());
				 teacher.setTeacher_name(row.getCell(3).toString());
				 teacher.setTeacher_sex(row.getCell(4).toString());
				 teacher.setTeacher_address(row.getCell(5).toString());
				 teacher.setTeacher_ID_Card(row.getCell(6).toString());
				 teacher.setTeacher_birthday(row.getCell(7).toString());
				 teacher.setTeacher_education(row.getCell(8).toString());
				 teacher.setTeacher_title(row.getCell(9).toString());
				 teacher.setTeacher_remark(row.getCell(10).toString());
				 
				 //截取初始密码
				 ID = row.getCell(6).toString();
				 System.out.println("ID======"+ID);
				 String teacher_password = ID.substring(ID.length()-6, ID.length());
				 //进行加密
				try {
					teacher_password = ComFunctions.EncoderByMd5(teacher_password);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 teacher.setTeacher_password(teacher_password);
				 teachers.add(teacher);
				 System.out.println("");
			 }
			 
			 
			 return teachers;
	   }
	   
	   
}
