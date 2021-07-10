package com.njtechjgxy.vo;

public class Teacher {

	private int teacher_id;
	private String teacher_num;
	private String teacher_password;
	private int teacher_status;
	private String teacher_name;
	private String teacher_department;
	private String teacher_sex;
	private String teacher_address;
	private String teacher_ID_Card;
	private String teacher_birthday;
	private String teacher_education;
	private String teacher_title;
	private String teacher_remark;
	public String getTeacher_remark() {
		return teacher_remark;
	}
	public void setTeacher_remark(String teacher_remark) {
		this.teacher_remark = teacher_remark;
	}
	public String getTeacher_department() {
		return teacher_department;
	}
	public void setTeacher_department(String teacher_department) {
		this.teacher_department = teacher_department;
	}
	public String getTeacher_sex() {
		return teacher_sex;
	}
	public void setTeacher_sex(String teacher_sex) {
		this.teacher_sex = teacher_sex;
	}
	public String getTeacher_address() {
		return teacher_address;
	}
	public void setTeacher_address(String teacher_address) {
		this.teacher_address = teacher_address;
	}
	public String getTeacher_ID_Card() {
		return teacher_ID_Card;
	}
	public void setTeacher_ID_Card(String teacher_ID_Card) {
		this.teacher_ID_Card = teacher_ID_Card;
	}
	public String getTeacher_birthday() {
		return teacher_birthday;
	}
	public void setTeacher_birthday(String teacher_birthday) {
		this.teacher_birthday = teacher_birthday;
	}
	public String getTeacher_education() {
		return teacher_education;
	}
	public void setTeacher_education(String teacher_education) {
		this.teacher_education = teacher_education;
	}
	public String getTeacher_title() {
		return teacher_title;
	}
	public void setTeacher_title(String teacher_title) {
		this.teacher_title = teacher_title;
	}					
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeacher_num() {
		return teacher_num;
	}
	public void setTeacher_num(String teacher_num) {
		this.teacher_num = teacher_num;
	}
	public String getTeacher_password() {
		return teacher_password;
	}
	public void setTeacher_password(String teacher_password) {
		this.teacher_password = teacher_password;
	}
	public int getTeacher_status() {
		return teacher_status;
	}
	public void setTeacher_status(int teacher_status) {
		this.teacher_status = teacher_status;
	}	
	@Override
    public String toString() {
        return "Teacher{" +
                "teacher_id='" + teacher_id + '\'' +
                ", teacher_num='" + teacher_num + '\'' +
                ", teacher_password='" + teacher_password + '\'' +
                ", teacher_status='" + teacher_status + '\'' +
                 ", teacher_name='" + teacher_name + '\'' +
                '}';
    }	
}
