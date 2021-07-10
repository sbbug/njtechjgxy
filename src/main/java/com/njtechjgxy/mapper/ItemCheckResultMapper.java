package com.njtechjgxy.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.njtechjgxy.vo.ItemCheckResult;

@Component
public interface ItemCheckResultMapper {

	
	//插入数据
	@Insert("insert into jgxy_item_check_result ("
			                                      + "result_rank,"
			                                      + "result_message,"
			                                      + "result_is_ok,"
			                                      + "item_title,"
			                                      + "teacher_num"
			                                      + ") value ("
			                                      + "#{result_rank},"
			                                      + "#{result_message},"
			                                      + "#{result_is_ok},"
			                                      + "#{item_title},"
			                                      + "#{teacher_num}"
			                                      + ")")
	public int insertItemCheckResult(
			                         @Param("result_rank") String result_rank,
			                         @Param("result_message") String result_message,
			                         @Param("result_is_ok") int result_is_ok,
			                         @Param("item_title") String item_title,
			                         @Param("teacher_num") String teacher_num
			                         );
	
	
	//修改数据
	@Update("update jgxy_item_check_result set result_rank=#{result_rank},"
			                                 + "result_message=#{result_message},"
			                                 + "result_is_ok=#{result_is_ok},"
			                                 + "item_title=#{item_title} "
			                                 + "where teacher_num=#{teacher_num} and result_id=#{result_id}")
	public int updateItemCheckResultByIdAndNum(
			                                  @Param("result_id")  int result_id,
			                                  @Param("result_rank") String result_rank,
			                                  @Param("result_is_ok") int result_is_ok,
			                                  @Param("result_message") String result_message,
			                                  @Param("item_title") String item_title,
			                                  @Param("teacher_num") String teacher_num
			                                  );
	@Update("update jgxy_item_check_result set result_rank=#{result_rank},"
												            + "result_message=#{result_message},"
												            + "result_is_ok=#{result_is_ok},"
												            + "item_title=#{item_title} "
												            + "where teacher_num=#{teacher_num} and item_title=#{item_title}")
    public int updateItemCheckResultByTitleAndNum(
            
             @Param("result_rank") String result_rank,
             @Param("result_is_ok") int result_is_ok,
             @Param("result_message") String result_message,
             @Param("item_title") String item_title,
             @Param("teacher_num") String teacher_num
             );
	
	//按照条件查询数据
	@Select("select * from jgxy_item_check_result where teacher_num=#{teacher_num} and item_title=#{item_title}")
	public ItemCheckResult getItemCheckResultByNumAndTitle(@Param("teacher_num") String teacher_num,@Param("item_title") String item_title);
	
	//查询所有数据
	@Select("select * from jgxy_item_check_result")
	public List<ItemCheckResult> getAllItemCheckResult();
	
}
