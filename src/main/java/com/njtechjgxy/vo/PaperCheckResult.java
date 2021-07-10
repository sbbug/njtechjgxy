package com.njtechjgxy.vo;

public class PaperCheckResult {

	private int result_id;
	private int is_in_own;
	private int is_in_peking;
	private int is_in_scd;
	private int is_in_ssci;
	private int result_is_ok;
	private String result_info;
	private String result_level;
	private String result_message;
	private String paper_title;
	private String teacher_num;
	
	
	public int getIs_in_own() {
		return is_in_own;
	}
	public void setIs_in_own(int is_in_own) {
		this.is_in_own = is_in_own;
	}
	public int getIs_in_peking() {
		return is_in_peking;
	}
	public void setIs_in_peking(int is_in_peking) {
		this.is_in_peking = is_in_peking;
	}
	public int getIs_in_scd() {
		return is_in_scd;
	}
	public void setIs_in_scd(int is_in_scd) {
		this.is_in_scd = is_in_scd;
	}
	public int getIs_in_ssci() {
		return is_in_ssci;
	}
	public void setIs_in_ssci(int is_in_ssci) {
		this.is_in_ssci = is_in_ssci;
	}
	public String getTeacher_num() {
		return teacher_num;
	}
	public void setTeacher_num(String teacher_num) {
		this.teacher_num = teacher_num;
	}	
	public int getResult_id() {
		return result_id;
	}
	public void setResult_id(int result_id) {
		this.result_id = result_id;
	}
	public String getResult_level() {
		return result_level;
	}
	public void setResult_level(String result_level) {
		this.result_level = result_level;
	}
	public String getResult_info() {
		return result_info;
	}
	public void setResult_info(String result_info) {
		this.result_info = result_info;
	}
	public int getResult_is_ok() {
		return result_is_ok;
	}
	public void setResult_is_ok(int result_is_ok) {
		this.result_is_ok = result_is_ok;
	}
	public String getPaper_title() {
		return paper_title;
	}
	public void setPaper_title(String paper_title) {
		this.paper_title = paper_title;
	}	
	public String getResult_message() {
		return result_message;
	}
	public void setResult_message(String result_message) {
		this.result_message = result_message;
	}
}
