package com.njtechjgxy.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.njtechjgxy.vo.Teacher;

public class Read_excel {

	public static void main(String[] args) {
		 
		 String file = "I:/大四毕业课程设计/项目参考数据/teacher_base.xlsx";
		 boolean isExcel2003 = file.toLowerCase().endsWith("xls")?true:false;
		 Workbook workbook = null;
		 if(isExcel2003){
		 try {
			workbook = new HSSFWorkbook(new FileInputStream(new File(file)));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }else{
		 try {
			workbook = new XSSFWorkbook(new FileInputStream(new File(file)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 List<Teacher> teachers = new ArrayList<Teacher>();
	     Teacher teacher=null;
		 Sheet sheet = workbook.getSheetAt(0);
		 System.out.println("===========总行数"+sheet.getLastRowNum());
		 
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
			 
			 teachers.add(teacher);
			 System.out.println("");
		 }
		 
		 for(int j=0;j<teachers.size();j++){
			 teacher = teachers.get(j);
			 System.out.println("==="+teacher.getTeacher_name());
		 }
		

	}

}
