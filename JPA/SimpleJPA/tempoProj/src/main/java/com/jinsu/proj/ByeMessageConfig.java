package com.jinsu.proj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("bye")
public class ByeMessageConfig {
	
	@Bean
	public AmbgMessage ambgMessage() {
		return new ByeMessage();
	}
}
