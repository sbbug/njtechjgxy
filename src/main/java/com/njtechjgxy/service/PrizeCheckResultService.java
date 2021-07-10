package com.njtechjgxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.PrizeCheckResultMapper;
import com.njtechjgxy.vo.PrizeCheckResult;

@Service
public class PrizeCheckResultService {

	@Autowired
	private PrizeCheckResultMapper prizeCheckResultMapper;
	
	
    public int insertPrizeCheckResult(
              int result_is_ok,
              String result_rank,
              String result_message,
              String prize_uuid,
              String teacher_num){
    	
    	return prizeCheckResultMapper.insertPrizeCheckResult(
    			                                     result_is_ok, 
    			                                     result_rank, 
    			                                     result_message, 
    			                                     prize_uuid, 
    			                                     teacher_num);
    }
    public int updatePrizeCheckResult( 
			 int result_is_ok,
             String result_rank,
             String result_message,
             String prize_uuid,
             String teacher_num){
    	
    	return  prizeCheckResultMapper.updatePrizeCheckResult(
    			                                       result_is_ok, 
    			                                       result_rank, 
    			                                       result_message,
    			                                       prize_uuid, 
    			                                       teacher_num);
    }
    public List<PrizeCheckResultMapper> getAllPrizeCheckResult(){
    	
    	return prizeCheckResultMapper.getAllPrizeCheckResult();
    }
    public PrizeCheckResult getPrizeCheckResultByNumAndId( String prize_uuid, String teacher_num){
    
    	return prizeCheckResultMapper.getPrizeCheckResultByNumAndId(prize_uuid, teacher_num);
    }
}
