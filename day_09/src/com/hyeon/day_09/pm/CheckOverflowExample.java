package com.hyeon.day_09.pm;

public class CheckOverflowExample {

	public static void main(String[] args) {

		try {
			int result = safeAdd(2000000000, 2000000000);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("오버플로우 발생하여서 정확히 계산 불가");
		}
	}

	private static int safeAdd(int left, int right) {
		if (right>0) {
			if(left > (Integer.MAX_VALUE - right)) {
				// left + right > Integer.MAX_VALUE
				throw new ArithmeticException("오버플로우 발생");
			}
		} else {
			if (left < (Integer.MIN_VALUE - right)) {
				// left + right < Integer.MIN_VALUE
				throw new ArithmeticException("오버플로우 발생");
			}
		}
		return left + right;
		
	}

}
