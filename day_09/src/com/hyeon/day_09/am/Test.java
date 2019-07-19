package com.hyeon.day_09.am;

public class Test {
	public static void main(String[] args) {
		int n = 10000;
		int cnt = 0;
		int cntNum = 0;
		
		for(int i = 2; i <= n; i++) {
			for (int j = 2; j <= i; j++) {
				if (i%j == 0) {
					cnt++;
				}
			}
			if (cnt == 1) {
				System.out.println(i);
				cntNum++;
			}
			cnt = 0;
			
		}
		System.out.println("============");
		System.out.println(cntNum);
		
	}
		
}
