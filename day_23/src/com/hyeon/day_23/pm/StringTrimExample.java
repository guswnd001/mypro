package com.hyeon.day_23.pm;

public class StringTrimExample {

	public static void main(String[] args) {
		
		String tel1 = "	02 222";
		String tel2 = "456	";
		String tel3 = "	3925";
		
		String tel = tel1.trim() + tel2.trim() + tel3.trim();
		System.out.println(tel);
		tel = tel.replace(" ", "");
		System.out.println(tel);
		
		
	}

}
