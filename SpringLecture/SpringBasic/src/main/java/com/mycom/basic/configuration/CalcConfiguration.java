package com.mycom.basic.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// spring이 설정을 이해할 수 있는 자바 클래스를 의미
@Configuration
public class CalcConfiguration {

	// DI
	@Bean
	public Calculator calculator()
	{
		return new Calculator();
	}
	
}
