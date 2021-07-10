package com.njtechjgxy.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.njtechjgxy.vo.Reform;

@Component
public interface ReformMapper {

	//插入数据
	@Insert("insert into jgxy_teaching_reform ("
			                                 + "reform_status,"
			                                 + "reform_department,"
			                                 + "reform_first_author,"
			                                 + "reform_second_author,"
			                                 + "reform_third_author,"
			                                 + "reform_other_author,"
			                                 + "reform_title,"
			                                 + "reform_give_reward_unit,"
			                                 + "reform_rank,"
			                                 + "reform_money,"
			                                 + "reform_start_date,"
			                                 + "reform_end_date,"
			                                 + "reform_remark,"
			                                 + "reform_date,"
			                                 + "reform_path,"
			                                 + "teacher_num) "
			                                 + "value ("
			                                 + "#{reform_status},"
			                                 + "#{reform_department},"
			                                 + "#{reform_first_author},"
			                                 + "#{reform_second_author},"
			                                 + "#{reform_third_author},"
			                                 + "#{reform_other_author},"
			                                 + "#{reform_title},"
			                                 + "#{reform_give_reward_unit},"
			                                 + "#{reform_rank},"
			                                 + "#{reform_money},"
			                                 + "#{reform_start_date},"
			                                 + "#{reform_end_date},"
			                                 + "#{reform_remark},"
			                                 + "#{reform_date},"
			                                 + "#{reform_path},"
			                                 + "#{teacher_num})")
	public int insertReform(
			                @Param("reform_status") int reform_status,
			                @Param("reform_department") String reform_department,
			                @Param("reform_first_author") String reform_first_author,
			                @Param("reform_second_author") String reform_second_author,
			                @Param("reform_third_author") String reform_third_author,
			                @Param("reform_other_author") String reform_other_author,
			                @Param("reform_title") String reform_title,
			                @Param("reform_give_reward_unit") String reform_give_reward_unit,
			                @Param("reform_rank") String reform_rank,
			                @Param("reform_money") String reform_money,
			                @Param("reform_start_date") Date reform_start_date,
			                @Param("reform_end_date") Date reform_end_date,
			                @Param("reform_remark") String reform_remark,
			                @Param("reform_date") Date reform_date,
			                @Param("reform_path") String reform_path,
			                @Param("teacher_num") String teacher_num                
			);
	
	//修改数据
	@Update("update jgxy_teaching_reform set "
			                      + "reform_status=#{reform_status},"
			                      + "reform_department=#{reform_department},"
			                      + "reform_first_author=#{reform_first_author},"
			                      + "reform_second_author=#{reform_second_author},"
			                      + "reform_third_author=#{reform_third_author},"
			                      + "reform_other_author=#{reform_other_author},"
			                      + "reform_title=#{reform_title},"
			                      + "reform_give_reward_unit=#{reform_give_reward_unit},"
			                      + "reform_rank=#{reform_rank},"
			                      + "reform_money=#{reform_money},"
			                      + "reform_start_date=#{reform_start_date},"
			                      + "reform_end_date=#{reform_end_date},"
			                      + "reform_remark=#{reform_remark},"
			                      + "reform_date=#{reform_date},"
			                      + "reform_path=#{reform_path} "
			                      + "where teacher_num=#{teacher_num} and reform_title=#{reform_title} ")
	public int updateReformByNumAndTitle( 
										@Param("reform_status") int reform_status,
							            @Param("reform_department") String reform_department,
							            @Param("reform_first_author") String reform_first_author,
							            @Param("reform_second_author") String reform_second_author,
							            @Param("reform_third_author") String reform_third_author,
							            @Param("reform_other_author") String reform_other_author,
							            @Param("reform_title") String reform_title,
							            @Param("reform_give_reward_unit") String reform_give_reward_unit,
							            @Param("reform_rank") String reform_rank,
							            @Param("reform_money") String reform_money,
							            @Param("reform_start_date") Date reform_start_date,
							            @Param("reform_end_date") Date reform_end_date,
							            @Param("reform_remark") String reform_remark,
							            @Param("reform_date") Date reform_date,
							            @Param("reform_path") String reform_path,
							            @Param("teacher_num") String teacher_num
      );
	
	//查询数据
	@Select("select * from jgxy_teaching_reform")
	public List<Reform> getAllReforms();
	
	//按照条件查询数据
	@Select("select * from jgxy_teaching_reform where teacher_num=#{teacher_num}")
	public List<Reform> getReformsByNum(@Param("teacher_num") String teacher_num);
	
	@Select("select * from jgxy_teaching_reform where teacher_num=#{teacher_num} and reform_title=#{reform_title}")
	public Reform getReformsByNumAndTitle(@Param("teacher_num") String teacher_num,@Param("reform_title") String reform_title);
	
}
