package com.hyeon.day_17.am;

class Parent {
	int x = 10;
}

class Child1 extends Parent {
	int x = 20;
	void method() {
		int x = 30;
		System.out.println(x); //메소드 안에 있는 x
		System.out.println(this.x); //Child1(자식)클래스 에 있는 x
		System.out.println(super.x); //Parent(부모)클래스에 있는 x
	}
}

public class SuperEx01 {

	public static void main(String[] args) {
		Child1 c = new Child1();
		c.method();
	}

}
