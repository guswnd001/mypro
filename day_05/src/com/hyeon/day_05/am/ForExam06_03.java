package com.hyeon.day_05.am;

public class ForExam06_03 {

	public static void main(String[] args) {

		outNum(9);
		
	}
	
	public static void outNum(int num) {
		
		for (int i = 0; i < num; i += 1) {
			//for (int j = 4-i; j > 0; j -=1) {
			int num2 = num - (i+1);
			for (int j = 0; j < num2; j += 1) {
				System.out.print(" ");
			}
			for (int k = 0; k < i*2+1 ; k += 1) {
				System.out.print("*");		
			}
			System.out.println();		
			
		}
	
	}
}
