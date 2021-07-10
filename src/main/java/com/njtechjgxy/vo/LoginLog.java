package com.njtechjgxy.vo;



public class LoginLog {

	private int log_id;
	private String log_time;
	private String log_ip;
	
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	public String getLog_time() {
		return log_time;
	}
	public void setLog_time(String log_time) {
		this.log_time = log_time;
	}
	public String getLog_ip() {
		return log_ip;
	}
	public void setLog_ip(String log_ip) {
		this.log_ip = log_ip;
	}
	@Override
    public String toString() {
        return "LoginLog{" +
                "log_id='" + log_id + '\'' +
                ", log_time='" + log_time + '\'' +
                ", log_ip='" + log_ip + '\'' +
                '}';
    }	 	
}
