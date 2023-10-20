package com.mycom.basic.has_a;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseCalcMain {
	
	public static void main(String[] args) {

		// spring을 이용한 DI
		// 2. DI by annotation
		// 해당 xml 파일을 resources 폴더에서 찾는다.
		// xml 파일로 spring 실행 환경을 만든다 -> context:component-scan 방식
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("use-calc-annotation.xml");
		
		UseCalculator useCalc = (UseCalculator) context.getBean("useCalculator");
		int n = useCalc.add(10, 5);
		System.out.println(n);
		
		context.close();
		
	}

}
