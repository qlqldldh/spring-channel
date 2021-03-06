package com.spring.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@PropertySource("classpath:jdbc.properties")
public class PoolingDataSourceConfig {
	@Bean(destroyMethod="close")
	public DataSource dataSource(
	/*
	 * @Value("${database.driverClassName}") String driverClassName,
	 * 
	 * @Value("${database.url}") String url,
	 * 
	 * @Value("${database.username}") String username,
	 * 
	 * @Value("${database.password}") String password,
	 * 
	 * @Value("${cp.maxTotal}") int maxTotal,
	 * 
	 * @Value("${cp.maxIdle}") int maxIdle,
	 * 
	 * @Value("${cp.minIdle}") int minIdle,
	 * 
	 * @Value("${cp.maxWaitMillis}") long maxWaitMillis
	 */
			) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE");
		dataSource.setUsername("ssssuu");
		dataSource.setPassword("9531");
		dataSource.setDefaultAutoCommit(true);
		dataSource.setMaxTotal(96);
		dataSource.setMaxIdle(16);
		dataSource.setMinIdle(0);
		dataSource.setMaxWaitMillis(60000);
		
		return dataSource;
	}
}
