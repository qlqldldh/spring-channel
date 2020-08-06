package com.spring.exercise.annotConfig;

import org.springframework.stereotype.Component;

@Component("aCounter")
public class ACounterImpl implements ACounter{

	@Override
	public int countAChar(String str) {
		int ret=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='a' || str.charAt(i)=='A') ret+=1;
		}
		
		return ret;
	}

}
