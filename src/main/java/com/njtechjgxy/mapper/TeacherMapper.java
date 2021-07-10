package com.njtechjgxy.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.njtechjgxy.vo.Teacher;

@Component
public interface TeacherMapper {
	       //定义查询所有数据的接口
			@Select("select * from jgxy_teacher")
			public List<Teacher> getTeahcers();
			
			//判断某个用户是否存在
			@Select("select * from jgxy_teacher where teacher_num=#{teacher_num} and teacher_password=#{teacher_password}")
			public Teacher getTeacherUsingId(@Param("teacher_num") String teacher_num, @Param("teacher_password") String teacher_password);
			
			@Select("select * from jgxy_teacher where teacher_num=#{teacher_num}")
			public Teacher getTeacherByNum(@Param("teacher_num") String teacher_num);
			
			//定义修改密码数据的接口
			@Update("update jgxy_teacher set teacher_password=#{teacher_password} where teacher_num=#{teacher_num}")
			public int updateTeacherUsingId(@Param("teacher_password") String teacher_password,@Param("teacher_num") String teacher_num);
			
			
			//定义删除数据的接口
			@Delete("delete from jgxy_teacher where teacher_num=#{teacher_num}")
			public int deleteTeacherUsingId(@Param("teacher_num") String teacher_num);
			
			//定义插入数据接口
			@Insert("insert into jgxy_teacher ("
					                          + "teacher_num,"
					                          + "teacher_name,"
					                          + "teacher_password,"
					                          + "teacher_status,"
					                          + "teacher_department,"
					                          + "teacher_sex,"
					                          + "teacher_address,"
					                          + "teacher_ID_Card,"
					                          + "teacher_birthday,"
					                          + "teacher_education,"
					                          + "teacher_title,"
					                          + "teacher_remark) "
					                          + "value"
					                          + " ("
					                          + "#{teacher_num},"
					                          + "#{teacher_name},"
					                          + "#{teacher_password},"
					                          + "1,"
					                          + "#{teacher_department},"
					                          + "#{teacher_sex},"
					                          + "#{teacher_address},"
					                          + "#{teacher_ID_Card},"
					                          + "#{teacher_birthday},"
					                          + "#{teacher_education},"
					                          + "#{teacher_title},"
					                          + "#{teacher_remark}"
					                          + ")")
			public int insertTeacher(
					                @Param("teacher_num") String teacher_num,
					                @Param("teacher_name") String teacher_name ,
					                @Param("teacher_password") String teacher_password ,
					                @Param("teacher_status") int teacher_status, 
					                @Param("teacher_department") String teacher_department,
					                @Param("teacher_sex") String teacher_sex,
					                @Param("teacher_address") String teacher_address, 
					                @Param("teacher_ID_Card") String teacher_ID_Card, 
					                @Param("teacher_birthday") String teacher_birthday, 
					                @Param("teacher_education") String teacher_education, 
					                @Param("teacher_title") String teacher_title,
					                @Param("teacher_remark") String teacher_remark
					                );
		  //修改教师基本信息的数据
		  @Update("update jgxy_teacher set "
		  		                          + "teacher_num=#{teacher_num},"
		  		                          + "teacher_name=#{teacher_name},"		  		                         
		  		                          + "teacher_status=#{teacher_status},"
		  		                          + "teacher_department=#{teacher_department},"
		  		                          + "teacher_sex=#{teacher_sex},"
		  		                          + "teacher_address=#{teacher_address},"
		  		                          + "teacher_ID_Card=#{teacher_ID_Card},"
		  		                          + "teacher_birthday=#{teacher_birthday},"
		  		                          + "teacher_education=#{teacher_education},"
		  		                          + "teacher_title=#{teacher_title},"
		  		                          + "teacher_remark=#{teacher_remark} where teacher_num=#{teacher_num}")
		  public int updateTeacherByNum(
	                @Param("teacher_num") String teacher_num,
	                @Param("teacher_name") String teacher_name ,	               
	                @Param("teacher_status") int teacher_status, 
	                @Param("teacher_department") String teacher_department,
	                @Param("teacher_sex") String teacher_sex,
	                @Param("teacher_address") String teacher_address, 
	                @Param("teacher_ID_Card") String teacher_ID_Card, 
	                @Param("teacher_birthday") String teacher_birthday, 
	                @Param("teacher_education") String teacher_education, 
	                @Param("teacher_title") String teacher_title,
	                @Param("teacher_remark") String teacher_remark
	                );
}
