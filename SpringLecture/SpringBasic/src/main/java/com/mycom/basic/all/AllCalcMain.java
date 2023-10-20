package com.mycom.basic.all;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AllCalcMain {
	
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("all-calc-annotation.xml");
		
		AllCalculator useCalc = (AllCalculator) context.getBean("allCalculator");
		int n = useCalc.add(10, 5);
		System.out.println(n);
		
		context.close();
		
	}

}
