package com.njtechjgxy.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.njtechjgxy.mapper.PrizeMapper;
import com.njtechjgxy.vo.Prize;

@Service
public class PrizeService {

	@Autowired
	private PrizeMapper prizeMapper;
	
	
	public int insertPrize(
                             int prize_status,
                             String prize_department,
                             String prize_member_one,
				             String prize_member_two,
				             String prize_member_three,
				             String prize_name,
				             String prize_give_unit,
				             String prize_rank,
				             Date prize_get_time,
				             String prize_remark,
				             String prize_path,
				             Date prize_date,
				             String teacher_num,
				             String prize_uuid
				             ){
		
		return prizeMapper.insertPrize(prize_status, prize_department, prize_member_one, prize_member_two, prize_member_three, prize_name, prize_give_unit, prize_rank, prize_get_time, prize_remark, prize_path, prize_date, teacher_num,prize_uuid);
	}
	public int updatePrize(
             
			 int prize_status,
             String prize_department,
             String prize_member_one,
             String prize_member_two,
             String prize_member_three,
             String prize_name,
             String prize_give_unit,
             String prize_rank,
             Date prize_get_time,
             String prize_remark,
             String prize_path,
             Date prize_date,
             String teacher_num,
             String prize_uuid
			){
		
		return prizeMapper.updatePrize( prize_status, prize_department, prize_member_one, prize_member_two, prize_member_three, prize_name, prize_give_unit, prize_rank, prize_get_time, prize_remark, prize_path, prize_date, teacher_num,prize_uuid);
	}
	public List<Prize> getPrizes(){
		
		return prizeMapper.getPrizes();
	}
	public List<Prize> getPrizeByNum( String teacher_num){
		
		return prizeMapper.getPrizeByNum(teacher_num);
	}
	public  Prize getPrizeByNumAndId( String teacher_num, String prize_uuid){
		
		return prizeMapper.getPrizeByNumAndId(teacher_num, prize_uuid);
	}
	public int selectLastInsertId(){
		return prizeMapper.selectLastInsertId();
	}
}
