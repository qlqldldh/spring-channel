package com.spring.exercise.autowrdWithColctn;

import org.springframework.stereotype.Component;

@Component("numberCount")
public class NumberCounter implements DataDealer<Integer>{

	@Override
	public Integer deal(String datas) {
		int ret=0;
		int n;
		try {
			for(int i=0;i<datas.length();i++) {
				n=datas.charAt(i)-48;
				if(n>=0 && n<=9) ret+=1;
			}
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		System.out.println("NumberCount Class Accessed");
		return ret;
	}

}
