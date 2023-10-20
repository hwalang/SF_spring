package com.mycom.basic.has_a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UseCalculator {

	
	// has-a 관계에 있는 Calculator( Bean 객체 )가 null인 경우 -> @Autowired를 Constructor에 붙인다. 
	Calculator calculator;
	
	//@Autowired
	public UseCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	public int add(int n1, int n2) {
		return calculator.add(n1, n2);
	}
	
}
