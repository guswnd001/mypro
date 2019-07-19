package com.hyeon.day_17.am;

import java.util.Arrays;
import java.util.Scanner;


public class BigNum승주 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("몇 번 입력할 지 쓰시오 :");
		Scanner keyIn = new Scanner(System.in);
		int num = keyIn.nextInt();

		int arr[] = new int[num];
		int number = 0;
		for(int i=0; i<arr.length; i++) {
			number = (int)(Math.random()*99)+1;
			//number = keyIn.nextInt();
			if(number > 100 || number <0) {
				//다시 입력
				number = keyIn.nextInt();
			}
			arr[i] = number;
		}

		for(int i=0; i<arr.length; i++) {
			for(int j= 0; j<arr.length-1; j++) {
				int first=0; int second = 0;

				if(arr[j]<10) {      first = arr[j]; }
				else {
					first= arr[j]/10;
				}

				if(arr[j+1]<10) {      second = arr[j+1]; }
				else {
					second= arr[j+1]/10;
				}

				if (arr[j]>=10 && arr[j+1]>=10&&first==second) {

					first=arr[j]%10;
					second=arr[j+1]%10;
				}

				if(arr[j]<10 || arr[j+1]>10 || first == second){
					String hap = first+""+second;
				}

				if (first<second) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}

		System.out.println("큰 수부터 출력 :");
		for(int i=0; i< arr.length; i++) {
			System.out.println(arr[i] + " ");
		}


		Solution change  = new Solution();
		change.solution(arr);
	}
}

class Solution {
	public String solution(int[] numbers) {

		String answer = Arrays.toString(numbers).replaceAll("[^0-9]","");
		System.out.println( answer );

		return answer;
	}

}


