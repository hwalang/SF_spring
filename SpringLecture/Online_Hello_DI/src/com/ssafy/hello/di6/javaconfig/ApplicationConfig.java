package com.ssafy.hello.di6.javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // class가 xml 역할임을 알려준다. 
@ComponentScan(basePackages = {"com.ssafy.hello.di6"})
public class ApplicationConfig {
	
}
