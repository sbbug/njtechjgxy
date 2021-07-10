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

//�����ඨ�壬��Ҫ��װһЩ����ʹ�õĹ��������������ļ��ϴ����ļ�����

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
				result= "�ļ��ϴ�����Ϊ��";
			}else if(upfile.getSize()>0){
				
				String filename = upfile.getOriginalFilename();
				
			   if(filename.endsWith(".zip") || filename.endsWith("xlsx") || filename.endsWith("xls")){
					
					String leftPath = session.getServletContext().getRealPath("upload");
					file = new File(leftPath,fileName);
					System.out.println("======"+leftPath+"===="+file.getPath());
					System.out.println("����洢·��====>"+session.getServletContext().getContextPath());
					try {
						upfile.transferTo(file);
						result= "�ļ��ϴ��ɹ�";
					} catch (IllegalStateException e) {
						
						e.printStackTrace();
						result= "�ļ��ϴ������쳣";
					} catch (IOException e) {
						
						e.printStackTrace();
						result= "�ļ��ϴ������쳣";
					}
				}else{
					
					result= "�ļ��ϴ���ʽ����";
			    }	
			}
			System.out.println("======�ļ��ϴ����"+result);
			//�ļ��洢·��
		   return file.getPath();
	   }
	   
	
	
	   public static void download(
			                      HttpServletResponse response,
			                      HttpServletRequest request,
			                      String filePath){
		   //��ȡ�ļ�������·��
		   ServletContext context = request.getServletContext();
		   String appPath = context.getRealPath("");
		   System.out.println("appPath = " + appPath);
		   
		   //�ļ���ȫ��·��
		   String fullPath = appPath + "\\upload\\"+filePath;      
	       File downloadFile = new File(fullPath);
	       System.out.println("fullpath==================================="+fullPath);
	       //����һ���ļ�����������ȡ���ݵ��ڴ�
	        FileInputStream inputStream=null;
			try {
				inputStream = new FileInputStream(downloadFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//��ȡ�ļ���������
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
	 
	        // ��ȡ�ļ������
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
	   //�����㷨
	   public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
	        //ȷ�����㷽��
	        MessageDigest md5=MessageDigest.getInstance("MD5");
	        BASE64Encoder base64en = new BASE64Encoder();
	        //���ܺ���ַ���
	        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
	        return newstr;
	    }
	   //��ȡ��ʦ������Ϣ��excel���ݣ������Լ�����ʽ����
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
			 System.out.println("=====������"+sheet.getLastRowNum());
			 
			//��Ա��������Ϣ��ȡ������������ظ�������			 
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
				 
				 //��ȡ��ʼ����
				 ID = row.getCell(6).toString();
				 System.out.println("ID======"+ID);
				 String teacher_password = ID.substring(ID.length()-6, ID.length());
				 //���м���
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
