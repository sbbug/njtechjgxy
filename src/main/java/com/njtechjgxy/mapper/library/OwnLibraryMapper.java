package com.njtechjgxy.mapper.library;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.njtechjgxy.vo.library.OwnLibrary;


@Component
public interface OwnLibraryMapper {

	//�������ݼ�¼�Ľӿڶ���
	@Insert("insert into jgxy_own_library (  own_issn,"
			                               + "own_name,"
			                               + "own_area,"
			                               + "own_fullname,"
			                               + "own_rank,"
			                               + "own_status)"
			                               + " value "
			                               + "(#{own_issn},"
			                               + "#{own_name},"
			                               + "#{own_area},"
			                               + "#{own_fullname},"
			                               + "#{own_rank},"
			                               + "#{own_status})")
	public int insertOwnLibrary(@Param("own_issn") String own_issn,
			                    @Param("own_name") String own_name,
			                    @Param("own_area") int own_area,
			                    @Param("own_fullname") String own_fullname,
			                    @Param("own_rank") String own_rank,
			                    @Param("own_status") int own_status);
	
	
	//�ж�ĳ���ڿ��Ƿ���ڵĽӿڶ���,�����ڿ������ֽ����ж�,�����ظ��ڿ�
	@Select("select * from jgxy_own_library where own_name=#{own_name}")
	public OwnLibrary selectByName(@Param("own_name") String own_name);
	@Select("select * from jgxy_own_library")
	public List<OwnLibrary> getAllOwnLibrary();
	
	
	//�����ڿ��������޸��ڿ����ԵĽӿڶ���
    @Update("update jgxy_own_library set own_issn=#{own_issn},"
    		                           + "own_name=#{own_name},"
    		                           + "own_area=#{own_area},"
    		                           + "own_fullname=#{own_fullname},"
    		                           + "own_rank=#{own_rank},"
    		                           + "own_status=#{own_status} "
    		                           + "where own_name=#{own_name}")
    public int updateByName(@Param("own_issn") String own_issn,
				            @Param("own_name") String own_name,
				            @Param("own_area") int own_area,
				            @Param("own_fullname") String own_fullname,
				            @Param("own_rank") String own_rank,
				            @Param("own_status") int own_statu);
	
}
