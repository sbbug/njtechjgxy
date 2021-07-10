package com.njtechjgxy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.njtechjgxy.vo.AchievementCheckResult;

@Component
public interface AchievementCheckResultMapper {

	   //插入数据
	   @Insert("insert into jgxy_teaching_and_search_achievement_check_result ("
	   		                                                                  + "result_ranked,"
	   		                                                                  + "result_message,"
	   		                                                                  + "result_is_ok,"
	   		                                                                  + "achieve_title,"
	   		                                                                  + "teacher_num"
	   		                                                                  + ") "
	   		                                                                  + "value"
	   		                                                                  + " ("
	   		                                                                  + "#{result_ranked},"
	   		                                                                  + "#{result_message},"
	   		                                                                  + "#{result_is_ok},"
	   		                                                                  + "#{achieve_title},"
	   		                                                                  + "#{teacher_num}"
	   		                                                                  + ")")	
		public int insertTeachingAndSearchAchievementCheckResult(
				                                                 @Param("result_ranked") String result_ranked,
				                                                 @Param("result_message") String result_message,
				                                                 @Param("result_is_ok") int result_is_ok,
				                                                 @Param("achieve_title") String achieve_title,
				                                                 @Param("teacher_num") String teacher_num
				                                                 );
	   //修改数据 
	   @Update("update jgxy_teaching_and_search_achievement_check_result "
	   		                                                            + "set result_ranked=#{result_ranked},"
	   		                                                            + "result_message=#{result_message},"
	   		                                                            + "result_is_ok=#{result_is_ok},"
	   		                                                            + "achieve_title=#{achieve_title} "
	   		                                                            + "where teacher_num=#{teacher_num} and result_id=#{result_id}")	
	   public int updateAchieveCheckResultByIdAndTitle(
			                                           @Param("result_id") int result_id,
			                                           @Param("result_ranked") String result_ranked,
			                                           @Param("result_is_ok") int result_is_ok,
			                                           @Param("achieve_title") String achieve_title,
			                                           @Param("teacher_num") String teacher_num,
			                                           @Param("result_message") String result_message);	
	   //修改数据 
	   @Update("update jgxy_teaching_and_search_achievement_check_result "
	   		                                                            + "set result_ranked=#{result_ranked},"
	   		                                                            + "result_message=#{result_message},"
	   		                                                            + "result_is_ok=#{result_is_ok},"
	   		                                                            + "achieve_title=#{achieve_title} "
	   		                                                            + "where teacher_num=#{teacher_num} and achieve_title=#{achieve_title}")	
	   public int updateAchieveCheckResultByTitleAndNum(
			                                          
			                                           @Param("result_ranked") String result_ranked,
			                                           @Param("result_is_ok") int result_is_ok,
			                                           @Param("achieve_title") String achieve_title,
			                                           @Param("teacher_num") String teacher_num,
			                                           @Param("result_message") String result_message);	
	   //查找数据
	   //按条件查询
	   @Select("select * from jgxy_teaching_and_search_achievement_check_result where teacher_num=#{teacher_num} and achieve_title=#{achieve_title}")
	   public AchievementCheckResult getAchievementCheckResultByNumAndId(@Param("teacher_num") String teacher_num,@Param("achieve_title") String achieve_title);
	
	   //查询所有数据
	   @Select("select * from jgxy_teaching_and_search_achievement_check_result")
	   public List<AchievementCheckResult> getAllAchievementCheckResults();
}
