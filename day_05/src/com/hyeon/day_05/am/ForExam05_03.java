package com.hyeon.day_05.am;

import java.util.Scanner;

public class ForExam05_03 {

	public static void main(String[] args) {
		
//		 long startTime2 = System.nanoTime();
//		 int startNum = inputNum();
//		 int endNum = inputNum();
//		 int mulNum = endNum / 2;
//		 int resultSum = (startNum + endNum) * mulNum;
//		 System.out.println(resultSum);
//		 System.out.println("PG동작 시간 : " + (System.nanoTime() - startTime2));
		
		int stNum = inputNum("시작");
		int edNum = inputNum("끝");
		int gap = inputNum("더할");
		
		long sum = sumNum(stNum, edNum, gap);
		System.out.println("결과는 : " + sum);
		
	}
	
	public static int inputNum(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println(message + "수를 입력해주세요.");
		return sc.nextInt();
	}
	
	public static long sumNum(int a, int b, int c) {
		long sum = 0;
		for (int i = a; i < b+1; i += c) {
			sum += i;
		}
		return sum;
	}

}
