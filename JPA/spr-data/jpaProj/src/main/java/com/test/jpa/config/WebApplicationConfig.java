package com.test.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*
 * Web Application에서는 화면을 렌더링하기 전에 트랜젝션을 종료해버리는 패턴이 일반적이기 때문에
 * 화면을 렌더링할 때 Entity에 접근하면 LAZY fetch를 할 수 없기 때문에 예상 값을 취득할 수 없는 문제 발생.
 * 
 * 해당 설정을 통해서 트랜잭션 종료 후에도 EntityManager를 닫지 않고 
 * Entity를 관리 상태로 유지하고 웹 화면의 렌더링이 끝날 때까지
 * Lazy fetch가 가능하게 함.
 */

@Configuration
public class WebApplicationConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor() {
		return new OpenEntityManagerInViewInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addWebRequestInterceptor(openEntityManagerInViewInterceptor())
		.addPathPatterns("/**").excludePathPatterns("/**/*.html")
		.excludePathPatterns("/**/*.js")
		.excludePathPatterns("/**/*.css")
		.excludePathPatterns("/**/*.png");
	}
}
