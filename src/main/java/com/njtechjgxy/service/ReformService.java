package com.njtechjgxy.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.PrizeMapper;
import com.njtechjgxy.mapper.ReformMapper;
import com.njtechjgxy.vo.Reform;

@Service
public class ReformService {

	@Autowired
	private ReformMapper reformMapper;
	
	public int insertReform(
             int reform_status,
             String reform_department,
             String reform_first_author,
             String reform_second_author,
             String reform_third_author,
             String reform_other_author,
             String reform_title,
             String reform_give_reward_unit,
             String reform_rank,
             String reform_money,
             Date reform_start_date,
             Date reform_end_date,
             String reform_remark,
             Date reform_date,
             String reform_path,
             String teacher_num                
     ){
		
		return reformMapper.insertReform(
				                        reform_status, 
				                        reform_department, 
				                        reform_first_author, 
				                        reform_second_author, 
				                        reform_third_author, 
				                        reform_other_author, 
				                        reform_title, 
				                        reform_give_reward_unit, 
				                        reform_rank, 
				                        reform_money, 
				                        reform_start_date,
				                        reform_end_date, 
				                        reform_remark,
				                        reform_date, 
				                        reform_path, 
				                        teacher_num);
	}

	//修改数据
	
	public int updateReformByNumAndTitle( 
							 int reform_status,
				             String reform_department,
				             String reform_first_author,
				             String reform_second_author,
				             String reform_third_author,
				             String reform_other_author,
				             String reform_title,
				             String reform_give_reward_unit,
				             String reform_rank,
				             String reform_money,
				             Date reform_start_date,
				             Date reform_end_date,
				             String reform_remark,
				             Date reform_date,
				             String reform_path,
				             String teacher_num
	){
		
		return reformMapper.updateReformByNumAndTitle(
				                                     reform_status, 
				                                     reform_department, 
				                                     reform_first_author, 
				                                     reform_second_author, 
				                                     reform_third_author, 
				                                     reform_other_author, 
				                                     reform_title,
				                                     reform_give_reward_unit, 
				                                     reform_rank, 
				                                     reform_money,
				                                     reform_start_date,
				                                     reform_end_date, 
				                                     reform_remark, 
				                                     reform_date,
				                                     reform_path, 
				                                     teacher_num);
	}

		//查询数据
		
		public List<Reform> getAllReforms(){
			
			return reformMapper.getAllReforms();
		}

		//按照条件查询数据
		
		public List<Reform> getReformsByNum( String teacher_num){
			
			return reformMapper.getReformsByNum(teacher_num);
		}
		
		public Reform getReformsByNumAndTitle( String teacher_num, String reform_title){
			
			return reformMapper.getReformsByNumAndTitle(teacher_num, reform_title);
		}

	
}
