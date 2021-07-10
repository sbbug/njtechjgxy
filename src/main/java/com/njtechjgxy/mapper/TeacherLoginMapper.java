package com.njtechjgxy.mapper;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.njtechjgxy.vo.TeacherLoginLog;

@Component
public interface TeacherLoginMapper {

	
	@Insert("insert into jgxy_teacher_login_log (teacher_num,teacher_login_time) value (#{teacher_num},#{teacher_login_time})")
	public int insertLog(@Param("teacher_num") String teacher_num,@Param("teacher_login_time") Date teacher_login_time);
	
	@Select("select * from jgxy_teacher_login_log where teacher_num=#{teacher_num} order by teacher_login_time desc")
	public List<TeacherLoginLog> SelectLog(@Param("teacher_num") String teacher_num);
}
