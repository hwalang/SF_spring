package com.mycom.basic.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {
	
	public static void main(String[] args) {

		// spring을 이용한 DI
		// 2. DI by annotation
		// 해당 xml 파일을 resources 폴더에서 찾는다.
		// xml 파일로 spring 실행 환경을 만든다 -> context:component-scan 방식
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("calc-annotation.xml");
		
		Calculator cal = (Calculator) context.getBean("abc");
		int n = cal.add(10, 5);
		System.out.println(n);
		
		context.close();
		
	}

}
