package com.hyeon.day_15.am;

public class SearchSingleNo {

	public static void main(String[] args) {
		
		int[] arr = {1, 6, 3, 5, 8, 7, 6, 8, 7, 3, 5};
		int singleNo = 0; //짝이 없는 수가 들어갈 변수
		int cnt; //짝이 맞는지 셀 변수
		
		for (int i = 0; i < arr.length; i++) {
			cnt = 0;
			for (int j = 0; j < arr.length; j++) { 
				if (arr[i] == arr[j]) {
					cnt++;
				}
			}
			if(cnt == 1) { //짝이 안맞는 수를 찾음
				singleNo = arr[i];
				System.out.println(singleNo);
			}
		}
		
	}

}
