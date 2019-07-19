package com.hyeon.day_21.am;

public class FactorialTest {

	public static void main(String[] args) {
		
		System.out.println(factorial(4));
		
	}

	static long factorial(int n) {
		long result = 0;
		
		if (n == 1) {
			System.out.println("n : " + n);
			return 1;
		}
		System.out.println("n : " + n);
		return n * factorial(n-1);
		
	}
}

