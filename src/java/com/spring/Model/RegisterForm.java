package com.spring.Model;

import com.andromeda.commons.model.BaseModel;

public class RegisterForm extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	
	public String name;
	public String email;
	public String message;
	/*public String mobileno;
	public String email;
	public String dob;
	public String gender;
	public String qualification;
	public String branch;
	public String address;
*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	


}
