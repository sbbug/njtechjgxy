package com.njtechjgxy.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.njtechjgxy.vo.Achievement;

@Component
public interface AchievementMapper {

   //插入数据
   @Insert("insert into jgxy_teaching_and_search_achievement ("
   		                                                     + "achieve_status,"
   		                                                     + "achieve_department,"
   		                                                     + "achieve_teacher_name,"
   		                                                     + "achieve_title,"
   		                                                     + "achieve_class,"
   		                                                     + "achieve_unit_awards,"
   		                                                     + "achieve_get_time,"
   		                                                     + "achieve_rank,"
   		                                                     + "achieve_remark,"
   		                                                     + "achieve_which,"
   		                                                     + "achieve_path, "
   		                                                     + "achieve_date,"
   		                                                     + "teacher_num"
   		                                                     + ") "
   		                                                     + "value"
   		                                                     + " ("
   		                                                     + "#{achieve_status},"
   		                                                     + "#{achieve_department},"
   		                                                     + "#{achieve_teacher_name},"
   		                                                     + "#{achieve_title},"
   		                                                     + "#{achieve_class},"
   		                                                     + "#{achieve_unit_awards},"
   		                                                     + "#{achieve_get_time},"
   		                                                     + "#{achieve_rank},"
   		                                                     + "#{achieve_remark},"
   		                                                     + "#{achieve_which},"
   		                                                     + "#{achieve_path},"
   		                                                     + "#{achieve_date},"
   		                                                     + "#{teacher_num})")	
   public int insertAchievement(
		                       @Param("achieve_status") int achieve_status,
		                       @Param("achieve_department") String achieve_department,
		                       @Param("achieve_teacher_name") String achieve_teacher_name,
		                       @Param("achieve_title") String achieve_title,
		                       @Param("achieve_class") String achieve_class,
		                       @Param("achieve_unit_awards") String achieve_unit_awards,
		                       @Param("achieve_get_time") Date achieve_get_time,
		                       @Param("achieve_rank") String achieve_rank,
		                       @Param("achieve_remark") String achieve_remark,
		                       @Param("achieve_which") String achieve_which,
		                       @Param("achieve_path") String achieve_path,
		                       @Param("achieve_date") Date achieve_date,
		                       @Param("teacher_num") String teacher_num
		                       );
	
   //修改数据 
   @Update("update jgxy_teaching_and_search_achievement "
   		                                          + "set achieve_status=#{achieve_status},"
   		                                          + "achieve_department=#{achieve_department},"
   		                                          + "achieve_teacher_name=#{achieve_teacher_name},"
   		                                          + "achieve_title=#{achieve_title},"
   		                                          + "achieve_class=#{achieve_class},"
   		                                          + "achieve_unit_awards=#{achieve_unit_awards},"
   		                                          + "achieve_get_time=#{achieve_get_time},"
   		                                          + "achieve_rank=#{achieve_rank},"
   		                                          + "achieve_remark=#{achieve_remark},"
   		                                          + "achieve_which=#{achieve_which},"
   		                                          + "achieve_path=#{achieve_path},"
   		                                          + "achieve_date=#{achieve_date} "
   		                                          + "where achieve_id=#{achieve_id} and teacher_num=#{teacher_num}")
   public int updateAchievementByNumAndId(
		   @Param("achieve_id") int achieve_id,
           @Param("achieve_status") int achieve_status,
           @Param("achieve_department") String achieve_department,
           @Param("achieve_teacher_name") String achieve_teacher_name,
           @Param("achieve_title") String achieve_title,
           @Param("achieve_class") String achieve_class,
           @Param("achieve_unit_awards") String achieve_unit_awards,
           @Param("achieve_get_time") Date achieve_get_time,
           @Param("achieve_rank") String achieve_rank,
           @Param("achieve_remark") String achieve_remark,
           @Param("achieve_which") String achieve_which,
           @Param("achieve_path") String achieve_path,
           @Param("achieve_date") Date achieve_date,
           @Param("teacher_num") String teacher_num
           );
	
   //查找数据
   //根据条件查找
   @Select("select * from jgxy_teaching_and_search_achievement where teacher_num=#{teacher_num}")
   public List<Achievement> getAchievementsByNum(@Param("teacher_num") String teacher_num);
   
   @Select("select * from jgxy_teaching_and_search_achievement where teacher_num=#{teacher_num} and achieve_title=#{achieve_title}")
   public Achievement getAchievementsByNumAndTitle(@Param("teacher_num") String teacher_num,@Param("achieve_title") String achieve_title);
   
   @Select("select * from jgxy_teaching_and_search_achievement")
   public List<Achievement> getAchievements();
   
   
}
