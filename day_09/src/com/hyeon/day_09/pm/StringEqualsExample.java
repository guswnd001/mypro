package com.hyeon.day_09.pm;

public class StringEqualsExample {

	public static void main(String[] args) {

		String strVar1 = "김현중";
		String strVar2 = "김현중";
		String strVar3 = new String("김현중");
		
		System.out.println(strVar3 == "김현중");
		System.out.println(strVar1 == strVar3);
		System.out.println();
		System.out.println(strVar1.equals(strVar2)); //참조형 비교할때 equals!!!
		System.out.println(strVar1.equals(strVar3));
		
	}

}
