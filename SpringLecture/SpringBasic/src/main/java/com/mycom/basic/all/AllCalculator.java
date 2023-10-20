package com.mycom.basic.all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AllCalculator  {
	
	@Autowired
	@Qualifier("aaa")
	Calculator calculator;		// interface
								// DI Calculator interface를 implement한 객체

	public int add(int n1, int n2)
	{
		return calculator.add(n1, n2);
	}
	
}
