package com.jinsu.proj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("hello")
public class HelloMessageConfig {
	@Bean
	public HelloMessage helloMessage() {
		return new HelloMessage();
	}
}
