package com.bean.library;

public class UserData {
	private int usid;
	private int type;
	private String username;
	private String password;
	private String salt;
	private int timereg;
	private String email;
	private int isseller;
	
	public int getUsid() {
		return usid;
	}
	public void setUsid(int usid) {
		this.usid = usid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getTimereg() {
		return timereg;
	}
	public void setTimereg(int timereg) {
		this.timereg = timereg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIsseller() {
		return isseller;
	}
	public void setIsseller(int isseller) {
		this.isseller = isseller;
	}
}
