package com.hyeon.day_14.pm;

import java.util.Scanner;

public class Array09 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("8진수로 변환할 수를 입력하세요");
		int num = scan.nextInt();
		int[] octArr = new int[10];
		boolean run = true;
		int i = 0;
		
		while (run) {
			
			if(num != 0) {
				octArr[i] = num % 8;
				num = num/8;
				i++;
			} else {
				run = false;
			}
			
		}
		for (int j = octArr.length-1; j > -1; j--) {
			if (octArr[j] != 0) {
				System.out.print(octArr[j]);
			}
		}
		
	}

}
