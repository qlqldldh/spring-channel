package com.spring.exercise;

public class BuserVO {
	private String email;
	private String passwd;
	private String phone;
	private String address;
	private String birth;
	private String name;
	private int enabled;
	private String authority;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BuserVO) {
			BuserVO temp = (BuserVO) obj;
			return this.email.equals(temp.getEmail());
		}
		return false;
	}
	@Override
	public int hashCode() {
		return email.hashCode();
	}
	
}
