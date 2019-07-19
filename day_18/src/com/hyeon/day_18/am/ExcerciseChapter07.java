package com.hyeon.day_18.am;

class Parent {
	public String name;
	
	public Parent(String name) {
		this.name = name;
	}
}

class Child extends Parent {
	private int studentNo;
	
	public Child(String name, int studentNo) {
		super(name);
		this.studentNo = studentNo;
	}
}


public class ExcerciseChapter07 {
	
	static final int MAB = 10;
	
	public static void main(String[] args) {
		
		/*
		 * 문제 1 : 1
		 * 문제 2 : 2
		 * 문제 3 : 4
		 * 문제 4 : 2
		 * 문제 5 : 자식클래스에서 부모 생성자를 부르지 않았기 때문에
		 * 문제 6 :
		 * 	Parent(String nation) call
			Parent() call
			Child(String name) call
			Child() call
			
		 * 문제 7 : 
		  	스노우 타이어가 굴러갑니다.
		  	일반 타이러가 굴러갑니다.
		 * 문제 8 : 2 
		 */
		
		
		
	}

}
