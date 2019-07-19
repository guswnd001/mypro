package com.hyeon.day_15.am;

public class ArrayEx21 {

	public static void main(String[] args) {
		
		int[][] arr = new int[10][];
		for (int row = 0; row < arr.length; row++) {  
			arr[row] = new int[row + 1];
		}
		
		int data = 0;
//		for (int row = 0; row < arr.length; row++) {
//			for (int col = 0; col < arr[row].length; col++) {
//				arr[row][col] = (++data);
//			}
//		}
		
		for (int col = arr.length-1; col > -1; col--) {
			for (int row = col; row < arr.length; row++) {
				arr[row][col] = (++data);
			}
		}
		
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				System.out.printf("%5d", arr[row][col]);
			}
			System.out.println();
		}
		
	}

}
