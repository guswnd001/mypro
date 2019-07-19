package com.hyeon.day_17.pm;

public class CastingTest2 {

	public static void main(String[] args) {
		
		Car car = new Car();
		Car car2 = new Car();
		FireEngine fe = null;
		
		car.drive();
		
		fe = (FireEngine)car;
		fe.drive();
		car2 = fe;
		car2.drive();
		
	}

}
