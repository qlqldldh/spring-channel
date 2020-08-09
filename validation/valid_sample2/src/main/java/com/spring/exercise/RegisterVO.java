package com.spring.exercise;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.spring.config.AlphaNumeric;
import com.spring.config.EqualsPropertyValues;

@EqualsPropertyValues(property="pwd", comparingProperty="repwd", message="repwd2:not same.")
public class RegisterVO implements Serializable {
	
	@NotEmpty(message="uid:not allow empty input value")
	@Size(max=20)
	@AlphaNumeric(message="uid:only Numbers or Alphabets are possible")
	private String uid;
	
	@NotEmpty(message="pwd:not allow empty input value")
	private String pwd;
	
	@NotEmpty(message="repwd:not allow empty input value")
	private String repwd;
	
	@NotEmpty(message="name:not allow empty input value")
	private String name;
	
	@NotNull(message="age:You forgot to type your AGE!")
	private int age;
	
	
	private String address;
	
	@Email(message="email:Pls keep EMAIL Form")
	private String email;

	// Getter / Setter //

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

	public String getRepwd() {
		return repwd;
	}


	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
}
