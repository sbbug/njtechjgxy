package com.njtechjgxy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.njtechjgxy.vo.Patent;

@Component
public interface PatentMapper {

	//插入数据
	@Insert("insert into jgxy_patent ("
			                         + "patent_status,"
			                         + "patent_department,"
			                         + "patent_first_author,"
			                         + "patent_second_author,"
			                         + "patent_third_author,"
			                         + "patent_other_author,"
			                         + "patent_class,"
			                         + "patent_title,"
			                         + "patent_num,"
			                         + "patent_remark,"
			                         + "patent_path,"
			                         + "patent_date,"
			                         + "teacher_num"
			                         + ")"
			                         + " value "
			                         + "("
			                         + "#{patent_status},"
			                         + "#{patent_department},"
			                         + "#{patent_first_author},"
			                         + "#{patent_second_author},"
			                         + "#{patent_third_author},"
			                         + "#{patent_other_author},"
			                         + "#{patent_class},"
			                         + "#{patent_title},"
			                         + "#{patent_num},"
			                         + "#{patent_remark},"
			                         + "#{patent_path},"
			                         + "#{patent_date},"
			                         + "#{teacher_num})")
	public int insertPatent(
			                @Param("patent_status") int patent_status,
			                @Param("patent_department") String patent_department,
			                @Param("patent_first_author") String patent_first_author,
			                @Param("patent_second_author") String patent_second_author,
			                @Param("patent_third_author") String patent_third_author,
			                @Param("patent_other_author") String patent_other_author,
			                @Param("patent_class") String patent_class,
			                @Param("patent_title") String patent_title,
			                @Param("patent_num") String patent_num,
			                @Param("patent_remark") String patent_remark,
			                @Param("patent_path") String patent_path,
			                @Param("patent_date") String patent_date,
			                @Param("teacher_num") String teacher_num
			                );
	
	//修改数据
	@Update("update jgxy_patent set patent_status=#{patent_status},"
			                     + "patent_department=#{patent_department},"
			                     + "patent_first_author=#{patent_first_author},"
			                     + "patent_second_author=#{patent_second_author},"
			                     + "patent_third_author=#{patent_third_author},"
			                     + "patent_other_author=#{patent_other_author},"
			                     + "patent_class=#{patent_class},"
			                     + "patent_title=#{patent_title},"
			                     + "patent_num=#{patent_num},"
			                     + "patent_remark=#{patent_remark},"
			                     + "patent_path=#{patent_path},"
			                     + "patent_date=#{patent_date},"
			                     + "teacher_num=#{teacher_num} "
			                     + "where patent_title=#{patent_title} and teacher_num=#{teacher_num}")
	public int updatePatentByTitleAndNum(
            @Param("patent_status") int patent_status,
            @Param("patent_department") String patent_department,
            @Param("patent_first_author") String patent_first_author,
            @Param("patent_second_author") String patent_second_author,
            @Param("patent_third_author") String patent_third_author,
            @Param("patent_other_author") String patent_other_author,
            @Param("patent_class") String patent_class,
            @Param("patent_title") String patent_title,
            @Param("patent_num") String patent_num,
            @Param("patent_remark") String patent_remark,
            @Param("patent_path") String patent_path,
            @Param("patent_date") String patent_date,
            @Param("teacher_num") String teacher_num
            );
	
	//查询数据
	//按条件查询
	@Select("select * from jgxy_patent where teacher_num=#{teacher_num}")
	public List<Patent> getPatentsByNum(@Param("teacher_num") String teacher_num);
 	//查询所有数据
	@Select("select *  from jgxy_patent")
	public List<Patent> getPatents();
	//查询一条记录
	@Select("select * from jgxy_patent where teacher_num=#{teacher_num} and patent_title=#{patent_title}")
	public Patent getPatent(@Param("teacher_num") String teacher_num,@Param("patent_title") String patent_title);
	
	
}
