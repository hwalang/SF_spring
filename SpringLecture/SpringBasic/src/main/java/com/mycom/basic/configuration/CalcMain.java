package com.mycom.basic.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalcMain {
	
	public static void main(String[] args) {

		// spring을 이용한 DI
		// 3. DI by Java Configuration
		// AnnotationConfigApplicationContext: @Configuration을 이해하는 spring context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CalcConfiguration.class);
		
		Calculator cal = (Calculator) context.getBean("calculator");	// @Bean이 붙어있는 메소드의 이름
		int n = cal.add(10, 5);
		System.out.println(n);
		
		context.close();
		
	}

}
