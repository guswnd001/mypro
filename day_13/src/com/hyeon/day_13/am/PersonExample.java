package com.hyeon.day_13.am;

public class PersonExample {

	public static void main(String[] args) {

		Person p1 = new Person("123456-1234567", "현중");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		p1.nation = "usa";
		p1.ssn = "654321 - 7654321";
		p1.name = "코난";
		
		System.out.println("=================");
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
	}

}

class Person {
	
//	final String nation = "korea";
//	final String ssn;
	String nation = "korea";
	String ssn;
	String name;
	
	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
	
}
