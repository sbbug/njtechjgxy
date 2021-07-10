package com.njtechjgxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.njtechjgxy.mapper.TeacherPaperCheckResultMapper;
import com.njtechjgxy.vo.PaperCheckResult;


@Service
public class TeacherPaperCheckResultService {
   
	 @Autowired
	 private TeacherPaperCheckResultMapper paperCheckResultMapper;
	 
	 
	 //查询所有数据的接口实现
	 public List<PaperCheckResult> getAllPaperCheckResult(){
		 
		 return paperCheckResultMapper.getAllPaperCheckResult();
	 }
	 
	 //查询单条记录
	 public PaperCheckResult getPaperByPapernameAndTeachernum(String paper_title,String teacher_num){
		 
		 return paperCheckResultMapper.getPaperByPapernameAndTeachernum(paper_title, teacher_num);
	 }
	 //更新数据的接口实现
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
		 return paperCheckResultMapper.updatePaperCheckResultByTeachernumAndPapername(is_in_own, 
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
	//插入的数据接口实现
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
		 
		 return paperCheckResultMapper.insertPaperCheckResult(
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
