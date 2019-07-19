package com.hyeon.day_05.am;

import java.util.Scanner;

public class ForExam05 {

	public static void main(String[] args) {
		
		int sum = 0;
		int j = calSum();
		for (int i = 1; i < j+1; i += 2) {
			sum += i; // 홀수
			sum += i + 1; //짝수
		}
	    System.out.println(sum);
	    
	    int startNum = 1;
	    int endNum = 10;
	    int mulNum = endNum / 2;
	    int resultSum = (startNum + endNum) * mulNum;
	    System.out.println(resultSum);
	    
	    
	    
//		sum = (j*(j+1))/2;
//		System.out.println(sum);
		
	}
	public static int calSum() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

}
