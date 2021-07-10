package com.njtechjgxy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.njtechjgxy.vo.Admin;

@Component
public interface AdminMapper {

	 //定义查询所有数据的接口
	@Select("select * from jgxy_admin")
	public List<Admin> getAdmins();
	
	//判断某个用户是否存在
	@Select("select * from jgxy_admin where admin_num=#{admin_num} and admin_password=#{admin_password}")
	public Admin getAdminUsingId(@Param("admin_num") String admin_num, @Param("admin_password") String admin_password);
	
	
	//定义修改密码数据的接口
	@Update("update jgxy_admin set admin_password=#{admin_password} where admin_num=#{admin_num}")
	public int updateAdminUsingId(@Param("admin_password") String admin_password,@Param("admin_num") String admin_num);
	
	
	//定义删除数据的接口
	@Delete("delete from jgxy_admin where admin_num=#{admin_num}")
	public int deleteAdminUsingId(@Param("admin_num") String admin_num);
	
	//定义插入数据接口
	@Insert("insert into jgxy_admin (admin_num,admin_password,admin_level) value (#{admin_num},#{admin_password},#{#admin_level})")
	public int insertAdmin(@Param("admin_num") String admin_num,@Param("admin_password") String admin_password);
	
}
