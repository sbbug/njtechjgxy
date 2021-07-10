package com.njtechjgxy.service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.ReformMapper;
import com.njtechjgxy.mapper.TeacherLoginMapper;
import com.njtechjgxy.vo.TeacherLoginLog;

@Service
public class TeacherLoginService {

	@Autowired
	private TeacherLoginMapper teacherLoginMapper ;
	
	
	public int insertLog( String teacher_num, Date teacher_login_time){
		
		return teacherLoginMapper.insertLog(teacher_num, teacher_login_time);
	}
	
	public List<TeacherLoginLog> SelectLog( String teacher_num){
		
		return teacherLoginMapper.SelectLog(teacher_num);
				
	}
	
	
}
