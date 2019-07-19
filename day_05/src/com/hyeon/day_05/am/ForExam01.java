package com.hyeon.day_05.am;

public class ForExam01 {

	public static void main(String[] args) {
		
		String myName = "김현중";
		
		dataPrint(myName);
		dataPrint(myName);
		dataPrint(myName);
		dataPrint("김희중");
		dataPrint(myName);
		
		double a = 0;
		for (int i = 1; i < 11; i++) {
			a += 1.0/i;
		}
		System.out.println(a);

		int b = 0;
		int c = 1;
		for (int i = 1; i < 11; i++) {
			//b += c*i;
			System.out.println(c*i);
			c = c*(-1);
		}
		//System.out.println(b);
		
		for (int i = 0, j = 100; i <= 50 && j >= 50; i++, j--) {
			System.out.println(i + ", " + j);
		}
		
	}
	public static void dataPrint(String n) {
		System.out.println(n);
	}
	

}
