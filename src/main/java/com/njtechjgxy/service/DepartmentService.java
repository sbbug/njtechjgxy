package com.njtechjgxy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.njtechjgxy.mapper.DepartmentMapper;
import com.njtechjgxy.vo.Department;

//�����@Service��Ҫ���Ǽ���
@Service
public class DepartmentService {
 
	@Autowired
    private DepartmentMapper departmentMapper;
	
	//��ѯ���е�ϵ
	public List<Department> getDeparts(){
		
		return departmentMapper.getDeparts();
	}
	//��ϵ��״̬�����޸�
    public int updateDepartUsingItem(String depart_item,int  depart_status){
		
	    //System.out.println("service======"+teacher_password+"     "+teacher_num);
		
		return departmentMapper.updateDepartUsingItem(depart_status, depart_item);
	}
	
}
