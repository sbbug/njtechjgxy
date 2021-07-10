package com.njtechjgxy.mapper.library;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.njtechjgxy.vo.library.SsciLibrary;

@Component
public interface SsciLibraryMapper {
  
	    //插入数据记录的接口定义
	    @Insert("insert into jgxy_ssci_library ("
	    		                                + "ssci_chinese_name,"
	    		                                + "ssci_English_name,"
	    		                                + "ssci_class,"
	    		                                + "ssci_issn,"
	    		                                + "ssci_status"
	    		                                + ") "
	    		                                + "value "
	    		                                + "("
	    		                                + "#{ssci_chinese_name},"
	    		                                + "#{ssci_English_name},"
	    		                                + "#{ssci_class},"
	    		                                + "#{ssci_issn},"
	    		                                + "#{ssci_status})")
	    public int insertSsciLibrary(
	    		                    @Param("ssci_chinese_name")String ssci_chinese_name,
	    		                    @Param("ssci_English_name")String ssci_English_name,
	    		                    @Param("ssci_class")String ssci_class,
	    		                    @Param("ssci_issn")String ssci_issn,
	    		                    @Param("ssci_status")int ssci_status
	    		                    );
	
	
		//判断某种期刊是否存在的接口定义
		@Select("select * from jgxy_ssci_library where ssci_chinese_name=#{ssci_chinese_name}")
		public SsciLibrary selectBySsciChineseName(@Param("ssci_chinese_name")String ssci_chinese_name);
		@Select("select * from jgxy_ssci_library")
		public List<SsciLibrary> getAllSsciLibrary();
		
		//期刊修改接口定义
		@Update("update jgxy_ssci_library set "
				                           + "ssci_chinese_name=#{ssci_chinese_name},"
				                           + "ssci_English_name=#{ssci_English_name},"
				                           + "ssci_status=#{ssci_status},"
				                           + "ssci_class=#{ssci_class},"
				                           + "ssci_issn=#{ssci_issn} where ssci_chinese_name=#{ssci_chinese_name}")
	    public int updateSsciLibrary(
						    		@Param("ssci_chinese_name")String ssci_chinese_name,
					                @Param("ssci_English_name")String ssci_English_name,
					                @Param("ssci_class")String ssci_class,
					                @Param("ssci_issn")String ssci_issn,
					                @Param("ssci_status")int ssci_status);
}
