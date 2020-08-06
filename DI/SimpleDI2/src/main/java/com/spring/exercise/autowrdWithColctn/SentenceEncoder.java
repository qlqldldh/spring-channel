package com.spring.exercise.autowrdWithColctn;

import org.springframework.stereotype.Component;

@Component("sentenceEncoder")
public class SentenceEncoder implements DataDealer<String>{

	@Override
	public String deal(String datas) {
		StringBuffer ret = new StringBuffer();
		
		int sz = datas.length();
		for(int i=0;i<sz;i++) {
			ret.append((datas.charAt(i)+datas.charAt(sz-1-i))%127);
		}
		System.out.println("SentenceEncoder Class Accessed");
		return ret.toString();
	}

}
