package com.hyeon.day_11.am;

public class Car {
	//필드
	String company = "현대자동차";
	String model = "그렌저";
	String color = "Black";
	int maxSpeed = 350;
	int speed;
	
	//생성자
	Car(){
		
	}
	
	Car(String model) {
		this(model, null, 0);
	}
	
	Car(String model, String color) {
		this(model, color, 0);
	}
	
	Car(String model, String color, int maxSpeed){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	
}
