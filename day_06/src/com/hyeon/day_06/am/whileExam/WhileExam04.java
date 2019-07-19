package com.hyeon.day_06.am.whileExam;

import java.util.Scanner;

public class WhileExam04 {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		int jumsu;
		String msg = "";
		
		do {
			System.out.println(msg + "국어 점수를 입력해주 [0~100]");
			jumsu = scan.nextInt();
			msg = "다시 ";
			
		} while (jumsu < 0 || jumsu > 100);
		
//		while ((jumsu = scan.nextInt()) < 0 || jumsu > 100) {
//			System.out.println("입력이 적절하지 않아, 다시 입력해주");			
//		}
		
		System.out.println("너의 국어 점수는 " + jumsu + "야");
		scan.close();
		
	}
}
