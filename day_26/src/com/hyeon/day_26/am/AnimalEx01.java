package com.hyeon.day_26.am;

public class AnimalEx01 {

	public static void main(String[] args) {
		Animal a1 = new Animal("원숭이", 26);
		Animal a2 = new Animal("사자");
		Animal a3 = new Animal(100);
		a1.eat();
		a1.show();
		a2.show();
		a3.show();
		
	}

}
