package com.njtechjgxy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.njtechjgxy.mapper.PatentMapper;
import com.njtechjgxy.vo.Patent;

@Service
public class PatentService {

	
	@Autowired
	private PatentMapper patentMapper;
	
	
	//插入数据
	
		public int insertPatent(
				                int patent_status,
				                String patent_department,
				                String patent_first_author,
				                String patent_second_author,
				                String patent_third_author,
				                String patent_other_author,
				                String patent_class,
				                String patent_title,
				                String patent_num,
				                String patent_remark,
				                String patent_path,
				                String patent_date,
				                String teacher_num
				                ){
			return patentMapper.insertPatent(
					                        patent_status, 
					                        patent_department, 
					                        patent_first_author, 
					                        patent_second_author, 
					                        patent_third_author, 
					                        patent_other_author, 
					                        patent_class, 
					                        patent_title,
					                        patent_num, 
					                        patent_remark, 
					                        patent_path, 
					                        patent_date, 
					                        teacher_num);
		}
		
		//修改数据
		
		public int updatePatentByTitleAndNum(
	             int patent_status,
	             String patent_department,
	             String patent_first_author,
	             String patent_second_author,
	             String patent_third_author,
	             String patent_other_author,
	             String patent_class,
	             String patent_title,
	             String patent_num,
	             String patent_remark,
	             String patent_path,
	             String patent_date,
	             String teacher_num
	            ){
			
			return patentMapper.updatePatentByTitleAndNum(
					                                      patent_status, 
					                                      patent_department, 
					                                      patent_first_author, 
					                                      patent_second_author,
					                                      patent_third_author, 
					                                      patent_other_author, 
					                                      patent_class, 
					                                      patent_title, 
					                                      patent_num,
					                                      patent_remark, 
					                                      patent_path, 
					                                      patent_date, 
					                                      teacher_num);
		}
		
		//查询数据
		//按条件查询
		
		public List<Patent> getPatentsByNum( String teacher_num){
			
			return patentMapper.getPatentsByNum(teacher_num);
		}
	 	//查询所有数据

		public List<Patent> getPatents(){
			
			return patentMapper.getPatents();
		}
		//查询一条记录
		
		public Patent getPatent( String teacher_num, String patent_title){
			
			return patentMapper.getPatent(teacher_num, patent_title);
		}
		
		
	
	
	
}
