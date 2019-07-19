package com.hyeon.day_14.pm;

public class ArrayEx05 {

	public static void main(String[] args) {
		
		int[] balls = new int[45];
		for (int i = 0; i < balls.length; i++) {
			balls[i] = i + 1;
		}
		
		for (int i = 0; i < 1000; i++) {
			int f = (int)(Math.random() * 45);
			int g = (int)(Math.random() * 45);
			int tmp = balls[f];
			balls[f] = balls[g];
			balls[g] = tmp;
		}
		
		int[] lotto = new int[6];
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = balls[i];
		}
		for (int i : lotto) {
			System.out.print(i + ", ");
		}
		System.out.println();
		
	}

}
