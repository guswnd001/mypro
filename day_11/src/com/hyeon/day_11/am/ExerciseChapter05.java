package com.hyeon.day_11.am;

import java.util.Scanner;

import javax.swing.plaf.SliderUI;

public class ExerciseChapter05 {

	public static void main(String[] args) {
		
		//문제 1.
		System.out.println("======문제 1.======");
		System.out.println("답 : (4)");
		
		//문제 2.
		System.out.println("\n======문제 2.======");
		System.out.println("답 : (3)");
		
		//문제 3.
		System.out.println("\n======문제 3.======");
		System.out.println("답 : (2)");

		//문제 4.
		System.out.println("\n======문제 4.======");
		System.out.println("답 : (2)");

		//문제 5.
		System.out.println("\n======문제 5.======");
		System.out.println("답 : (3)");
		
		//문제 6.
		System.out.println("\n======문제 6.======");
		int[][] array1 = { {95, 86},
						   {83, 92, 96},
						   {78, 83, 93, 87, 88} };
		System.out.println("array.length의 값 : " + array1.length);
		System.out.println("array[2].length : " + array1[2].length);
		
		//문제 7.
		System.out.println("\n======문제 7.======");
		int max = 0;
		int[] array2 = {1, 5, 3, 8, 2};
		for (int i = 0; i < array2.length; i+=1) {
			if (max < array2[i]) max = array2[i];
		}
		System.out.println("MAX : " + max);
		
		//문제 8.
		System.out.println("\n======문제 8.======");
		int[][] array3 = { {95, 86},
						   {83, 92, 96},
						   {78, 83, 93, 87, 88} };
		int sum = 0;
		double avg = 0.0;
		
		for (int i = 0; i < array3.length; i+=1) {
			for (int j = 0; j < array3[i].length; j+=1) {
				sum += array3[i][j];
				avg++;
			}
		}
		avg = sum/avg; 
		
		System.out.println("SUM : " + sum);
		System.out.println("AVG : " + avg);
		
		//문제 9.
		System.out.println("\n======문제 9.======");
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);
		
		while (run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-------------------------------------------");
			System.out.print("선택 > ");
			
			int selectNo = scanner.nextInt();
			
			if (selectNo == 1) {
				System.out.print("학생수 > ");
				studentNum = scanner.nextInt();
				scores = new int[studentNum];
			} else if (selectNo == 2) {
				for (int i = 0; i < scores.length; i++) {
					System.out.print("scores[" + i + "] > ");
					scores[i] = scanner.nextInt();
				}
			} else if (selectNo == 3) {
				for (int i = 0; i < scores.length; i++) {
					System.out.print("scores[" + i + "] > " + scores[i]);
					System.out.println();
				}
			} else if (selectNo == 4) {
				int sumScore = 0;
				int maxScore = 0;
				for (int i = 0; i < scores.length; i++) {
					if (maxScore < scores[i]) maxScore = scores[i];
					sumScore += scores[i];
				}
				System.out.println("최고 점수 : " + maxScore);
				System.out.println("표준 점수 : " + sumScore/scores.length);
			} else if (selectNo ==5) {
				run = false;
			}
		}
		
		System.out.println("프로그램 종료");
		
		
		
		
		
		
	}

}
















