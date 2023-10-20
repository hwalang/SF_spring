package com.mycom.basic.aspect;

import org.springframework.stereotype.Component;

@Component
public class BusinessProcess {

	public void bp()
	{
		System.out.println("BusinessProcess bp() 호출");
	}
	
	public void void_bp()
	{
		System.out.println("BusinessProcess void_bp() 호출");
	}
	
	public int int_bp()
	{
		System.out.println("BusinessProcess int_bp() 호출");
		return 0;
	}
	
	public int String_int_String_bp(String s1, int i, String s2)
	{
		System.out.println("BusinessProcess String_int_String_bp() 호출");
		return 0;
	}
	
}
