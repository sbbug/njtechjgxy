package com.njtechjgxy.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.AdminMapper;
import com.njtechjgxy.vo.Admin;


@Service
public class AdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	//��ѯĳ���û��ж����Ƿ����
	public Admin getAdminUsingId(String admin_num,  String admin_password){
			
			return adminMapper.getAdminUsingId(admin_num, admin_password);
	}
	
	public List<Admin> getAdmins(){
		
		return adminMapper.getAdmins();
	}
			
		
	//�����޸��������ݵĽӿ�
		
	public int updateAdminUsingId( String admin_password, String admin_num){
		
		return adminMapper.updateAdminUsingId(admin_password, admin_num);
	}
		
	//����ɾ�����ݵĽӿ�
		
	public int deleteAdminUsingId( String admin_num){
		
		return adminMapper.deleteAdminUsingId(admin_num);
	}
		
	//����������ݽӿ�
		
	
		
	
}
