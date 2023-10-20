package com.mycom.basic.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {
	
	public static void main(String[] args) {
		
		// 기존에 하던 방식으로 객체를 생성
		Calculator calculator = new Calculator();
		int n = calculator.add(7, 3);
		System.out.println(n);
		
		// spring을 이용한 DI
		// 1. DI by xml
		// 해당 xml 파일을 resources 폴더에서 찾는다.
		// xml 파일로 spring 실행 환경을 만든다.<bean> tag를 이용해서 DI를 처리
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("calc-xml.xml");
		Calculator cal = context.getBean(Calculator.class);
		int n2 = cal.add(10, 5);
		System.out.println(n2);
		context.close();
		
		// XML에서 id를 이용해서 객체 생성
		ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("calc-xml.xml");
		Calculator cal2 = (Calculator) context2.getBean("calculator");
		System.out.println(cal2.add(10, 20));
		
	}

}
