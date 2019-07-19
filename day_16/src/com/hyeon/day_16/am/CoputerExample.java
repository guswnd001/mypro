package com.hyeon.day_16.am;

public class CoputerExample {

	public static void main(String[] args) {
		
		int r = 10;
		Calculator calculator = new Calculator();
		Calculator computer = new Computer();
		
		System.out.println(calculator.areaCircle(r));
		System.out.println(computer.areaCircle(r));
		
	}

}
