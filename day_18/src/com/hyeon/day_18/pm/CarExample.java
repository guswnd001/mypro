package com.hyeon.day_18.pm;

public class CarExample {

	public static void main(String[] args) {
		
		Car myCar = new Car();
		
		myCar.run();
		
		myCar.tires[0] = new KumhoTire();
		myCar.tires[1] = new KumhoTire();
		
		System.out.println("==================");
		
		myCar.run();
		
	}

}
