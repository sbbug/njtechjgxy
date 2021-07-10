package com.njtechjgxy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.ItemCheckResultMapper;
import com.njtechjgxy.vo.ItemCheckResult;


@Service
public class ItemCheckResultService {

	@Autowired
	private ItemCheckResultMapper itemCheckResultMapper;
	
	public int insertItemCheckResult(
             String result_rank,
             String result_message,
             int result_is_ok,
             String item_title,
             String teacher_num
            ){
		
		return itemCheckResultMapper.insertItemCheckResult(
				                                          result_rank, 
				                                          result_message, 
				                                          result_is_ok, 
				                                          item_title, 
				                                          teacher_num);
	}
	
	public int updateItemCheckResultByIdAndNum(
             int result_id,
             String result_rank,
             int result_is_ok,
             String result_message,
             String item_title,
             String teacher_num
            ){
		
		return itemCheckResultMapper.updateItemCheckResultByIdAndNum(
				                                                   result_id, 
				                                                   result_rank, 
				                                                   result_is_ok, 
				                                                   result_message, 
				                                                   item_title, 
				                                                   teacher_num);
	}
	
	public ItemCheckResult getItemCheckResultByNumAndTitle( String teacher_num, String item_title){
		
		return itemCheckResultMapper.getItemCheckResultByNumAndTitle(teacher_num, item_title);
	}
	public List<ItemCheckResult> getAllItemCheckResult(){
		
		return itemCheckResultMapper.getAllItemCheckResult();
	}
	 public int updateItemCheckResultByTitleAndNum(
	            
              String result_rank,
              int result_is_ok,
              String result_message,
              String item_title,
              String teacher_num
             ){
		 return itemCheckResultMapper.updateItemCheckResultByTitleAndNum(
				                                                        result_rank, 
				                                                        result_is_ok,
				                                                        result_message, 
				                                                        item_title, 
				                                                        teacher_num);
	 }
	
}
