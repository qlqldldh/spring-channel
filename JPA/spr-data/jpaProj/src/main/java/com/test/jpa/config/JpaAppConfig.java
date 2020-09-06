package com.test.jpa.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/* Basic Setting to use Spring JPA */

@Configuration
@EnableTransactionManagement // make enable to use @Transaction
@EnableJpaRepositories("com.test.jpa.repos") // repository class가 저장되는 위치 지정
public class JpaAppConfig {
	@Autowired
	DataSource dataSource;
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(); // transaction 관리를 위해 필요한 클래스 
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
		return jpaTransactionManager;
	} // 이 설정으로 인해 @Transactional을 메서드에 지정하는 것 만으로 JPA의 transaction 관리가 가능해짐
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() { // JPA 구현의 독자적인 설정을 위한 메서드
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.ORACLE);
		vendorAdapter.setShowSql(true);
		return vendorAdapter;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() { // 메서드 이름에 유의
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource); // JPA 영속화 처리에서 사용하는 데이터소스 설정
		factory.setPackagesToScan("com.test.jpa.vo"); // entity class가 정의 되어 있는 패키지 지정
		factory.setJpaVendorAdapter(jpaVendorAdapter());
		return factory;
	}
}
