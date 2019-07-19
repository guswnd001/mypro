package com.hyeon.day_22.am;

public class RingLength {

	public static void main(String[] args) {
		
		int[] a = {5, 4, 0, 3, 1, 6, 2};
		int max = 0;
		int count = 0;
		
		for (int i = 0; i < a.length; i++) {
			int first = a[i];
			if (i != first) {
				count = 2;
			} else {
				count = 1;
			}
			count = rec(a, first, a[first], count);
			if (max < count) {
				max = count;
			}
		}
		System.out.println("max : " + max);
		
		
	}
	
	public static int rec(int[] a, int first, int index, int count) {
		if (first != a[index]) {
			count = rec(a, first, a[index], count);
			count++;
		}
		return count;
	}

}
