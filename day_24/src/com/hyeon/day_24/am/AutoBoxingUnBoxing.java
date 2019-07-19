package com.hyeon.day_24.am;

public class AutoBoxingUnBoxing {

	public static void main(String[] args) {
		
		//자동 Boxing
		Integer obj = 100; //Integer는 래퍼이기때문에 값을 포장한 것 
		System.out.println("value: " + obj.intValue());
		
		//대입시 자동 Boxing
		int value = obj;
		System.out.println("value: " + value);
		
		//연산시 자동 UnBoxing
		int result = obj + 100;
		System.out.println("result: " + result);
		
	}

}
