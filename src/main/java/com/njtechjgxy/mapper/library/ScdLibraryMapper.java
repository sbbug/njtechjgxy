package com.njtechjgxy.mapper.library;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.njtechjgxy.vo.library.ScdLibrary;

@Component
public interface ScdLibraryMapper {

	    //插入数据记录的接口定义
	    @Insert("insert into jgxy_scd_library ("
	    		                               + "scd_name,"
	    		                               + "scd_issn,"
	    		                               + "scd_cn,"
	    		                               + "scd_status"
	    		                               + ")"
	    		                               + " value "
	    		                               + "("
	    		                               + "#{scd_name},"
	    		                               + "#{scd_issn},"
	    		                               + "#{scd_cn},"
	    		                               + "#{scd_status}"
	    		                               + ")")
	    public int insertScdLibrary(
	    		                   @Param("scd_name")String scd_name,
	    		                   @Param("scd_issn")String scd_issn,
	    		                   @Param("scd_cn")String scd_cn,
	    		                   @Param("scd_status")int scd_status
			                       );
	
		//判断某种期刊是否存在的接口定义,如果存在，返回该期刊
		@Select("select * from jgxy_scd_library where scd_name=#{scd_name}")
		public ScdLibrary selectByScdName(@Param("scd_name")String scd_name);
		@Select("select * from jgxy_scd_library")
		public List<ScdLibrary> getAllScdLibrary();
		
		//期刊修改接口定义
	    @Update("update jgxy_scd_library set scd_name=#{scd_name},"
	    		                          + "scd_issn=#{scd_issn},"
	    		                          + "scd_cn=#{scd_cn},"
	    		                          + "scd_status=#{scd_status} "
	    		                          + "where scd_name=#{scd_name}")
	    public int updateByScdName(     @Param("scd_name")String scd_name,
						                @Param("scd_issn")String scd_issn,
						                @Param("scd_cn")String scd_cn,
						                @Param("scd_status")int scd_status);
	    
}
