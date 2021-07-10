package com.njtechjgxy.service.library;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njtechjgxy.mapper.library.OwnLibraryMapper;
import com.njtechjgxy.vo.library.OwnLibrary;

@Service
public class OwnLibraryService {

	@Autowired
	private OwnLibraryMapper ownLibraryMapper;
	
	//���뵥������
	public int insertOwnLibrary(String own_issn,
					            String own_name,
					            int own_area,
					            String own_fullname,
					            String own_rank,
					            int own_status){
		
		return ownLibraryMapper.insertOwnLibrary(
				                                 own_issn, 
				                                 own_name, 
				                                 own_area, 
				                                 own_fullname, 
				                                 own_rank, 
				                                 own_status);
	}
	//�������ֲ�������
	public OwnLibrary selectByName(String own_name){
		
		return ownLibraryMapper.selectByName(own_name);
	}
	//�ܾ�����ʵ�����ݵĸ���
	 public int updateByName( 
			                 String own_issn,
				             String own_name,
				             int own_area,
				             String own_fullname,
				             String own_rank,
				             int own_statu
				             ){
		 
		 return ownLibraryMapper.updateByName(
				                             own_issn,
				                             own_name, 
				                             own_area,
				                             own_fullname, 
				                             own_rank, 
				                             own_statu);
	 }
	public List<OwnLibrary> getAllOwnLibrary(){
		
		return ownLibraryMapper.getAllOwnLibrary();
	}
	
}
