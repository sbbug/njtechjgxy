package com.njtechjgxy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.BookCheckResultMapper;
import com.njtechjgxy.vo.BookCheckResult;

@Service
public class BookCheckResultService {

	@Autowired
	private BookCheckResultMapper bookCheckResultMapper;
	
	 public int insertBookCheckResult(
              String result_total_reward,
              String result_reward_from_depart,
              String result_message,
              int result_is_ok,
              String book_name,
              String teacher_num
             ){
		 
		 return bookCheckResultMapper.insertBookCheckResult(
				                                            result_total_reward, 
				                                            result_reward_from_depart, 
				                                            result_message, 
				                                            result_is_ok, 
				                                            book_name, 
				                                            teacher_num);
	 }
	 public int UpdateBookCheckResultByNumAndName(
              String result_total_reward,
              String result_reward_from_depart,
              String result_message,
              int result_is_ok,
              String book_name,
              String teacher_num
             ){
		 
		 return bookCheckResultMapper.UpdateBookCheckResultByNumAndName(
				                                                       result_total_reward, 
				                                                       result_reward_from_depart, 
				                                                       result_message, 
				                                                       result_is_ok, 
				                                                       book_name, 
				                                                       teacher_num);
	 }
	 public BookCheckResult getBookCheckResultByNameAndNum( String book_name, String teacher_num){
		 
		 return bookCheckResultMapper.getBookCheckResultByNameAndNum(book_name, teacher_num);
	 }
		
		
	 public List<BookCheckResult> getAllBookCheckResult(){
		 
		 return bookCheckResultMapper.getAllBookCheckResult();
	 }
}
