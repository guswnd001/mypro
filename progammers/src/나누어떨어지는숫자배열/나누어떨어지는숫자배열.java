package 나누어떨어지는숫자배열;

import java.util.Arrays;

public class 나누어떨어지는숫자배열 {
	
	public static void main(String[] args) {
		
//		int[] arr = { 5, 9, 7, 10 };
//		int[] arr = { 2, 36, 1, 3 };
		int[] arr = { 2, 6, 3 };
		int divisor = 10;
		int[] answer = {};
		int cnt = 0;
		String s = "";
		
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] % divisor) == 0) {
				cnt++;
				s += arr[i] + ",";
			}
		}
		
		if (cnt == 0) {
			answer = new int[1];
			answer[0] = -1;
		} else {
			answer = new int[cnt];
			for (int i = 0; i < cnt; i++) {
				answer[i] = Integer.parseInt(s.split(",")[i]);
			}
			Arrays.sort(answer);
		}
		
		
		for (int i : answer) {
			System.out.print(i + ", ");
		}
		
		
		
	}
	
}
