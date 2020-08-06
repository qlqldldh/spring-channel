package com.spring.exercise.autowrdWithColctn;

import org.springframework.stereotype.Component;

@Component("numberAdder")
public class NumberAdder implements DataDealer<Integer>{

	@Override
	public Integer deal(String datas) {
		int ret=0;
		int n;
		try {
			for(int i=0;i<datas.length();i++) {
				n=datas.charAt(i)-48;
				if(n>=0 && n<=9) ret+=n;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		System.out.println("NumberAdder Class Accessed");
		return ret;
	}

}
