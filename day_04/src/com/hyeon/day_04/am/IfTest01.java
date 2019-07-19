package com.hyeon.day_04.am;

import java.util.Scanner;

public class IfTest01 {

		   int k = 10; // static의 유무의 차이
	static double dataNum = 3;

	public static void main(String[] args) {
		
		int juminSecondGenNum = genNum() % 2;
//		int genValue = juminSecondGenNum % 2; 

		if (juminSecondGenNum == 1) {
			System.out.println("남자");	
		} else {
			System.out.println("여자");
		}
		System.out.println("수고용");
		
	}

	public static int genNum() {
		System.out.println("주민번호 뒷자리의 첫번째 숫자를 입력해주세요");
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.next());
		return num;
	}

}
