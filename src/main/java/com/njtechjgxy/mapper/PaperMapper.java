package com.njtechjgxy.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.njtechjgxy.vo.Paper;

@Component
public interface PaperMapper {

	
	//查询数据库所有论文信息
	@Select("select * from jgxy_teacher_paper order by paper_date desc")
	public List<Paper> getAllPapers();
	
	
	//查询单个教师填报所有论文信息
	@Select("select * from jgxy_teacher_paper where teacher_num=#{teacher_num}")
	public List<Paper> getPapersByNum(@Param("teacher_num") String teacher_num);
	
	//根据教师工号查询某个老师填报的所有论文以及论文审核结果

	
	//判断盖老师是否已经填写其论文，老师可以是第二作者或者第三作者
	@Select("select * from jgxy_teacher_paper where paper_title=#{paper_title} and teacher_num=#{teacher_num}")
	public Paper getPaperByTitleAndNum(@Param("paper_title") String paper_title,@Param("teacher_num") String teacher_num);
	//根据论文题目检索所有教师填写的论文信息，同一个论文题目会对应多个教师填写记录
	@Select("select * from jgxy_teacher_paper where paper_title=#{paper_title}")
	public List<Paper> getPapersByTitle(@Param("paper_title") String paper_title);
	
	
	//实现分页 的查询接口
	@Select("select * from jgxy_teacher_paper where teacher_num = #{teacher_num} limit #{start},#{pageSize}")
	public List<Paper> getPapersLimit(@Param("teacher_num")String teacher_num,int start,int pageSize);
	
	
	
	
	//修改教师填写的论文信息
	@Update("update jgxy_teacher_paper set "
			+ "paper_status=#{paper_status},"
			+ "paper_department=#{paper_department},"
			+ "paper_first_author=#{paper_first_author},"
			+ "paper_second_author=#{paper_second_author},"
			+ "paper_third_author=#{paper_third_author},"
			+ "paper_title=#{paper_title},"
			+ "paper_period=#{paper_period},"
			+ "paper_period_roll=#{paper_period_roll},"
			+ "paper_period_page=#{paper_period_page},"
			+ "paper_department_kind=#{paper_department_kind},"
			+ "paper_department_count=#{paper_department_count},"
			+ "paper_path=#{paper_path},"
			+ "paper_first_author_unit=#{paper_first_author_unit},"
			+ "paper_is_English=#{paper_is_English},"
			+ "paper_second_author_unit=#{paper_second_author_unit},"
			+ "paper_third_author_unit=#{paper_third_author_unit}"
			+ "where paper_id=#{paper_id} and teacher_num=#{teacher_num}")
	 
	public int updatePaper(
			                @Param("paper_id") int paper_id, 
							@Param("paper_status") int paper_status,
				            @Param("paper_department") String paper_department,
				            @Param("paper_first_author") String paper_first_author,
				            @Param("paper_second_author") String paper_second_author,
				            @Param("paper_third_author") String paper_third_author,
				            @Param("paper_title") String paper_title,
				            @Param("paper_period") String paper_period,
				            @Param("paper_period_roll") String paper_period_roll,
				            @Param("paper_period_page") String paper_period_page,
				            @Param("paper_department_kind") String paper_department_kind,
				            @Param("paper_department_count") String paper_department_count,
				            @Param("paper_path") String paper_path,
				            @Param("paper_first_author_unit") String paper_first_author_unit,
				            @Param("paper_is_English") int paper_is_English,
				            @Param("paper_second_author_unit") String paper_second_author_unit,
				            @Param("paper_third_author_unit") String paper_third_author_unit,
				            @Param("teacher_num") String teacher_num
            
			);
	//插入教师填写的论文信息
	@Insert("insert into jgxy_teacher_paper "
			+ "(paper_status,"
			+ "paper_department,"
			+ "paper_first_author,"
			+ "paper_second_author,"
			+ "paper_third_author,"
			+ "paper_title,"
			+ "paper_period,"
			+ "paper_period_roll,"
			+ "paper_period_page,"
			+ "paper_department_kind,"
			+ "paper_department_count,"
			+ "paper_path,"
			+ "paper_first_author_unit,"
			+ "paper_is_English,"
			+ "paper_second_author_unit,"
			+ "paper_third_author_unit,"
			+ "paper_date,"
			+ "teacher_num) "
			+ "value "
			+ "(#{paper_status},"
			+ "#{paper_department},"
			+ "#{paper_first_author},"
			+ "#{paper_second_author},"
			+ "#{paper_third_author},"
			+ "#{paper_title},"
			+ "#{paper_period},"
			+ "#{paper_period_roll},"
			+ "#{paper_period_page},"
			+ "#{paper_department_kind},"
			+ "#{paper_department_count},"
			+ "#{paper_path},"
			+ "#{paper_first_author_unit},"
			+ "#{paper_is_English},"
			+ "#{paper_second_author_unit},"
			+ "#{paper_third_author_unit},"
			+ "#{paper_date},"
			+ "#{teacher_num})")
	public int insertPaper(@Param("paper_status") int paper_status,
			               @Param("paper_department") String paper_department,
			               @Param("paper_first_author") String paper_first_author,
			               @Param("paper_second_author") String paper_second_author,
			               @Param("paper_third_author") String paper_third_author,
			               @Param("paper_title") String paper_title,
			               @Param("paper_period") String paper_period,
			               @Param("paper_period_roll") String paper_period_roll,
			               @Param("paper_period_page") String paper_period_page,
			               @Param("paper_department_kind") String paper_department_kind,
			               @Param("paper_department_count") String paper_department_count,
			               @Param("paper_path") String paper_path,
			               @Param("paper_first_author_unit") String paper_first_author_unit,
			               @Param("paper_is_English") int paper_is_English,
			               @Param("paper_second_author_unit") String paper_second_author_unit,
			               @Param("paper_third_author_unit") String paper_third_author_unit,
			               @Param("paper_date") Date paper_date,
			               @Param("teacher_num") String teacher_num);
			               
}
