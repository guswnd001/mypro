package com.hyeon.day_04.am;

import java.util.Scanner;

public class IfTest01Up {

		   int k = 10; // static의 유무의 차이
	static double dataNum = 3;

	public static void main(String[] args) {
		
		int juminSecondGenNum = genNum() % 2;
		String gender = "여성";
//		int genValue = juminSecondGenNum % 2; 
		// if문의 조건식에서 메서드를 호출하여 반환되는 결과값에 따라서 처리할 수 있다.
		if (isGender(juminSecondGenNum)) { 
//		if (juminSecondGenNum != 0) {
			gender = "남성";
		}
		System.out.println(gender);	
		System.out.println("수고용");
		
	}

	public static int genNum() {
		System.out.println("주민번호 뒷자리의 첫번째 숫자를 입력해주세요");
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.next());
		return num;
	}
	
	public static boolean isGender(int a){ 
		//남성일 경우 true, 여성일 경우 false
		return (a > 1)? true:false;
	}

}
