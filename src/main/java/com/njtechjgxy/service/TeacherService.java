package com.njtechjgxy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.TeacherMapper;
import com.njtechjgxy.vo.Teacher;

@Service
public class TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;
	
	//查询某个用户判断其是否存在
	public Teacher getTeacherUsingId(String teacher_num,  String teacher_password){
		
		return teacherMapper.getTeacherUsingId(teacher_num, teacher_password);
	}
	//根据教师工号修改密码
	public int modifyPassword(String teacher_password,String  teacher_num){
		
	    System.out.println("service======"+teacher_password+"     "+teacher_num);
		
		return teacherMapper.updateTeacherUsingId(teacher_password, teacher_num);
	}
	public Teacher getTeacherByNum(@Param("teacher_num") String teacher_num){
		
		return teacherMapper.getTeacherByNum(teacher_num);
	}
	//插入数据
	public int insertTeacher(
             String teacher_num,
             String teacher_name ,
             String teacher_password ,
             int teacher_status, 
             String teacher_department,
             String teacher_sex,
             String teacher_address, 
             String teacher_ID_Card, 
             String teacher_birthday, 
             String teacher_education, 
             String teacher_title,
             String teacher_remark
            ){
		
		return teacherMapper.insertTeacher(
				                          teacher_num, 
				                          teacher_name, 
				                          teacher_password,
				                          teacher_status,
				                          teacher_department,
				                          teacher_sex, 
				                          teacher_address, 
				                          teacher_ID_Card, 
				                          teacher_birthday, 
				                          teacher_education, 
				                          teacher_title,teacher_remark);
	}
	public List<Teacher> getTeahcers(){
		
		return teacherMapper.getTeahcers();
	}
	 public int updateTeacherByNum(
             String teacher_num,
             String teacher_name ,           
              int teacher_status, 
              String teacher_department,
              String teacher_sex,
              String teacher_address, 
             String teacher_ID_Card, 
              String teacher_birthday, 
              String teacher_education, 
             String teacher_title,
              String teacher_remark
             ){
		 
		 return teacherMapper.updateTeacherByNum(
				                                teacher_num, 
				                                teacher_name, 
				                                teacher_status, 
				                                teacher_department, 
				                                teacher_sex, 
				                                teacher_address, 
				                                teacher_ID_Card,
				                                teacher_birthday, 
				                                teacher_education, 
				                                teacher_title, 
				                                teacher_remark);
	 }
}
