package com.hyeon.day_26.am;

public class Animal {
	String name = "사람";
	int age = 1;
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Animal(String name) {
		this.name = name;
	}
	public Animal(int age) {
		this.age = age;
	}
	
	public void eat() {
		System.out.println("맛있게 냠냠쩝쩝");
	}
	
	public void show() {
		System.out.println(name + "는(은) " + age + "살입니다.");
	}
}
