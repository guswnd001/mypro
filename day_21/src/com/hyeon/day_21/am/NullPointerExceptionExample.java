package com.hyeon.day_21.am;

public class NullPointerExceptionExample {

	public static void main(String[] args) {
		
		String data = null;
		try {
			System.out.println(data.toString());
		} catch (Exception e) {
			System.out.println("null 입니다");
		}
		
	}

}
