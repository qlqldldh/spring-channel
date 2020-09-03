package com.jinsu.proj.config;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jinsu.proj.ServiceMessage;

@Configuration
public class AppConfig {
	
	@Bean
	public ServiceMessage serviceMessage() {
		return new ServiceMessage();
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}
