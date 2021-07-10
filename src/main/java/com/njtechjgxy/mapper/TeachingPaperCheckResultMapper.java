package com.njtechjgxy.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.njtechjgxy.vo.TeachingPaperCheckResult;


//�������Ľ����Ϣ��
@Component
public interface TeachingPaperCheckResultMapper {

	   //��ѯ�������ݽӿڶ���
		@Select("select * from jgxy_teaching_research_paper_check_result")
		public List<TeachingPaperCheckResult> getAllTeachingPaperCheckResult();
		
		//���ݽ�ʦ�������������Ʋ�ѯ��¼
		@Select("select * from jgxy_teaching_research_paper_check_result where paper_title=#{paper_title} and teacher_num=#{teacher_num}")
		public TeachingPaperCheckResult getTeachingPaperByPapernameAndTeachernum(@Param("paper_title") String paper_title,@Param("teacher_num")String teacher_num);
		
		//���ݽ�ʦ���������������޸�����
		@Update("update jgxy_teaching_research_paper_check_result set is_in_own=#{is_in_own},"
				                                         + "is_in_peking=#{is_in_peking},"
				                                         + "is_in_scd=#{is_in_scd},"
				                                         + "is_in_ssci=#{is_in_ssci},"
				                                         + "result_is_ok=#{result_is_ok},"
				                                         + "result_info=#{result_info},"
				                                         + "result_level=#{result_level},"
				                                         + "result_message=#{result_message},"
				                                         + "paper_title=#{paper_title},"
				                                         + "teacher_num=#{teacher_num} "
				                                         + "where paper_title=#{paper_title} and teacher_num=#{teacher_num}")
		
		public int updatePaperCheckResultByTeachernumAndPapername(
				                                                   @Param("is_in_own") int is_in_own,
				                                                   @Param("is_in_peking") int is_in_peking,
				                                                   @Param("is_in_scd") int is_in_scd,
				                                                   @Param("is_in_ssci") int is_in_ssci,
				                                                   @Param("result_is_ok") int result_is_ok,
				                                                   @Param("result_info") String result_info,
				                                                   @Param("result_level") String result_level,
				                                                   @Param("result_message") String result_message,
				                                                   @Param("paper_title") String paper_title,
				                                                   @Param("teacher_num") String teacher_num
															       );
		
		
		
		
		//�������ݵĽӿڶ���
		@Insert("insert into jgxy_teaching_research_paper_check_result ("
				                                                + "is_in_own,"
				                                                + "is_in_peking,"
				                                                + "is_in_scd,"
				                                                + "is_in_ssci,"
				                                                + "result_is_ok,"
				                                                + "result_info,"
				                                                + "result_level,"
				                                                + "result_message,"
				                                                + "paper_title,"
				                                                + "teacher_num"
				                                                + ") "
				                  
				                                                + "value "
				                                                + "("
				                                                + "#{is_in_own},"
				                                                + "#{is_in_peking},"
				                                                + "#{is_in_scd},"
				                                                + "#{is_in_ssci},"
				                                                + "#{result_is_ok},"
				                                                + "#{result_info},"
				                                                + "#{result_level},"
				                                                + "#{result_message},"
				                                                + "#{paper_title},"
				                                                + "#{teacher_num}"
				                                                + ")")
		public int insertPaperCheckResult(
				                         @Param("is_in_own")int is_in_own,
				                         @Param("is_in_peking")int is_in_peking,
				                         @Param("is_in_scd")int is_in_scd,
				                         @Param("is_in_ssci")int is_in_ssci,
				                         @Param("result_is_ok")int result_is_ok,
				                         @Param("result_info")String result_info,
				                         @Param("result_level")String result_level,
				                         @Param("result_message")String result_message,
				                         @Param("paper_title")String paper_title,
				                         @Param("teacher_num")String teacher_num
				                         );
	
	
}
