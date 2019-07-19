package com.hyeon.day_05.am;

import java.util.Scanner;

public class ForExam06_05 {

	public static void main(String[] args) {
		
		int dataNum = inputNum("시작할 수를 입력해주세요.");
		outputNum(dataNum);
		
	}
	
	public static void outputNum(int num) {
		
		System.out.println("");
		
		int inum = 0;
		
		for (int i = 0; i < num-1; i += 1) {
			for (int j = 0; j <= i; j += 1) {
				inum += 1;
				System.out.print(inum + " ");
			}
			System.out.println();
		}
		for (int i = num; i > 0; i += -1) {
			for (int j = 0; j < i; j += 1) {
				inum += 1;
				System.out.print(inum + " ");
			}
			System.out.println();
		}
		
	}
	
	public static int inputNum(String message) {
		System.out.println(message);
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
		
	}
	
	
}
