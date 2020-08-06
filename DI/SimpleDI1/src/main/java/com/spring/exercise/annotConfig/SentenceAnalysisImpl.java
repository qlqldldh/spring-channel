package com.spring.exercise.annotConfig;

import org.springframework.stereotype.Component;

@Component
public class SentenceAnalysisImpl implements SentenceAnalysis {

	@Override
	public String getSubject(String str) {
		String[] temp = str.split(" ");
		return temp[0];
	}

}
