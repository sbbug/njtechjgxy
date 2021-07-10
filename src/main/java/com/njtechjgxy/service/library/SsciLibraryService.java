package com.njtechjgxy.service.library;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.library.SsciLibraryMapper;
import com.njtechjgxy.vo.library.SsciLibrary;

@Service
public class SsciLibraryService {

	@Autowired
	private SsciLibraryMapper ssciLibraryMapper;
	
	public int insertSsciLibrary(
            String ssci_chinese_name,
            String ssci_Eglish,
            String ssci_class,
            String ssci_issn,
            int ssci_status
            ){
		
		return ssciLibraryMapper.insertSsciLibrary(ssci_chinese_name, ssci_Eglish, ssci_class, ssci_issn, ssci_status);
	}
	public SsciLibrary selectBySsciChineseName(String ssci_chinese_name){
		
		return ssciLibraryMapper.selectBySsciChineseName(ssci_chinese_name);
	}
	  public int updateSsciLibrary(
	    		                  String ssci_chinese_name,
                                  String ssci_English_name,
                                  String ssci_class,
                                  String ssci_issn,
                                  int ssci_status){
		  return ssciLibraryMapper.updateSsciLibrary(
				                                    ssci_chinese_name, 
				                                    ssci_English_name, 
				                                    ssci_class, 
				                                    ssci_issn,
				                                    ssci_status);
	  }
	public List<SsciLibrary> getAllSsciLibrary(){
		
		return ssciLibraryMapper.getAllSsciLibrary();
	}
	
	
}
