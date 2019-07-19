package com.hyeon.day_04.am;

import java.util.Scanner;

public class IfTest0301 {

	public static void main(String[] args) {
		//세 수를 입력 받아서 큰 수를 출력하는 프로그램을 작성하시오.
		//세 수 입력받기
		//큰 수를 판단해서 오름차순 결과로 저장
		//저장된 결과를 출력
		
		int firNum, secNum, thiNum;
		int num1 = inData();
		int num2 = inData();
		int num3 = inData();
		
		if (num1 > num2) { //조건1 == true
			if (num1 > num3) {
				firNum = num1;
				if (num2 > num3) {
					secNum = num2;
					thiNum = num3;
				} else {
					secNum = num3;
					thiNum = num2;
				}
			} else {
				firNum = num3;
				secNum = num1;
				thiNum = num2;
			}
		} else { //조건1 != true
			if (num2 > num3) {
				firNum = num2;
				if (num1 > num3) {
					secNum = num1;
					thiNum = num3;
				} else {
					secNum = num3;
					thiNum = num1;
				}
			} else {
				firNum = num3;
				secNum = num2;
				thiNum = num1;
			}
			
		}
		
		
		System.out.println("세 수를 큰 수대로 나열하면 " + firNum + ", " + secNum + ", " + thiNum + "입니다.");
		
	}
	
	public static int inData(){
		Scanner sc = new Scanner(System.in);
		return sc.nextInt(); //0 대신에 입력받은 값을 반환
	}
	
	
}
