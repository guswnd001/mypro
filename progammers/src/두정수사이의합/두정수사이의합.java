package 두정수사이의합;

import java.util.Arrays;

public class 두정수사이의합 {

	public static void main(String[] args) {

		long answer = 0;

		int a = 3;
		int b = 5;
		
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		
		if (a == b) {
				answer += a;
		} else {
//			while (min <= max) {
//				answer += min;
//				min++;
//			}
			for (int i = min; i <= max; i++) {
				answer += i;
			}
		}
		
		System.out.println(answer);

	}

}

class Solution {

	public long solution(int a, int b) {

		long answer = 0;

		return answer;

	}

}