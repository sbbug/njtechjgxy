package com.njtechjgxy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.njtechjgxy.vo.PrizeCheckResult;

@Component
public interface PrizeCheckResultMapper {

	    //插入数据
	    @Insert("insert into jgxy_prize_check_result ("
	    		                                      + "result_is_ok,"
	    		                                      + "result_rank,"
	    		                                      + "result_message,"
	    		                                      + "prize_uuid,"
	    		                                      + "teacher_num"
	    		                                      + ") "
	    		                                      + "value "
	    		                                      + "("
	    		                                      + "#{result_is_ok},"
	    		                                      + "#{result_rank},"
	    		                                      + "#{result_message},"
	    		                                      + "#{prize_uuid},"
	    		                                      + "#{teacher_num})")
	    public int insertPrizeCheckResult(
	    		                         @Param("result_is_ok") int result_is_ok,
	    		                         @Param("result_rank") String result_rank,
	    		                         @Param("result_message") String result_message,
	    		                         @Param("prize_uuid") String prize_uuid,
	    		                         @Param("teacher_num") String teacher_num);
	
		//修改数据
	    @Update("update jgxy_prize_check_result set result_is_ok=#{result_is_ok},result_rank=#{result_rank},result_message=#{result_message} where prize_uuid=#{prize_uuid} and teacher_num=#{teacher_num}")
		public int updatePrizeCheckResult( 
										@Param("result_is_ok") int result_is_ok,
						                @Param("result_rank") String result_rank,
						                @Param("result_message") String result_message,
						                @Param("prize_uuid") String prize_uuid,
						                @Param("teacher_num") String teacher_num);
		
		
		//查询数据
	    @Select("select * from jgxy_prize_check_result")
	    public List<PrizeCheckResultMapper> getAllPrizeCheckResult();
		
		//按照条件查询
	    @Select("select * from jgxy_prize_check_result where prize_uuid=#{prize_uuid} and teacher_num=#{teacher_num}")
	    public PrizeCheckResult getPrizeCheckResultByNumAndId(@Param("prize_uuid") String prize_uuid,@Param("teacher_num") String teacher_num);
	
}
