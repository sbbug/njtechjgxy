package com.njtechjgxy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.njtechjgxy.vo.LoginLog;

@Component
public interface LoginLogMapper {

	   //�����ѯ�������ݵĽӿ�
		@Select("select * from jgxy_login_log")
		public List<LoginLog> getLogs();
		//����������ݽӿ�
		@Insert("insert into jgxy_login_log (log_time,log_ip) value (#{log_time},#{log_ip})")
		public int insertLog(@Param("log_time")String log_time,@Param("log_ip")String log_ip);
}
