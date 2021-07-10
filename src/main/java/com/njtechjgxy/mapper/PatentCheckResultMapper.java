package com.njtechjgxy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.njtechjgxy.vo.PatentCheckResult;

public interface PatentCheckResultMapper {

	
	//插入数据
	@Insert("insert into jgxy_patent_check_result ("
			                                     + "result_is_ok,"
			                                     + "result_rewards,"
			                                     + "result_reward_from_depart,"
			                                     + "result_message,"
			                                     + "patent_title,"
			                                     + "teacher_num"
			                                     + ") "
			                                     + "value "
			                                     + "("
			                                     + "#{result_is_ok},"
			                                     + "#{result_rewards},"
			                                     + "#{result_reward_from_depart},"
			                                     + "#{result_message},"
			                                     + "#{patent_title},"
			                                     + "#{teacher_num}"
			                                     + ")")
	public  int insertPatentCheckResult(
			                      @Param("result_is_ok") int result_is_ok,
			                      @Param("result_rewards") String result_rewards,
			                      @Param("result_reward_from_depart") String result_reward_from_depart,
			                      @Param("result_message") String result_message,
			                      @Param("patent_title") String patent_title,
			                      @Param("teacher_num") String teacher_num);
	
	//修改数据
	@Update("update jgxy_patent_check_result "
			                              + "set result_is_ok=#{result_is_ok},"
			                              + "result_rewards=#{result_rewards},"
			                              + "result_reward_from_depart=#{result_reward_from_depart},"
			                              + "result_message=#{result_message},"
			                              + "patent_title=#{patent_title},"
			                              + "teacher_num=#{teacher_num} "
			                              + "where patent_title=#{patent_title} and teacher_num=#{teacher_num}")
	public  int updatePatentCheckResult(
            @Param("result_is_ok") int result_is_ok,
            @Param("result_rewards") String result_rewards,
            @Param("result_reward_from_depart") String result_reward_from_depart,
            @Param("result_message") String result_message,
            @Param("patent_title") String patent_title,
            @Param("teacher_num") String teacher_num);
	//查询数据
	//按条件查询
	@Select("select * from  jgxy_patent_check_result where teacher_num=#{teacher_num} and patent_title=#{patent_title}")
	public PatentCheckResult getCheckResultByNumAndTitle(@Param("teacher_num") String teacher_num,@Param("patent_title") String patent_title);
	
	//查询所有数据
	@Select("select * from jgxy_patent_check_result")
	public List<PatentCheckResult> getAllCheckResult();
}
