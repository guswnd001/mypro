package 제일작은수제거하기;

import java.util.Arrays;

public class 제일작은수제거하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		if (arr.length == 1) {
//			answer = new int[] { -1 };
//		}
//
//		answer = new int[arr.length - 1];
//		for (int i = 0; i < arr.length - 1; i++) {
//			answer[i] = (arr[i] >= arr[i + 1]) ? arr[i] : arr[i + 1];
//		}

//		int length = arr.length - 1;
//		if (length >= 1) {
//			answer = new int[length];
//			for (int i = 0; i < length; i++) {
//				answer[i] = (arr[i] >= arr[i + 1]) ? arr[i] : arr[i + 1];
//			}
//		}
//
//		for (int a : answer) {
//			System.out.print(a + ",");
//		}
		int[] arr = { 4,3,2,1 };
		int[] answer = {};

//	    if (arr.length == 1) {
//	        answer = new int[]{-1};
//	    } else {
//	    	answer = new int[arr.length - 1];
//	    	int min = Integer.MAX_VALUE;
//	    	int index = 0;
//	    	
//	    	for (int i = 0; i < arr.length; i++) {
//	    		if (arr[i] < min) {
//	    			min = arr[i];
//	    			index = i;
//	    		}
//	    	}
//	    	
//	    	for (int i = 0, j = 0; i < answer.length; i++, j++) {
//	    		if (index == i) j++;
//	    		answer[i] = arr[j];
//	    	}
//		}
		if (arr.length == 1) {
			answer = new int[] { -1 };
		} else {
			answer = new int[arr.length - 1];
			int min = Integer.MAX_VALUE;
			int index = 0;

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < min) {
					min = arr[i];
					index = i;
				}
			}

			for (int i = 0, j = 0; i < answer.length; i++, j++) {
				if (index == i)
					j++;
				answer[i] = arr[j];
			}
		}

		for (int a : answer) {
			System.out.print(a + ",");
		}

	}

}
