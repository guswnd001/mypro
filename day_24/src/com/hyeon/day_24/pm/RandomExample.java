package com.hyeon.day_24.pm;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		
		//선택번호
		int[] selectNumber = new int[6]; //선택번호 6개가 저장될 배열 생성
		Random random = new Random(3);
		System.out.print("선택 번호: ");
		for (int i = 0; i < 6; i++) {
			selectNumber[i] = random.nextInt(45) + 1;
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();
		
		//당첨번호
		int[] winningNumber = new int[6];
		random = new Random(5); 
		System.out.print("당첨 번호: ");
		for (int i = 0; i < 6; i++) {
			winningNumber[i] = random.nextInt(45) + 1;
			System.out.print(winningNumber[i] + " ");
		}
		System.out.println();
		
		//당첨여부
		Arrays.sort(selectNumber); //비교하기전에 정렬시킴
		Arrays.sort(winningNumber); //비교하기전에 정렬시킴
		boolean result = Arrays.equals(selectNumber, winningNumber);
		System.out.print("당첨여부: ");
		if (result) {
			System.out.println("1등 당첨!");
		} else {
			System.out.println("다음 기회에");
		}
		
	}

}
