package com.mycom.basic.aspect;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycom.basic.aspect.sub.BusinessProcessSub;

public class AspectMain {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aspect.xml");
		
		BusinessProcess bp = (BusinessProcess) context.getBean("businessProcess");	// DI
		// BusinessProcess2 bp2 = (BusinessProcess2) context.getBean("businessProcess2");	// DI
		
		bp.bp();
		System.out.println("-----------------------------------");
		bp.void_bp();
		System.out.println("-----------------------------------");
		bp.int_bp();
		System.out.println("-----------------------------------");
		bp.String_int_String_bp("dd", 10, "hh");
		System.out.println("-----------------------------------");
		
		//bp2.bp();
		//System.out.println("-----------------------------------");
		
		
		BusinessProcessSub bps = (BusinessProcessSub) context.getBean("businessProcessSub");	// DI
		bps.m1();
		
		context.close();
	}

}
