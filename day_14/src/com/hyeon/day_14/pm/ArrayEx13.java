package com.hyeon.day_14.pm;

public class ArrayEx13 {

	
	public static void main(String[] args) {
		int[][] score = { {100, 80, 90}, {80, 80, 70}, 
						  {80, 75, 90}, {90, 75, 95},
						  {100, 60, 75} };
		int[] total = new int[3]; 
		
		for (int i = 0; i < score.length; i++) {
			System.out.print((i + 1) + "번 학생 : ");
			int sum = 0;
			for (int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + "\t");
				sum += score[i][j];
				total[j] += score[i][j];
			}
			System.out.println("합계 : " + sum + "  평균 : " + sum/score[i].length);
		}
		System.out.print("\t");
		for (int t : total) {
			System.out.print(t + "\t");
		}
		System.out.println("\t");
	}
}
