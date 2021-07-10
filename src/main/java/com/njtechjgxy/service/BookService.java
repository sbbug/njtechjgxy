package com.njtechjgxy.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.BookMapper;
import com.njtechjgxy.vo.Book;

@Service
public class BookService {

	@Autowired
	private BookMapper bookMapper;
	
	public int insertBook(
             int book_status,
             String book_category_class,
             String book_copyright_type,
             String book_department,
             String book_first_author,
             String book_second_author,
             String book_third_author,
             String book_name,
             String book_press_name,
             String book_publish_date,
             String book_words,
             String book_which,
             String book_remark,
             String book_path,
             Date book_date,
             String teacher_num
            ){
		
		return bookMapper.insertBook(
				                    book_status, 
				                    book_category_class, 
				                    book_copyright_type, 
				                    book_department, 
				                    book_first_author,
				                    book_second_author, 
				                    book_third_author, 
				                    book_name, 
				                    book_press_name, 
				                    book_publish_date, 
				                    book_words, 
				                    book_which, 
				                    book_remark, 
				                    book_path,
				                    book_date,
				                    teacher_num);
	}
	
	public int updateBookByNumAndId(
			 int book_id,
             int book_status,
             String book_category_class,
             String book_copyright_type,
             String book_department,
             String book_first_author,
             String book_second_author,
             String book_third_author,
             String book_name,
             String book_press_name,
             String book_publish_date,
             String book_words,
             String book_which,
             String book_remark,
             String book_path,
             Date book_date,
             String teacher_num
            ){
		
		return bookMapper.updateBookByNumAndId(
				                              book_id, 
				                              book_status, 
				                              book_category_class, 
				                              book_copyright_type, 
				                              book_department, 
				                              book_first_author, 
				                              book_second_author,
				                              book_third_author, 
				                              book_name, 
				                              book_press_name, 
				                              book_publish_date, 
				                              book_words, 
				                              book_which, 
				                              book_remark, 
				                              book_path,
				                              book_date, 
				                              teacher_num);
	}
	public List<Book> getBooksByNum( String teacher_num){
		return bookMapper.getBooksByNum(teacher_num);
	}
	public List<Book> getAllBooks(){
		return bookMapper.getAllBooks();
	}
	public Book getBookByNum( String teacher_num, String book_name){
		
		return bookMapper.getBookByNum(teacher_num, book_name);
	}
	
}
