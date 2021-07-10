package com.njtechjgxy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.ItemMapper;
import com.njtechjgxy.vo.Item;

@Service
public class ItemService {

	@Autowired
	private ItemMapper itemMapper;
	
	public int insertItem(
             int item_status,
             String item_department,
             String item_first_author,
             String item_second_author,
             String item_third_author,
             String item_title,
             String item_fund_num,
             String item_from,
             String item_rank,
             String item_funds,
             String item_start_date,
             String item_end_date,
             String item_state,
             String item_remark,
             String item_path,
             Date item_date,
             String teacher_num
            ){
		
		return itemMapper.insertItem(
				                    item_status, 
				                    item_department, 
				                    item_first_author, 
				                    item_second_author, 
				                    item_third_author, 
				                    item_title, 
				                    item_fund_num, 
				                    item_from, 
				                    item_rank, 
				                    item_funds, 
				                    item_start_date, 
				                    item_end_date, 
				                    item_state, 
				                    item_remark, 
				                    item_path, 
				                    item_date, 
				                    teacher_num);
		
	}
		public int updateItemByIdAndNum(
				 int item_id,
	             int item_status,
	             String item_department,
	             String item_first_author,
	             String item_second_author,
	             String item_third_author,
	             String item_title,
	             String item_fund_num,
	             String item_from,
	             String item_rank,
	             String item_funds,
	             String item_start_date,
	             String item_end_date,
	             String item_state,
	             String item_remark,
	             String item_path,
	             Date item_date,
	             String teacher_num
	            ){
			
			return itemMapper.updateItemByIdAndNum(
					                              item_id, 
					                              item_status, 
					                              item_department, 
					                              item_first_author, 
					                              item_second_author, 
					                              item_third_author, 
					                              item_title, 
					                              item_fund_num, 
					                              item_from, 
					                              item_rank, 
					                              item_funds, 
					                              item_start_date, 
					                              item_end_date, 
					                              item_state, 
					                              item_remark, 
					                              item_path, 
					                              item_date, 
					                              teacher_num);
		}
		public List<Item> getItemsByNum( String teacher_num){
		
			return itemMapper.getItemsByNum(teacher_num);
		}
		public Item getItemByNumAndTitle( String teacher_num, String item_title){
			return itemMapper.getItemByNumAndTitle(teacher_num, item_title);
		}
		public List<Item> getAllItems(){
			
			return itemMapper.getAllItems();
		}
	
	
}
