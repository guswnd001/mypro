package com.hyeon.day_04.am;

import java.util.Scanner;

public class IfTest0300 {

	public static void main(String[] args) {
		//두 수를 입력 받아서 큰 수를 출력하는 프로그램을 작성하시오.
		//두 수 입력받기
		//큰 수를 판단해서 결과로 저장
		//저장된 결과를 출력
		
		int i = inData();
		int j = inData();
		bigNum(i, j);
		//System.out.println(i + ", " + j + "중 큰수는 " + result);
		
	}
	
	public static int inData(){
		Scanner sc = new Scanner(System.in); 
		return sc.nextInt(); //0 대신에 입력받은 값을 반환
	}
	
	public static void bigNum(int a, int b){
		
		if (a > b) { System.out.println(a + ", " + b + "중 큰수는 " + a); } 
		else if(a < b) { System.out.println(a + ", " + b + "중 큰수는 " + b); } 
		else { System.out.println("두 수는 같다."); }
		return;
	}
	
}
