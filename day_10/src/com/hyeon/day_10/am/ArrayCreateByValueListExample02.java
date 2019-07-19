package com.hyeon.day_10.am;

public class ArrayCreateByValueListExample02 {

	public static void main(String[] args) {
		
		int[] scores;
		scores = new int[] {83, 90, 87}; 
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
