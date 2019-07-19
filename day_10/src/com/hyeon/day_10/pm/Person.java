package com.hyeon.day_10.pm;

public class Person {
	
	static String name01; //클래스 변수, 클래스로만 불러와야한다.
	String name02; //인스턴스 변수
	
	public static void main(String[] args) {

//		Person p1 = new Person();
//		p1.name02 = "aaa";
//	
//		Person p2 = new Person();
//		Person.name01 = "ccc";
		
		method01("김현중");
		
	}

	public static String method01(String name) {
		System.out.println("method01");
		return name;
	}
	
	public void method01() {
		System.out.println("method02");
	}
	
}
