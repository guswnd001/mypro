package com.hyeon.day_19.pm;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		System.out.println("폭탄의 좌표를 입력해주세요.");
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt() + 1;
		while (row <= 0 || row > 10) {
			System.out.println("다시 입력해주세요");
			row = sc.nextInt() + 1; 
		}
		
		int col = sc.nextInt() + 1;
		while (col <= 0 || col > 10) {
			System.out.println("다시 입력해주세요");
			col = sc.nextInt() + 1; 
		}
		System.out.println(row + col);
	}

}
