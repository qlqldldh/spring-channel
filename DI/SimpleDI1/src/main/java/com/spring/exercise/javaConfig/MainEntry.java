package com.spring.exercise.javaConfig;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			ApplicationContext apc = new AnnotationConfigApplicationContext(AppConfig.class);
			UserCheck userCheck = apc.getBean(UserCheck.class);
	
			String email = sc.next();
			
			if (userCheck.isOurUser(email)) {
				System.out.println("Yes, our User! : " + email);
			} else
				System.out.println("Not our user.");

		} catch (Exception e) {
			e.printStackTrace();
		}

		sc.close();
	}
}
