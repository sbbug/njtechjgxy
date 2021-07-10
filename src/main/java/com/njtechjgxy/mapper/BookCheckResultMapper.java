package com.njtechjgxy.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.njtechjgxy.vo.BookCheckResult;

@Component
public interface BookCheckResultMapper {

	   //插入数据
	   @Insert("insert into jgxy_book_check_result ("
	   		                                        + "result_total_reward,"
	   		                                        + "result_reward_from_depart,"
	   		                                        + "result_message,"
	   		                                        + "result_is_ok,"
	   		                                        + "book_name,"
	   		                                        + "teacher_num"
	   		                                        + ") value ("
	   		                                        + "#{result_total_reward},"
	   		                                        + "#{result_reward_from_depart},"
	   		                                        + "#{result_message},"
	   		                                        + "#{result_is_ok},"
	   		                                        + "#{book_name},"
	   		                                        + "#{teacher_num})")
	   public int insertBookCheckResult(
			                           @Param("result_total_reward") String result_total_reward,
			                           @Param("result_reward_from_depart") String result_reward_from_depart,
			                           @Param("result_message") String result_message,
			                           @Param("result_is_ok") int result_is_ok,
			                           @Param("book_name") String book_name,
			                           @Param("teacher_num") String teacher_num
			                           );
	
		//修改数据
		@Update("update jgxy_book_check_result "
				                             + "set result_total_reward=#{result_total_reward},"
				                             + "result_reward_from_depart=#{result_reward_from_depart},"
				                             + "result_message=#{result_message},"
				                             + "result_is_ok=#{result_is_ok},"
				                             + "book_name=#{book_name},"
				                             + "teacher_num=#{teacher_num} where teacher_num=#{teacher_num} and book_name=#{book_name}")
		public int UpdateBookCheckResultByNumAndName(
                @Param("result_total_reward") String result_total_reward,
                @Param("result_reward_from_depart") String result_reward_from_depart,
                @Param("result_message") String result_message,
                @Param("result_is_ok") int result_is_ok,
                @Param("book_name") String book_name,
                @Param("teacher_num") String teacher_num
                );
		
		//按照条件查询数据
		@Select("select * from jgxy_book_check_result where book_name=#{book_name} and teacher_num=#{teacher_num}")
		public BookCheckResult getBookCheckResultByNameAndNum(@Param("book_name") String book_name,@Param("teacher_num") String teacher_num);
		
		@Select("select * from jgxy_book_check_result")
		public List<BookCheckResult> getAllBookCheckResult();
			
}
