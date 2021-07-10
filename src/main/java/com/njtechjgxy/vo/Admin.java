package com.njtechjgxy.vo;

public class Admin {

	private int admin_id;
	private String admin_num;
	private String admin_password;
	private int admin_level;
	
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int amdin_id) {
		this.admin_id = amdin_id;
	}
	public String getAdmin_num() {
		return admin_num;
	}
	public void setAdmin_num(String admin_num) {
		this.admin_num = admin_num;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public int getAdmin_level() {
		return admin_level;
	}
	public void setAdmin_level(int admin_level) {
		this.admin_level = admin_level;
	}
	@Override
    public String toString() {
        return "Admin{" +
                "admin_id='" + admin_id + '\'' +
                ", admin_num='" +admin_num + '\'' +
                ", admin_password='" + admin_password + '\'' +
                '}';
    }	
}
