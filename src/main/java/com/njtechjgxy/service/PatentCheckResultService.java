package com.njtechjgxy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.PatentCheckResultMapper;
import com.njtechjgxy.mapper.PatentMapper;
import com.njtechjgxy.mapper.PrizeCheckResultMapper;
import com.njtechjgxy.vo.PatentCheckResult;
import com.njtechjgxy.vo.PrizeCheckResult;

@Service
public class PatentCheckResultService {
   
		@Autowired
		private PatentCheckResultMapper patentCheckResultMapper;
		
		public  int insertPatentCheckResult(
	             int result_is_ok,
	             String result_rewards,
	             String result_reward_from_depart,
	             String result_message,
	             String patent_title,
	             String teacher_num){
			
			return patentCheckResultMapper.insertPatentCheckResult(
					                                              result_is_ok, 
					                                              result_rewards, 
					                                              result_reward_from_depart,
					                                              result_message,
					                                              patent_title, 
					                                              teacher_num);
		}

		//修改数据
		
		public  int updatePatentCheckResult(
						 int result_is_ok,
						 String result_rewards,
						 String result_reward_from_depart,
						 String result_message,
						 String patent_title,
						 String teacher_num){
			
			return patentCheckResultMapper.updatePatentCheckResult(
					                                               result_is_ok, 
					                                               result_rewards, 
					                                               result_reward_from_depart,
					                                               result_message, 
					                                               patent_title, 
					                                               teacher_num);
		}
		//查询数据
		//按条件查询
		
		public PatentCheckResult getCheckResultByNumAndTitle( String teacher_num, String patent_title){
			
			return patentCheckResultMapper.getCheckResultByNumAndTitle(teacher_num, patent_title);
		}
		
		//查询所有数据
		
		public List<PatentCheckResult> getAllCheckResult(){
			
			return patentCheckResultMapper.getAllCheckResult();
		}
	

}
