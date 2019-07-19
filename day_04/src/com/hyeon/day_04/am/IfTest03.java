package com.hyeon.day_04.am;

import java.util.Scanner;

public class IfTest03 {

	public static void main(String[] args) {
		
		//int alpaToNum = (int)alpa;
		//final int baseChar = 'F'; //조건식에 들어가기 위해서는 값이 바뀌면 안되기에 상수변수로 final을 붙여준다.
		
		int alpa = getAlp();
		int baseAlpa = alpa - 65; //대문자 A를 빼서 기준 0을 만든다.
		
		if (alpa >= 'a') { //소문자일 경우는 추가로 32를 빼서 기준인 0으로 맞춘다. 
			baseAlpa = baseAlpa - 32;
		}
		
		String message = "잘 못 선택";
//		switch (baseAlpa) {
//			case baseChar+0: 
//			case baseChar+1: 
//			case baseChar+2: 
//			case baseChar+3: 
//			case baseChar+4:
//			case 0: 
//			case 1: 
//			case 2: 
//			case 3: 
//			case 4: message = "제대로 선택"; break;
//		}
		
		if (baseAlpa >= 0 && baseAlpa <5) {
			message = "제대로 선택";
		}
		
		System.out.println(message);
		
	}

	public static char getAlp(){
		Scanner sc = new Scanner(System.in);
		return sc.nextLine().charAt(0);
	}	
}

