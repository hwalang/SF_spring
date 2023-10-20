package com.mycom.basic.aspect;

import org.springframework.stereotype.Component;

@Component
public class BusinessProcess2 {

	public void bp()
	{
		System.out.println("BusinessProcess2 bp() 호출");
	}
	
	public void void_bp()
	{
		System.out.println("BusinessProcess2 void_bp() 호출");
	}
	
	public int int_bp()
	{
		System.out.println("BusinessProcess2 int_bp() 호출");
		return 0;
	}
	
	public int String_int_String_bp(String s1, int i, String s2)
	{
		System.out.println("BusinessProcess2 String_int_String_bp() 호출");
		return 0;
	}
	
}
