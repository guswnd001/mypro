package com.hyeon.day_12.am;

public class ComputerExample {

	public static void main(String[] args) {

		Computer myCom = new Computer();
		
		int[] values1 = {1, 2, 3};
		int result1 = myCom.sum1(values1);
		System.out.println(result1);
		
		int result2 = myCom.sum1(new int[] {1, 2, 3, 4, 5, 6});
		System.out.println(result2);
		
		int result3 = myCom.sum2(1, 2, 3);
		System.out.println(result3);
		
		int result4 = myCom.sum2(1, 2, 3, 4, 5, 6, 7, 7, 7);
		System.out.println(result4);
		
	}

}

class Computer {

	public int sum1(int[] values) {
		
		int sum = 0;
		for (int i : values) sum += i;
		//for (int i = 0; i < values.length; i++) sum += values[i];
		return sum;
	}

	public int sum2(int ... values) {
		
		int sum = 0;
		for (int i = 0; i < values.length; i++) sum += values[i];
		//for (int i : values) sum += i;
		return sum;
	}
	
	
	
}
