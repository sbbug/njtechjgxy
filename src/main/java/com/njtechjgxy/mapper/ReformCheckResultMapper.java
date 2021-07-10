package com.njtechjgxy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.njtechjgxy.vo.ReformCheckResult;

@Component
public interface ReformCheckResultMapper {

	   //插入数据
	   @Insert("insert into jgxy_teaching_reform_check_result ("
	   		                                                + "result_is_ok,"
	   		                                                + "result_ranked,"
	   		                                                + "result_message,"
	   		                                                + "reform_title,"
	   		                                                + "teacher_num"
	   		                                                + ") "
	   		                                                + "value "
	   		                                                + "("
	   		                                                + "#{result_is_ok},"
	   		                                                + "#{result_ranked},"
	   		                                                + "#{result_message},"
	   		                                                + "#{reform_title},"
	   		                                                + "#{teacher_num}"
	   		                                                + ")") 
	   public int insertReformCheckResult(
			                             @Param("result_is_ok") int result_is_ok,
			                             @Param("result_ranked") String result_ranked,
			                             @Param("result_message") String result_message,
			                             @Param("reform_title") String reform_title,
			                             @Param("teacher_num") String teacher_num
			                             );
	   //修改数据
	   @Update("update jgxy_teaching_reform_check_result set "
	   		                                                 + "result_is_ok=#{result_is_ok},"
	   		                                                 + "result_ranked=#{result_ranked},"
	   		                                                 + "result_message=#{result_message},"
	   		                                                 + "reform_title=#{reform_title},"
	   		                                                 + "teacher_num=#{teacher_num} where teacher_num=#{teacher_num} and reform_title=#{reform_title}")	
	   public int updateReformCheckResultByNumAndTitle(
               @Param("result_is_ok") int result_is_ok,
               @Param("result_ranked") String result_ranked,
               @Param("result_message") String result_message,
               @Param("reform_title") String reform_title,
               @Param("teacher_num") String teacher_num
               );	
	   //查询数据
	   @Select("select * from jgxy_teaching_reform_check_result")
	   public List<ReformCheckResult> getAllResult();
	   
	   @Select("select * from jgxy_teaching_reform_check_result where teacher_num=#{teacher_num} and reform_title=#{reform_title}")
	   public ReformCheckResult getResultByNumAndTitle(@Param("teacher_num") String teacher_num,@Param("reform_title") String reform_title);
}
