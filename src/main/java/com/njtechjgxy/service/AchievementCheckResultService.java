package com.njtechjgxy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.AchievementCheckResultMapper;
import com.njtechjgxy.vo.AchievementCheckResult;

@Service
public class AchievementCheckResultService {

	@Autowired
	private AchievementCheckResultMapper achievementCheckResultMapper;
	
	public int insertTeachingAndSearchAchievementCheckResult(
             String result_ranked,
             String result_message,
             int result_is_ok,
             String achieve_title,
             String teacher_num
            ){
		
		return achievementCheckResultMapper.insertTeachingAndSearchAchievementCheckResult(
				                                                                   result_ranked, 
				                                                                   result_message, 
				                                                                   result_is_ok, 
				                                                                   achieve_title, 
				                                                                   teacher_num);
	}
	 public int updateAchieveCheckResultByIdAndTitle(
              int result_id,
              String result_ranked,
              int result_is_ok,
              String achieve_title,
              String teacher_num,
              String result_message){
		 
		 return achievementCheckResultMapper.updateAchieveCheckResultByIdAndTitle(
				                                                           result_id, 
				                                                           result_ranked, 
				                                                           result_is_ok, 
				                                                           achieve_title, 
				                                                           teacher_num, 
				                                                           result_message);
	 }
	 public AchievementCheckResult getAchievementCheckResultByNumAndId( String teacher_num, String achieve_title){
		  
		 return achievementCheckResultMapper.getAchievementCheckResultByNumAndId(teacher_num, achieve_title);
	 }
	 public List<AchievementCheckResult> getAllAchievementCheckResults(){
		 
		 return achievementCheckResultMapper.getAllAchievementCheckResults();
	 }
	  public int updateAchieveCheckResultByTitleAndNum(
              
               String result_ranked,
               int result_is_ok,
               String achieve_title,
               String teacher_num,
              String result_message){
		  
		  return achievementCheckResultMapper.updateAchieveCheckResultByTitleAndNum(result_ranked, result_is_ok, achieve_title, teacher_num, result_message);
	  }
}
