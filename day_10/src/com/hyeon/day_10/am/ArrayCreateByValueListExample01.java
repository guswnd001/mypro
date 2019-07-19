package com.hyeon.day_10.am;

public class ArrayCreateByValueListExample01 {

	public static void main(String[] args) {
		
		int[] scores = {83, 90, 87}; //배열은 참조형변수이다.
		//배열은 선언시 사이즈와 타입이 정해진다. 추후 변경불가.
		
		System.out.println("scores[0] = " + scores[0]);
		System.out.println("scores[1] = " + scores[1]);
		System.out.println("scores[2] = " + scores[2]);
		
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += scores[i];
		}
		System.out.println("점수의 총합 = " + sum);
		int avg = sum/3;
		System.out.println("점수의 평균 = " + avg);
		
	}

}
