package com.njtechjgxy.vo;

public class PrizeCheckResult {

	private int result_id;
	private int result_is_ok;
	private String result_rank;
	private String result_message;
	private String prize_uuid;
	private String teacher_num;
	public String getPrize_uuid() {
		return prize_uuid;
	}
	public void setPrize_uuid(String prize_uuid) {
		this.prize_uuid = prize_uuid;
	}
	
	
	public int getResult_id() {
		return result_id;
	}
	public void setResult_id(int result_id) {
		this.result_id = result_id;
	}
	public int getResult_is_ok() {
		return result_is_ok;
	}
	public void setResult_is_ok(int result_is_ok) {
		this.result_is_ok = result_is_ok;
	}
	public String getResult_rank() {
		return result_rank;
	}
	public void setResult_rank(String result_rank) {
		this.result_rank = result_rank;
	}
	public String getResult_message() {
		return result_message;
	}
	public void setResult_message(String result_message) {
		this.result_message = result_message;
	}
	
	public String getTeacher_num() {
		return teacher_num;
	}
	public void setTeacher_num(String teacher_num) {
		this.teacher_num = teacher_num;
	}
	
	
	
}
