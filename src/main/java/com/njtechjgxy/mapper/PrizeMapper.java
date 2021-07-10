package com.njtechjgxy.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.njtechjgxy.vo.Prize;

@Component
public interface PrizeMapper {

	//插入数据
	@Insert("insert into jgxy_prize ("
			                       + "prize_status,"
			                       + "prize_department,"
			                       + "prize_member_one,"
			                       + "prize_member_two,"
			                       + "prize_member_three,"
			                       + "prize_name,"
			                       + "prize_give_unit,"
			                       + "prize_rank,"
			                       + "prize_get_time,"
			                       + "prize_remark,"
			                       + "prize_path,"
			                       + "prize_date,"
			                       + "teacher_num,"
			                       + "prize_uuid"
			                       + ") "
			                       + "value "
			                       + "("
			                       + "#{prize_status},"
			                       + "#{prize_department},"
			                       + "#{prize_member_one},"
			                       + "#{prize_member_two},"
			                       + "#{prize_member_three},"
			                       + "#{prize_name},"
			                       + "#{prize_give_unit},"
			                       + "#{prize_rank},"
			                       + "#{prize_get_time},"
			                       + "#{prize_remark},"
			                       + "#{prize_path},"
			                       + "#{prize_date},"
			                       + "#{teacher_num},"
			                       + "#{prize_uuid}"
			                       + ")")
	public int insertPrize(
			               @Param("prize_status") int prize_status,
			               @Param("prize_department") String prize_department,
			               @Param("prize_member_one") String prize_member_one,
			               @Param("prize_member_two") String prize_member_two,
			               @Param("prize_member_three") String prize_member_three,
			               @Param("prize_name") String prize_name,
			               @Param("prize_give_unit") String prize_give_unit,
			               @Param("prize_rank") String prize_rank,
			               @Param("prize_get_time") Date prize_get_time,
			               @Param("prize_remark") String prize_remark,
			               @Param("prize_path") String prize_path,
			               @Param("prize_date") Date prize_date,
			               @Param("teacher_num") String teacher_num,
			               @Param("prize_uuid")  String prize_uuid               
			);
	
	//修改数据
	@Update("update jgxy_prize set "
			                     + "prize_status=#{prize_status},"
			                     + "prize_department=#{prize_department},"
			                     + "prize_member_one=#{prize_member_one},"
			                     + "prize_member_two=#{prize_member_two},"
			                     + "prize_member_three=#{prize_member_three},"
			                     + "prize_name=#{prize_name},"
			                     + "prize_give_unit=#{prize_give_unit},"
			                     + "prize_rank=#{prize_rank},"
			                     + "prize_get_time=#{prize_get_time},"
			                     + "prize_remark=#{prize_remark},"
			                     + "prize_path=#{prize_path},"
			                     + "prize_date=#{prize_date} "
			                     + "where prize_uuid=#{prize_uuid} and teacher_num=#{teacher_num}"
			                     )
	public int updatePrize(
			               
							@Param("prize_status") int prize_status,
				            @Param("prize_department") String prize_department,
				            @Param("prize_member_one") String prize_member_one,
				            @Param("prize_member_two") String prize_member_two,
				            @Param("prize_member_three") String prize_member_three,
				            @Param("prize_name") String prize_name,
				            @Param("prize_give_unit") String prize_give_unit,
				            @Param("prize_rank") String prize_rank,
				            @Param("prize_get_time") Date prize_get_time,
				            @Param("prize_remark") String prize_remark,
				            @Param("prize_path") String prize_path,
				            @Param("prize_date") Date prize_date,
				            @Param("teacher_num") String teacher_num,
				            @Param("prize_uuid") String prize_uuid
			);
	
	
	//查询数据
	@Select("select * from jgxy_prize")
	public List<Prize> getPrizes();
	
	
	//按照条件查询
	@Select("select * from jgxy_prize where teacher_num=#{teacher_num}")
	public List<Prize> getPrizeByNum(@Param("teacher_num") String teacher_num);
	@Select("select * from jgxy_prize where teacher_num=#{teacher_num} and prize_uuid=#{prize_uuid}")
	public Prize getPrizeByNumAndId(@Param("teacher_num") String teacher_num,@Param("prize_uuid") String prize_uuid);
	//获取最新插入数据的id号
	@Select("select last_insert_id()")
	public int selectLastInsertId();
	
	
}
