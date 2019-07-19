package com.hyeon.day_11.pm;

public class Korean {
	//필드
	String nation = "대한민국";
	String name;
	String ssn;
	int age;
	
	public Korean(String n, int age) {
		name = n;
		age = age;
	}
	
	public Korean(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}
	
}


