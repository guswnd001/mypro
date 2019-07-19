package com.hyeon.day_17.pm;

public class BindingTest {

	public static void main(String[] args) {
		
		Parent p = new Child();
		Child c = new Child();
		System.out.println("p.x = " + p.x);
		p.method(); //부모의 메소드가 자식의 메소드로 오버라이딩 됨
		System.out.println("c.x = " + c.x);
		c.method();
		
	}

}

class Parent {
	int x = 100;
	void method() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent {
	//int x = 200;
	void method() {
		System.out.println("Child Method");
	}
}