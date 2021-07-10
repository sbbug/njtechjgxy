package com.njtechjgxy.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.PaperMapper;
import com.njtechjgxy.vo.Paper;


@Service
public class PaperService {

	@Autowired
	private PaperMapper paperMapper;
	
	//获取数据库里的所有论文信息
	public List<Paper> getAllPapers(){
		
		return paperMapper.getAllPapers();
	}
	
	//搜索每个老师填报的所有论文
	public List<Paper> getPapersByNum(String teacher_num){
		
		return paperMapper.getPapersByNum(teacher_num);
	}
	
	//判断某个论文题目是否已经存在,根据教师工号与论文名称进行判断
		public Paper getPaperByTitleAndNum(String paper_title,String teacher_num){
			
		  return	paperMapper.getPaperByTitleAndNum(paper_title,teacher_num);
		}
	
    //根据论文题目搜索所有填写的论文记录
	public List<Paper> getPapersByTitle(String paper_title){
		
		return paperMapper.getPapersByTitle(paper_title); 
	}
	
	//实现数据的分页查询
	public List<Paper> getPapersLimit(String teacher_num,int start,int pageSize){
		
		return paperMapper.getPapersLimit(teacher_num, start, pageSize);
	}
	
	
	//实现论文的修改
	public int updatePaper(
			                int paper_id,
							int paper_status,
				            String paper_department,
				            String paper_first_author,
				            String paper_second_author,
				            String paper_third_author,
				            String paper_title,
				            String paper_period,
				            String paper_period_roll,
				            String paper_period_page,
				            String paper_department_kind,
				            String paper_department_count,
				            String paper_path,
				            String paper_first_author_unit,
				            int paper_is_English,
				            String paper_second_author_unit,
				            String paper_third_author_unit,
				            String teacher_num
			){
		 return paperMapper.updatePaper(paper_id,
				                        paper_status,
				                        paper_department, 
				                        paper_first_author, 
				                        paper_second_author, 
				                        paper_third_author, 
				                        paper_title,
				                        paper_period, 
				                        paper_period_roll,
				                        paper_period_page, 
				                        paper_department_kind,
				                        paper_department_count, 
				                        paper_path, 
				                        paper_first_author_unit,
				                        paper_is_English, 
				                        paper_second_author_unit,
				                        paper_third_author_unit,
				                        teacher_num);
	}
	
		
	//插入单条论文信息实现
	public int insertPaper( 
			 int paper_satus,
             String paper_department,
             String paper_first_author,
             String paper_second_author,
             String paper_third_author,
             String paper_title,
             String paper_period,
             String paper_period_roll,
             String paper_period_page,
             String paper_department_kind,
             String paper_department_count,
             String paper_path,
             String paper_first_author_unit,
             int paper_is_English,
             String paper_second_author_unit,
             String paper_third_author_unit,
             Date paper_date,
             String teacher_num){
		
		
		return paperMapper.insertPaper(paper_satus,
				                        paper_department, 
				                        paper_first_author, 
				                        paper_second_author, 
				                        paper_third_author, 
				                        paper_title, 
				                        paper_period, 
				                        paper_period_roll, 
				                        paper_period_page, 
				                        paper_department_kind, 
				                        paper_department_count, 
				                        paper_path, 
				                        paper_first_author_unit, 
				                        paper_is_English, 
				                        paper_second_author_unit, 
				                        paper_third_author_unit, 
				                        paper_date,
				                        teacher_num);
	}
	
	
	
}
