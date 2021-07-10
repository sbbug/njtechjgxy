package com.njtechjgxy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.njtechjgxy.vo.Department;

@Component
public interface DepartmentMapper {

	   //�����ѯ�������ݵĽӿ�
		@Select("select * from jgxy_department")
		public List<Department> getDeparts();

		//�����޸����ݵĽӿ�
		@Update("update jgxy_department set depart_status=#{depart_status} where depart_item=#{depart_item}")
		public int updateDepartUsingItem(@Param("depart_status") int depart_status,@Param("depart_item") String depart_item);
	
}
