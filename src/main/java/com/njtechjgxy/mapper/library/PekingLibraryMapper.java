package com.njtechjgxy.mapper.library;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.njtechjgxy.vo.library.PekingLibrary;

@Component
public interface PekingLibraryMapper {

	    //�������ݼ�¼�Ľӿڶ���
	    @Insert("insert into jgxy_peking_library ("
	    		                                 + "peking_area,"
	    		                                 + "peking_series,"
	    		                                 + "peking_name,"
	    		                                 + "peking_status) value "
	    		                                 + "("
	    		                                 + "#{peking_area},"
	    		                                 + "#{peking_series},"
	    		                                 + "#{peking_name},"
	    		                                 + "#{peking_status}"
	    		                                 + ")")
	    public int insertPekingLibrary(
	    		                      @Param("peking_area")String peking_area,
	    		                      @Param("peking_series")String peking_series,
	    		                      @Param("peking_name")String peking_name,
	    		                      @Param("peking_status")int peking_status);
	
	
		//�ж�ĳ���ڿ��Ƿ���ڵĽӿڶ���,������ڷ��ظ��ڿ�
		@Select("select * from jgxy_peking_library where peking_name=#{peking_name}")
		public PekingLibrary selectByPekingName(@Param("peking_name")String peking_name);
		
		@Select("select * from jgxy_peking_library")
		public List<PekingLibrary> getAllPekingLibrary();
		
		//�ڿ��޸Ľӿڶ���
		@Update("update jgxy_peking_library set peking_area=#{peking_area},"
				                             + "peking_series=#{peking_series},"
				                             + "peking_name=#{peking_name},"
				                             + "peking_status=#{peking_status} where peking_name=#{peking_name}")
		public int updateByPekingName(@Param("peking_area")String peking_area,
						                @Param("peking_series")String peking_series,
						                @Param("peking_name")String peking_name,
						                @Param("peking_status")int peking_status);
}
