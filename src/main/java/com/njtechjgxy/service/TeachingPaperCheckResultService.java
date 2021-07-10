package com.njtechjgxy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.njtechjgxy.mapper.TeachingPaperCheckResultMapper;
import com.njtechjgxy.vo.TeachingPaperCheckResult;

@Service
public class TeachingPaperCheckResultService {

	@Autowired
	private TeachingPaperCheckResultMapper teachingPaperCheckResultMapper;
	
	public List<TeachingPaperCheckResult> getAllTeachingPaperCheckResult(){
		
		return teachingPaperCheckResultMapper.getAllTeachingPaperCheckResult();
	}
	
	public TeachingPaperCheckResult getTeachingPaperByPapernameAndTeachernum( String paper_title,String teacher_num){
		
		return teachingPaperCheckResultMapper.getTeachingPaperByPapernameAndTeachernum(paper_title, teacher_num);
	}
	
	public int updatePaperCheckResultByTeachernumAndPapername(
             int is_in_own,
             int is_in_peking,
             int is_in_scd,
             int is_in_ssci,
             int result_is_ok,
             String result_info,
             String result_level,
             String result_message,
             String paper_title,
             String teacher_num
		       ){
		
		return teachingPaperCheckResultMapper.updatePaperCheckResultByTeachernumAndPapername(
				                                                                     is_in_own, 
				                                                                     is_in_peking, 
				                                                                     is_in_scd, 
				                                                                     is_in_ssci, 
				                                                                     result_is_ok, 
				                                                                     result_info, 
				                                                                     result_level, 
				                                                                     result_message, 
				                                                                     paper_title, 
				                                                                     teacher_num);
	}
	
	public int insertPaperCheckResult(
            int is_in_own,
            int is_in_peking,
            int is_in_scd,
            int is_in_ssci,
            int result_is_ok,
            String result_info,
            String result_level,
            String result_message,
            String paper_title,
            String teacher_num
            ){
		
		return teachingPaperCheckResultMapper.insertPaperCheckResult(
				                                                    is_in_own, 
				                                                    is_in_peking, 
				                                                    is_in_scd, 
				                                                    is_in_ssci, 
				                                                    result_is_ok, 
				                                                    result_info, 
				                                                    result_level, 
				                                                    result_message, 
				                                                    paper_title, 
				                                                    teacher_num);
	}
	
	
}
