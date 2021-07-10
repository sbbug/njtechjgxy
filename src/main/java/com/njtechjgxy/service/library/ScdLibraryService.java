package com.njtechjgxy.service.library;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.library.ScdLibraryMapper;
import com.njtechjgxy.vo.library.ScdLibrary;

@Service
public class ScdLibraryService {

	@Autowired
	private ScdLibraryMapper scdLibraryMapper;
	
	
	public int insertScdLibrary(
             String scd_name,
             String scd_issn,
             String scd_cn,
             int scd_status
             ){
		
		return scdLibraryMapper.insertScdLibrary(scd_name, scd_issn, scd_cn, scd_status);
	}
	
	public ScdLibrary selectByScdName(String scd_name){
		
		return scdLibraryMapper.selectByScdName(scd_name);
	}
	
	public int updateByScdName(     
								String scd_name,
					            String scd_issn,
					            String scd_cn,
					            int scd_status){
		return scdLibraryMapper.updateByScdName(scd_name, scd_issn, scd_cn, scd_status);
	}
	 public List<ScdLibrary> getAllScdLibrary(){
		 
		 return scdLibraryMapper.getAllScdLibrary();
	 }
}
