package com.njtechjgxy.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.njtechjgxy.vo.Book;

@Component
public interface BookMapper {

	//插入数据
	@Insert("insert into jgxy_book ("
			                        + "book_status,"
			                        + "book_category_class,"
			                        + "book_copyright_type,"
			                        + "book_department,"
			                        + "book_first_author,"
			                        + "book_second_author,"
			                        + "book_third_author,"
			                        + "book_name,"
			                        + "book_press_name,"
			                        + "book_publish_date,"
			                        + "book_words,"
			                        + "book_which,"
			                        + "book_remark,"
			                        + "book_path,"
			                        + "book_date,"
			                        + "teacher_num"
			                        + ") value ("
			                        + "#{book_status},"
			                        + "#{book_category_class},"
			                        + "#{book_copyright_type},"
			                        + "#{book_department},"
			                        + "#{book_first_author},"
			                        + "#{book_second_author},"
			                        + "#{book_third_author},"
			                        + "#{book_name},"
			                        + "#{book_press_name},"
			                        + "#{book_publish_date},"
			                        + "#{book_words},"
			                        + "#{book_which},"
			                        + "#{book_remark},"
			                        + "#{book_path},"
			                        + "#{book_date},"
			                        + "#{teacher_num}"
			                        + ")")
	public int insertBook(
			              @Param("book_status") int book_status,
			              @Param("book_category_class") String book_category_class,
			              @Param("book_copyright_type") String book_copyright_type,
			              @Param("book_department") String book_department,
			              @Param("book_first_author") String book_first_author,
			              @Param("book_second_author") String book_second_author,
			              @Param("book_third_author") String book_third_author,
			              @Param("book_name") String book_name,
			              @Param("book_press_name") String book_press_name,
			              @Param("book_publish_date") String book_publish_date,
			              @Param("book_words") String book_words,
			              @Param("book_which") String book_which,
			              @Param("book_remark") String book_remark,
			              @Param("book_path") String book_path,
			              @Param("book_date") Date book_date,
			              @Param("teacher_num") String teacher_num
			              );
	//修改数据
	@Update("update jgxy_book set book_status=#{book_status},"
			                   + "book_category_class=#{book_category_class},"
			                   + "book_copyright_type=#{book_copyright_type},"
			                   + "book_department=#{book_department},"
			                   + "book_first_author=#{book_first_author},"
			                   + "book_second_author=#{book_second_author},"
			                   + "book_third_author=#{book_third_author},"
			                   + "book_name=#{book_name},"
			                   + "book_press_name=#{book_press_name},"
			                   + "book_publish_date=#{book_publish_date},"
			                   + "book_words=#{book_words},"
			                   + "book_which=#{book_which},"
			                   + "book_remark=#{book_remark},"
			                   + "book_path=#{book_path},"
			                   + "book_date=#{book_date},"
			                   + "teacher_num=#{teacher_num}  where teacher_num=#{teacher_num} and book_id=#{book_id}")
	public int updateBookByNumAndId(
			@Param("book_id") int book_id,
            @Param("book_status") int book_status,
            @Param("book_category_class") String book_category_class,
            @Param("book_copyright_type") String book_copyright_type,
            @Param("book_department") String book_department,
            @Param("book_first_author") String book_first_author,
            @Param("book_second_author") String book_second_author,
            @Param("book_third_author") String book_third_author,
            @Param("book_name") String book_name,
            @Param("book_press_name") String book_press_name,
            @Param("book_publish_date") String book_publish_date,
            @Param("book_words") String book_words,
            @Param("book_which") String book_which,
            @Param("book_remark") String book_remark,
            @Param("book_path") String book_path,
            @Param("book_date") Date book_date,
            @Param("teacher_num") String teacher_num
            );
	
	//按照条件查询数据
	@Select("select * from jgxy_book where teacher_num=#{teacher_num}")
	public List<Book> getBooksByNum(@Param("teacher_num") String teacher_num);
	
	@Select("select * from jgxy_book where teacher_num=#{teacher_num} and book_name=#{book_name}")
	public Book getBookByNum(@Param("teacher_num") String teacher_num,@Param("book_name") String book_name);
	//查询所有数据
	@Select("select * from jgxy_book")
	public List<Book> getAllBooks();
	
}
