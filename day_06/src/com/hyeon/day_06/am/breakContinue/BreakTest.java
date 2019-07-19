package com.hyeon.day_06.am.breakContinue;

public class BreakTest {

	public static void main(String[] args) {
		
		hyeonjoong:
		for (int i = 1; i <= 20; i+=1) {
			for (int j = 3; j <= 20; j+=3) {
				if (i == j) {
					System.out.println(i);
				}
				
			}
//			System.out.println("i = " + i);
//			System.out.println("==============");
		}
		
	}

	public static void callMessage() {
		System.out.println("박수 짝");
		//System.exit(0);
	}

}
