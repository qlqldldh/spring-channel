package com.spring.exercise.javaConfig;

import org.springframework.context.annotation.Bean;

//@Configuration // @Configuration이 제외되어야 오히려 에러 없음. 아이러니 // 해결 : cglib 의존성을 추가해야 함
public class AppConfig {
	@Bean
	UserCheck userCheck() {
		return new UserCheckImpl();
	}
}
