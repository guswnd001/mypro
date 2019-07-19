package com.hyeon.day_12.am;

public class CalculatorExample {

	public static void main(String[] args) {

		Calculator myCal = new Calculator();
		myCal.powerOn();
		
		int result1 = myCal.plus(5, 6);
		System.out.println(result1);
		
		byte x = 10;
		byte y = 4;
		double result2 = myCal.divide(x, y);
		System.out.println(result2);
		
		myCal.powerOff();
		
	}

}

class Calculator {
	
	public static void powerOn() {
		System.out.println("계산기가 켜졌습니다.");
	}

	public static int plus(int i, int j) {
		return i + j;
	}
	
	public double divide(byte x, byte y) {
		return ((double)x / y);
	}
	
	public void powerOff() {
		System.out.println("계산기가 꺼졌습니다.");
	}
	
}
