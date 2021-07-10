package com.njtechjgxy.vo;

import java.util.List;

public class Page<T> {

	//��ǰ�ǵڼ�����¼
	private int  nowNum;
	//ÿһҳ�ж�������¼
    private int pageNum;
    //һ���ж���ҳ
    private int pages;
    //һ���ж�������¼
    private int allNum;
    //��ҳ����������ݼ���
    private List<T> datas=null;
    
    
    public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getAllNum() {
		return allNum;
	}
	public void setAllNum(int allNum) {
		this.allNum = allNum;
	}
	public Page(int nowNum,int pageNum,int allNum,List<T> datas){
    	this.nowNum = nowNum;
    	this.pageNum = pageNum;
    	this.allNum = allNum;
    	this.datas = datas;
    }
	public int getNowNum() {
		return nowNum;
	}
	public void setNowNum(int nowNum) {
		this.nowNum = nowNum;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	//������һҳ
	public List<T> nextPage(){
		System.out.println("===================allNum  "+allNum+"==========="+nowNum+"=========");
		
		
        if(allNum<pageNum){
			
			return  datas.subList(0, allNum);
		}
		
		if(nowNum+2*pageNum>=allNum){
			System.out.println("========"+nowNum+"=============="+(allNum-1)+"=================");
			return datas.subList(nowNum+pageNum, allNum);
		}else{
			nowNum=nowNum+pageNum;
		}
		
		
		
		
		return datas.subList(nowNum, nowNum+pageNum);
	}
	//������һҳ
	public List<T> prePage(){
		
		System.out.println("=======================================");
		
		if(allNum<pageNum){
				
				return  datas.subList(0, allNum);
	     }
		
		if(nowNum-pageNum<0){
			nowNum = 0;
		}
		else{
			nowNum=nowNum-pageNum;
		}
		
		return datas.subList(nowNum, nowNum+pageNum);
	}
	//��ȡ��һҳ����
	public List<T> firstPage(){
		
		//��ʱҪ��nowNum����
		nowNum=0;
		
		if(allNum<pageNum){
			return datas.subList(0, allNum);
		}
				
		return datas.subList(0, pageNum);
	}
}
