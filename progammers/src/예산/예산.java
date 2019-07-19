package 예산;

import java.util.Arrays;

public class 예산 {
	
	public static void main(String[] args) {
		
//		int[] d = { 1, 3, 2, 5, 4 };
		int[] d = { 5, 4, 1, 3, 2 };
		int budget = 9;
		int answer = 0;
		int dSum = 0;
		
		Arrays.sort(d);
		
		for (int i = 0; i < d.length; i++) {
			dSum += d[i];
			if (dSum > budget) {
				answer = i;
				break;
			}
		}
		
		if (dSum <= budget) {
			answer = d.length;
		}
		
//		for (int i = 0; i < d.length; i++) {
//			budget -= d[i];
//			
//			if (budget < 0) { break; }
//			
//			answer++;
//		}
		
		System.out.println(answer);
		
	}
	
}
