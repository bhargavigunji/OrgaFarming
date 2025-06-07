package com.spring.Model;

import com.andromeda.commons.model.BaseModel;

public class Login extends BaseModel
{
	private static final long serialVersionUID = 1L;
	private String userName;
	private String email;
	private String password;
	private String type;
	private String ipAddress;
	private String logtime;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}