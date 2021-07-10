package com.njtechjgxy.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.njtechjgxy.vo.Item;

@Component
public interface ItemMapper {

	//数据插入
	@Insert("insert into jgxy_item ("
			                       + "item_status,"
			                       + "item_department,"
			                       + "item_first_author,"
			                       + "item_second_author,"
			                       + "item_third_author,"
			                       + "item_title,"
			                       + "item_fund_num,"
			                       + "item_from,"
			                       + "item_rank,"
			                       + "item_funds,"
			                       + "item_start_date,"
			                       + "item_end_date,"
			                       + "item_state,"
			                       + "item_remark,"
			                       + "item_path,"
			                       + "item_date,"
			                       + "teacher_num"
			                       + ") "
			                       + "value ("
			                       + "#{item_status},"
			                       + "#{item_department},"
			                       + "#{item_first_author},"
			                       + "#{item_second_author},"
			                       + "#{item_third_author},"
			                       + "#{item_title},"
			                       + "#{item_fund_num},"
			                       + "#{item_from},"
			                       + "#{item_rank},"
			                       + "#{item_funds},"
			                       + "#{item_start_date},"
			                       + "#{item_end_date},"
			                       + "#{item_state},"
			                       + "#{item_remark},"
			                       + "#{item_path},"
			                       + "#{item_date},"
			                       + "#{teacher_num})")
	public int insertItem(
			             @Param("item_status") int item_status,
			             @Param("item_department") String item_department,
			             @Param("item_first_author") String item_first_author,
			             @Param("item_second_author") String item_second_author,
			             @Param("item_third_author") String item_third_author,
			             @Param("item_title") String item_title,
			             @Param("item_fund_num") String item_fund_num,
			             @Param("item_from") String item_from,
			             @Param("item_rank") String item_rank,
			             @Param("item_funds") String item_funds,
			             @Param("item_start_date") String item_start_date,
			             @Param("item_end_date") String item_end_date,
			             @Param("item_state") String item_state,
			             @Param("item_remark") String item_remark,
			             @Param("item_path") String item_path,
			             @Param("item_date") Date item_date,
			             @Param("teacher_num") String teacher_num
			             );
	
	//数据修改
	@Update("update jgxy_item set "
			                     + "item_status=#{item_status},"
			                     + "item_department=#{item_department},"
			                     + "item_first_author=#{item_first_author},"
			                     + "item_second_author=#{item_second_author},"
			                     + "item_third_author=#{item_third_author},"
			                     + "item_title=#{item_title},"
			                     + "item_fund_num=#{item_fund_num},"
			                     + "item_from=#{item_from},"
			                     + "item_rank=#{item_rank},"
			                     + "item_funds=#{item_funds},"
			                     + "item_start_date=#{item_start_date},"
			                     + "item_end_date=#{item_end_date},"
			                     + "item_state=#{item_state},"
			                     + "item_remark=#{item_remark},"
			                     + "item_path=#{item_path},"
			                     + "item_date=#{item_date}"
			                     + "where teacher_num=#{teacher_num} and item_id=#{item_id}")
	public int updateItemByIdAndNum(
			@Param("item_id") int item_id,
            @Param("item_status") int item_status,
            @Param("item_department") String item_department,
            @Param("item_first_author") String item_first_author,
            @Param("item_second_author") String item_second_author,
            @Param("item_third_author") String item_third_author,
            @Param("item_title") String item_title,
            @Param("item_fund_num") String item_fund_num,
            @Param("item_from") String item_from,
            @Param("item_rank") String item_rank,
            @Param("item_funds") String item_funds,
            @Param("item_start_date") String item_start_date,
            @Param("item_end_date") String item_end_date,
            @Param("item_state") String item_state,
            @Param("item_remark") String item_remark,
            @Param("item_path") String item_path,
            @Param("item_date") Date item_date,
            @Param("teacher_num") String teacher_num
            );
	@Update("update jgxy_item set "
            + "item_status=#{item_status},"
            + "item_department=#{item_department},"
            + "item_first_author=#{item_first_author},"
            + "item_second_author=#{item_second_author},"
            + "item_third_author=#{item_third_author},"
            + "item_title=#{item_title},"
            + "item_fund_num=#{item_fund_num},"
            + "item_from=#{item_from},"
            + "item_rank=#{item_rank},"
            + "item_funds=#{item_funds},"
            + "item_start_date=#{item_start_date},"
            + "item_end_date=#{item_end_date},"
            + "item_state=#{item_state},"
            + "item_remark=#{item_remark},"
            + "item_path=#{item_path},"
            + "item_date=#{item_date}"
            + "where teacher_num=#{teacher_num} and item_title=#{item_title}")
		public int updateItemByTitleAndNum(
				
				@Param("item_status") int item_status,
				@Param("item_department") String item_department,
				@Param("item_first_author") String item_first_author,
				@Param("item_second_author") String item_second_author,
				@Param("item_third_author") String item_third_author,
				@Param("item_title") String item_title,
				@Param("item_fund_num") String item_fund_num,
				@Param("item_from") String item_from,
				@Param("item_rank") String item_rank,
				@Param("item_funds") String item_funds,
				@Param("item_start_date") String item_start_date,
				@Param("item_end_date") String item_end_date,
				@Param("item_state") String item_state,
				@Param("item_remark") String item_remark,
				@Param("item_path") String item_path,
				@Param("item_date") Date item_date,
				@Param("teacher_num") String teacher_num
		);
	
	//数据查询,根据教师账号查询该表下的所有数据
	@Select("select * from jgxy_item order by item_date desc")
	public List<Item> getAllItems();
	@Select("select * from jgxy_item where teacher_num=#{teacher_num}")
	public List<Item> getItemsByNum(@Param("teacher_num") String teacher_num);
	
	//判断这个老师是否已经填报过项目
	@Select("select * from jgxy_item where teacher_num=#{teacher_num} and item_title=#{item_title}")
	public Item getItemByNumAndTitle(@Param("teacher_num") String teacher_num,@Param("item_title") String item_title);
	
	
		
	
}
