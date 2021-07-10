package com.njtechjgxy.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.TeachingPaperMapper;
import com.njtechjgxy.vo.TeachingPaper;

@Service
public class TeachingPaperService {

	@Autowired
	private TeachingPaperMapper teachingPaperMapper;
	
	
	public List<TeachingPaper> getAllTeachingPapers(){
		
		return teachingPaperMapper.getAllTeachingPapers();
	}
	
	public List<TeachingPaper> getAllTeachingPapersByNum( String teacher_num){
		
		return teachingPaperMapper.getAllTeachingPapersByNum(teacher_num);
	}
	public TeachingPaper getTeachingPaperByTitleAndNum(String teacher_num,String paper_title){
		
		return teachingPaperMapper.getTeachingPaperByTitleAndNum(teacher_num, paper_title);
	}
	 public int insertTeachingAndResearch(
              int paper_status,
              String paper_department,
              String paper_first_author,
              String paper_first_author_unit,
              String paper_second_author,
              String paper_second_author_unit,
              String paper_third_author,
              String paper_third_author_unit,
              String paper_title,
              String paper_period,
              String paper_period_roll,
              String paper_period_page,
              String paper_path,
              String paper_department_kind,
              Date paper_time,
              String teacher_num
             ){
		 
		 return  teachingPaperMapper.insertTeachingAndResearch(
				                                              paper_status, 
				                                              paper_department, 
				                                              paper_first_author, 
				                                              paper_first_author_unit, 
				                                              paper_second_author, 
				                                              paper_second_author_unit, 
				                                              paper_third_author, 
				                                              paper_third_author_unit, 
				                                              paper_title, 
				                                              paper_period, 
				                                              paper_period_roll, 
				                                              paper_period_page, 
				                                              paper_path, 
				                                              paper_department_kind, 
				                                              paper_time, teacher_num
				                                              );
	 }
	 public int updateTeachingAndResearchByTitleAndNum(
              int paper_status,
              String paper_department,
              String paper_first_author,
              String paper_first_author_unit,
              String paper_second_author,
              String paper_second_author_unit,
              String paper_third_author,
              String paper_third_author_unit,
              String paper_title,
              String paper_period,
              String paper_period_roll,
              String paper_period_page,
              String paper_path,
              String paper_department_kind,
              Date paper_time,
              String teacher_num
             ){
		 
		 return teachingPaperMapper.updateTeachingAndResearchByTitleAndNum(
				                                                           paper_status, 
				                                                           paper_department, 
				                                                           paper_first_author, 
				                                                           paper_first_author_unit, 
				                                                           paper_second_author, 
				                                                           paper_second_author_unit, 
				                                                           paper_third_author, 
				                                                           paper_third_author_unit, 
				                                                           paper_title, 
				                                                           paper_period, 
				                                                           paper_period_roll, 
				                                                           paper_period_page, 
				                                                           paper_path, 
				                                                           paper_department_kind, 
				                                                           paper_time, 
				                                                           teacher_num
				                                                           );
	 }
	
	
}
