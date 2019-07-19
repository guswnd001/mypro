package com.hyeon.day_12.am;

public class CalculatorExample01 {

	public static void main(String[] args) {

		Calculator01 myCal = new Calculator01();
		
		double result1 = myCal.areaRectangle(10);
		
		double result2 = myCal.arraRectangle(10, 20);
		
		System.out.println(result1);
		System.out.println(result2);
		
		
	}

}

class Calculator01 {

	public double areaRectangle(int i) {
		return (double)i*i;
	}
	

	public double arraRectangle(int i, int j) {
		return (double)i*j;
	}

}
