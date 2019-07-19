package com.hyeon.day_21.pm;

public class FinallyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//method();
		System.out.println(method());
	}
	
	static int method() {
		try {
			System.out.println("aaa");
			if (false) return 0;
		} finally {
			System.out.println("Finally");
		}
		System.out.println("end");
		return 1;
	}
	
}
