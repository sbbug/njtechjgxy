package com.njtechjgxy.service.library;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.library.PekingLibraryMapper;
import com.njtechjgxy.vo.library.PekingLibrary;

@Service
public class PekingLibraryService {

	
	@Autowired
	private PekingLibraryMapper pekingLibraryMapper;
	
	public int insertPekingLibrary(
            String peking_area,
            String peking_series,
            String peking_name,
            int peking_status){
		
		return pekingLibraryMapper.insertPekingLibrary(peking_area, peking_series, peking_name, peking_status);
	}
	public PekingLibrary selectByPekingName(String peking_name){
		
		return pekingLibraryMapper.selectByPekingName(peking_name);
	}
	
	
	public List<PekingLibrary> getAllPekingLibrary(){
		
		return pekingLibraryMapper.getAllPekingLibrary();
	}
	public int updateByPekingName(
			String peking_area,
            String peking_series,
            String peking_name,
            int peking_status){
		
		return pekingLibraryMapper.updateByPekingName(
				                                     peking_area, 
				                                     peking_series, 
				                                     peking_name,
				                                     peking_status);
	}
}
