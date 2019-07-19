package com.hyeon.day_05.am;

import java.util.Scanner;

public class ForExam05_02 {

	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		int sum = 0;
		int j = 10;
		for (int i = 1; i < 100000; i += 2) {
			sum += i; // 홀수
			sum += i + 1; //짝수
		}
	    System.out.println(sum);
	    System.out.println("PG동작 시간 : " + (System.nanoTime() - startTime));
	    
	    long startTime2 = System.nanoTime();
	    int startNum = inputNum();
	    int endNum = inputNum();
	    int mulNum = endNum / 2;
	    int resultSum = (startNum + endNum) * mulNum;
	    System.out.println(resultSum);
	    System.out.println("PG동작 시간 : " + (System.nanoTime() - startTime2));
	    
	    
//		sum = (j*(j+1))/2;
//		System.out.println(sum);
		
	}
	public static int inputNum() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

}
