package com.njtechjgxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.LoginLogMapper;
import com.njtechjgxy.vo.LoginLog;

@Service
public class LoginLogService {

	@Autowired
	private LoginLogMapper loginLogMapper;
	
	//��ȡ���е�¼������Ϣ
	public List<LoginLog> getLogs(){
		
		return loginLogMapper.getLogs();
	}
	//�����¼������Ϣ
	public int insertLog(String log_time,String log_ip){
		
		return loginLogMapper.insertLog(log_time, log_ip);
	}
	
	
}
