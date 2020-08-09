package com.spring.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegisDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public int insertUser(RegisterVO rv) {
		String sql = "insert into login values(?,?,?,?,?,?)";
		
		String uid = rv.getUid();
		String pwd = rv.getPwd();
		String name = rv.getName();
		int age = rv.getAge();
		String address = rv.getAddress();
		String email = rv.getEmail();
		
		return jdbcTemplate.update(sql,uid,pwd,name,age,address,email);
	}
}
