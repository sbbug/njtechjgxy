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

	//插入数据记录的接口定义
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
	
	
	//判断某种期刊是否存在的接口定义,根据期刊的名字进行判断,并返回该期刊
	@Select("select * from jgxy_own_library where own_name=#{own_name}")
	public OwnLibrary selectByName(@Param("own_name") String own_name);
	@Select("select * from jgxy_own_library")
	public List<OwnLibrary> getAllOwnLibrary();
	
	
	//根据期刊的名字修改期刊属性的接口定义
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
