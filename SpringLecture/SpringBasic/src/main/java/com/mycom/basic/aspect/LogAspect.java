package com.mycom.basic.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// aspect는 spring이 가져다 쓸 수 있도록 component화
@Component
@Aspect
public class LogAspect {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut(value = "execution(* com.mycom.basic.aspect.*.*(..))")
	private void logPointCut() {}

	// Advise: pointcut이 적용되는 시점
	@Before("logPointCut()")
	public void beforeLog(JoinPoint joinPoint) { 			// joinPoint: 비즈니스 로직에 존재하는 모든 method()
		Signature signature = joinPoint.getSignature();		// 비즈니스 로직에서 호출된 method()를 가져온다.
		
		// Log Aspect가 할 일( logging )
		System.out.println("Before: " + signature.getName());
		logger.debug("[Logger : Before : " + signature.getName());
		logger.warn("[Logger : After : " + signature.getName());
	}

	@After("logPointCut()")
	public void afterLog(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		
		// Log Aspect가 할 일( logging )
		System.out.println("After: " + signature.getName());
		logger.info("[Logger : After : " + signature.getName());
		
	}

}
