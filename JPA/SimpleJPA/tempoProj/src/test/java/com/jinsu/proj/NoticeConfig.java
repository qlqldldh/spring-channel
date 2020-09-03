package com.jinsu.proj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jinsu.proj.service.NoticeService;

@Configuration
public class NoticeConfig {
	
	@Bean
	public NoticeService noticeService() {
		return new NoticeService();
	}
}
