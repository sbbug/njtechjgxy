package com.njtechjgxy.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.AchievementMapper;
import com.njtechjgxy.vo.Achievement;

@Service
public class AchievementService {

	  @Autowired
	  private AchievementMapper achievementMapper;
	
	  public int insertAchievement(
               int achieve_status,
               String achieve_department,
               String achieve_teacher_name,
               String achieve_title,
               String achieve_class,
               String achieve_unit_awards,
               Date achieve_get_time,
               String achieve_rank,
               String achieve_remark,
               String achieve_which,
               String achieve_path,
               Date achieve_date,
               String teacher_num
              ){
		  return achievementMapper.insertAchievement(
				                                   achieve_status, 
				                                   achieve_department, 
				                                   achieve_teacher_name, 
				                                   achieve_title, 
				                                   achieve_class, 
				                                   achieve_unit_awards, 
				                                   achieve_get_time, 
				                                   achieve_rank, 
				                                   achieve_remark, 
				                                   achieve_which, 
				                                   achieve_path,
				                                   achieve_date, 
				                                   teacher_num);
	  }
	  
	  public int updateAchievementByNumAndId(
			    int achieve_id,
	            int achieve_status,
	            String achieve_department,
	            String achieve_teacher_name,
	            String achieve_title,
	            String achieve_class,
	            String achieve_unit_awards,
	            Date achieve_get_time,
	            String achieve_rank,
	            String achieve_remark,
	            String achieve_which,
	            String achieve_path,
	            Date achieve_date,
	            String teacher_num
	           ){
		  return achievementMapper.updateAchievementByNumAndId(
				                                             achieve_id, 
				                                             achieve_status, 
				                                             achieve_department, 
				                                             achieve_teacher_name, 
				                                             achieve_title, 
				                                             achieve_class, 
				                                             achieve_unit_awards, 
				                                             achieve_get_time, 
				                                             achieve_rank, 
				                                             achieve_remark, 
				                                             achieve_which, 
				                                             achieve_path,
				                                             achieve_date, 
				                                             teacher_num);
	  }
	  public List<Achievement> getAchievementsByNum( String teacher_num){
		  
		  return achievementMapper.getAchievementsByNum(teacher_num);
	  }
	  public List<Achievement> getAchievements(){
		  
		  return achievementMapper.getAchievements();
	  }
	  public Achievement getAchievementsByNumAndTitle(String teacher_num, String achieve_title){
		  
		  return achievementMapper.getAchievementsByNumAndTitle(teacher_num, achieve_title);
	  }
}
