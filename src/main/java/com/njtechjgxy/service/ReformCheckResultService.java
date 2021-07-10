package com.njtechjgxy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.ReformCheckResultMapper;
import com.njtechjgxy.vo.ReformCheckResult;

@Service
public class ReformCheckResultService {

	
			@Autowired
			private ReformCheckResultMapper reformCheckResultMapper;
			
			
			public int insertReformCheckResult(
		                                      int result_is_ok,
		                                      String result_ranked,
		                                      String result_message,
		                                      String reform_title,
		                                      String teacher_num
		            ){
				
				return reformCheckResultMapper.insertReformCheckResult(
						                                              result_is_ok, 
						                                              result_ranked, 
						                                              result_message, 
						                                              reform_title, 
						                                              teacher_num);
			}
			//修改数据
			
			 public int updateReformCheckResultByNumAndTitle(
		                int result_is_ok,
		                String result_ranked,
		                String result_message,
		                String reform_title,
		                String teacher_num
		               ){
				 return reformCheckResultMapper.updateReformCheckResultByNumAndTitle(
						                                                            result_is_ok, 
						                                                            result_ranked, 
						                                                            result_message,
						                                                            reform_title, 
						                                                            teacher_num);
			 }
			//查询数据
			@Select("select * from jgxy_teaching_reform_check_result")
			public List<ReformCheckResult> getAllResult(){
				
				return reformCheckResultMapper.getAllResult();
			}
						
			public ReformCheckResult getResultByNumAndTitle( String teacher_num, String reform_title){
				
				return reformCheckResultMapper.getResultByNumAndTitle(teacher_num, reform_title);
			}
			}
