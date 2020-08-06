package com.spring.exercise.javaConfig;

public class UserCheckImpl implements UserCheck {

	UserCheckImpl(){}
	
	@Override
	public boolean isOurUser(String email) {
		return email.equals("qlqldldh@naver.com");
	}

}
