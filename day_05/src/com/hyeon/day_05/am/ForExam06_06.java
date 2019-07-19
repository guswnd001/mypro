package com.hyeon.day_05.am;

public class ForExam06_06 {

	public static void main(String[] args) {
		
		outputNum();
		
	}
	
	public static void outputNum() {
		
		for(int i = 0; i < 7; i += 1) {
			for (int j = 0; j < i+1; j += 1) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}	
	
}
