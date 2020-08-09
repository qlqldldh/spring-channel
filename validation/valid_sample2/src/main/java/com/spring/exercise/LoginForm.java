package com.spring.exercise;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.spring.config.AlphaNumeric;

public class LoginForm implements Serializable{
	
	@NotEmpty(message="empty value is not allowed")
	@AlphaNumeric(message="ID : only Numbers or Alphabets are possible")
//	@Pattern(regexp="[a-zA-Z0-9+]*", message="only Numbers or Alphabets are possible")
	private String uid;
	
	@NotEmpty(message="empty value is not allowed")
	private String pwd;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
