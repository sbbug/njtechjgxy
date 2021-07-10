package com.njtechjgxy.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.njtechjgxy.vo.TeachingPaper;

@Component
public interface TeachingPaperMapper {

	
	   //��ѯ��������
	   @Select("select * from jgxy_teaching_research_paper order by paper_time desc")
	   public List<TeachingPaper> getAllTeachingPapers();
	
       //���ݽ�ʦ���Ż�ȡ�����н������ĵ�������Ϣ,�����ʱ���Ⱥ���ʾ
	   @Select("select * from jgxy_teaching_research_paper where teacher_num=#{teacher_num}")
	   public List<TeachingPaper> getAllTeachingPapersByNum(@Param("teacher_num") String teacher_num);
	   
	   //�жϸý�ʦ�Ƿ��Ѿ���д�ý���������Ϣ
	   @Select("select * from jgxy_teaching_research_paper where teacher_num=#{teacher_num} and paper_title=#{paper_title}")
	   public TeachingPaper getTeachingPaperByTitleAndNum(@Param("teacher_num") String teacher_num,@Param("paper_title") String paper_title);
	   
	   
	   
	   //�����ݱ��в������������Ϣ
	   @Insert("insert into jgxy_teaching_research_paper ("
	   		                                              + "paper_status,"
	   		                                              + "paper_department,"
	   		                                              + "paper_first_author,"
	   		                                              + "paper_first_author_unit,"
	   		                                              + "paper_second_author,"
	   		                                              + "paper_second_author_unit,"
	   		                                              + "paper_third_author,"
	   		                                              + "paper_third_author_unit,"
	   		                                              + "paper_title,"
	   		                                              + "paper_period,"
	   		                                              + "paper_period_roll,"
	   		                                              + "paper_period_page,"
	   		                                              + "paper_path,"
	   		                                              + "paper_department_kind,"
	   		                                              + "paper_time,"
	   		                                              + "teacher_num) value "
	   		                                              + "("
	   		                                              + "#{paper_status},"
	   		                                              + "#{paper_department},"
	   		                                              + "#{paper_first_author},"
	   		                                              + "#{paper_first_author_unit},"
	   		                                              + "#{paper_second_author},"
	   		                                              + "#{paper_second_author_unit},"
	   		                                              + "#{paper_third_author},"
	   		                                              + "#{paper_third_author_unit},"
	   		                                              + "#{paper_title},"
	   		                                              + "#{paper_period},"
	   		                                              + "#{paper_period_roll},"
	   		                                              + "#{paper_period_page},"
	   		                                              + "#{paper_path},"
	   		                                              + "#{paper_department_kind},"
	   		                                              + "#{paper_time},"
	   		                                              + "#{teacher_num})")
	   public int insertTeachingAndResearch(
			                               @Param("paper_status") int paper_status,
			                               @Param("paper_department") String paper_department,
			                               @Param("paper_first_author") String paper_first_author,
			                               @Param("paper_first_author_unit") String paper_first_author_unit,
			                               @Param("paper_second_author") String paper_second_author,
			                               @Param("paper_second_author_unit") String paper_second_author_unit,
			                               @Param("paper_third_author") String paper_third_author,
			                               @Param("paper_third_author_unit") String paper_third_author_unit,
			                               @Param("paper_title") String paper_title,
			                               @Param("paper_period") String paper_period,
			                               @Param("paper_period_roll") String paper_period_roll,
			                               @Param("paper_period_page") String paper_period_page,
			                               @Param("paper_path") String paper_path,
			                               @Param("paper_department_kind") String paper_department_kind,
			                               @Param("paper_time") Date paper_time,
			                               @Param("teacher_num") String teacher_num
			                               );
	
	
       //�޸Ľ���������Ϣ
	   @Update("update jgxy_teaching_research_paper "
	   		                                       + "set paper_status=#{paper_status},"
	   		                                       + "paper_department=#{paper_department},"
	   		                                       + "paper_first_author=#{paper_first_author},"
	   		                                       + "paper_first_author_unit=#{paper_first_author_unit},"
	   		                                       + "paper_second_author=#{paper_second_author},"
	   		                                       + "paper_second_author_unit=#{paper_second_author_unit},"
	   		                                       + "paper_third_author=#{paper_third_author},"
	   		                                       + "paper_third_author_unit=#{paper_third_author_unit},"
	   		                                       + "paper_title=#{paper_title},"
	   		                                       + "paper_period=#{paper_period},"
	   		                                       + "paper_period_roll=#{paper_period_roll},"
	   		                                       + "paper_period_page=#{paper_period_page},"
	   		                                       + "paper_path=#{paper_path},"
	   		                                       + "paper_department_kind=#{paper_department_kind},"
	   		                                       + "paper_time=#{paper_time},"
	   		                                       + "teacher_num=#{teacher_num} "
	   		                                       + "where paper_title=#{paper_title} and teacher_num=#{teacher_num}")
	   public int updateTeachingAndResearchByTitleAndNum(
               @Param("paper_status") int paper_status,
               @Param("paper_department") String paper_department,
               @Param("paper_first_author") String paper_first_author,
               @Param("paper_first_author_unit") String paper_first_author_unit,
               @Param("paper_second_author") String paper_second_author,
               @Param("paper_second_author_unit") String paper_second_author_unit,
               @Param("paper_third_author") String paper_third_author,
               @Param("paper_third_author_unit") String paper_third_author_unit,
               @Param("paper_title") String paper_title,
               @Param("paper_period") String paper_period,
               @Param("paper_period_roll") String paper_period_roll,
               @Param("paper_period_page") String paper_period_page,
               @Param("paper_path") String paper_path,
               @Param("paper_department_kind") String paper_department_kind,
               @Param("paper_time") Date paper_time,
               @Param("teacher_num") String teacher_num
               );
	
	   //
	
	
	
	
	
	
	
	
}
