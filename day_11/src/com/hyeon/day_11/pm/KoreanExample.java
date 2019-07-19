package com.hyeon.day_11.pm;

public class KoreanExample {

	public static void main(String[] args) {

		Korean k1 = new Korean("김현중", "990101-1111000");
		System.out.println("k1.name : " + k1.name);
		System.out.println("k1.ssn : " + k1.ssn);
		
		Korean k2 = new Korean("박자가", "930201-1535452");
		System.out.println("k2.name : " + k2.name);
		System.out.println("k2.ssn : " + k2.ssn);
		
		Korean k3 = new Korean("박자가", 25);
		System.out.println("k3.name : " + k3.name);
		System.out.println("k3.age : " + k3.age);
		
		
	}

}
