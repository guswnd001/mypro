package com.hyeon.day_17.am;

public class HankookTire extends Tire {
	//필드
	
	//생성자
	public HankookTire(String lacation, int maxRotation) {
		super(lacation, maxRotation);
	}
	
	//메소드
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if (accumulatedRotation < maxRotation) {
			System.out.println(location + "HankookTire 수명 : " + (maxRotation - accumulatedRotation) + "회");
			return true;
		} else {
			System.out.println("*** " + location + "HankookTire 펑크 ***");
			return false;
		}
	}
}
