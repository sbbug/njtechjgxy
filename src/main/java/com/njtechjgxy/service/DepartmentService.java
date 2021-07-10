package com.njtechjgxy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.njtechjgxy.mapper.DepartmentMapper;
import com.njtechjgxy.vo.Department;

//下面的@Service不要忘记加了
@Service
public class DepartmentService {
 
	@Autowired
    private DepartmentMapper departmentMapper;
	
	//查询所有的系
	public List<Department> getDeparts(){
		
		return departmentMapper.getDeparts();
	}
	//对系的状态进行修改
    public int updateDepartUsingItem(String depart_item,int  depart_status){
		
	    //System.out.println("service======"+teacher_password+"     "+teacher_num);
		
		return departmentMapper.updateDepartUsingItem(depart_status, depart_item);
	}
	
}
