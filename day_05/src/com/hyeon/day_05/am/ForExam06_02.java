package com.hyeon.day_05.am;

public class ForExam06_02 {

	public static void main(String[] args) {

		for (int i = 0; i < 4; i += 1) {
			for (int j = 0; j <= i; j += 1) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 5; i > 0; i += -1) {
			for (int j = 0; j < i; j += 1) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
