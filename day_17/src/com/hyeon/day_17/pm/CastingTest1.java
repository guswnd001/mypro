package com.hyeon.day_17.pm;

class Car {
	String color;
	int door;
	void drive() {
		System.out.println("drive, Brrrrr~");
	}
	
	void stop() {
		System.out.println("stop!!!");
	}
}

class FireEngine extends Car {
	void water() {
		System.out.println("water!!!");
	}
}

public class CastingTest1 {

	public static void main(String[] args) {
		
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		fe.water();
		car = fe;
		fe2 = (FireEngine)car; //부모(Car)를 자식(FireEngine)에게 초기화
		fe2.water();
		
	}

}
