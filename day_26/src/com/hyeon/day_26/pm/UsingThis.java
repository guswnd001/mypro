package com.hyeon.day_26.pm;

public class UsingThis {
	public int outterField = 10;
	
	class Inner {
		int innerField = 20;
		void method() {
			//람다식
			MyFunctionalInterface2 fi2 = () -> {
				System.out.println("outterField: " + outterField);
				System.out.println("outterField: " + UsingThis.this.outterField + "\n");
				System.out.println("innerField: " + innerField);
				System.out.println("innerField: " + this.innerField + "\n");
			};
			fi2.method();
		}
	}
}

interface MyFunctionalInterface2 {
	public void method();
}