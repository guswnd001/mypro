package com.hyeon.day_28.pm;

public class MainThreadExample {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		User1 user1 = new User1();
		user1.setCalculator(calculator);
		
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		
		user2.start();
		user1.start();
	}

}
