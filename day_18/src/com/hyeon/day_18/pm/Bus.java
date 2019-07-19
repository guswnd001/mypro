package com.hyeon.day_18.pm;

public class Bus implements Vehicle{

	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	}
	
	public void checkFare() {
		System.out.println("승차요금을 체크합니다.");
	}
	
	public static void main(String[] args) {
		//Vehicle을 상속받은 Bus를 Vehicle 타입으로 초기화 했기 때문에
		//bus가 가지고 있는 메소드는 사용불가
		Vehicle v = new Bus(); 
		v.run();
		v.checkFare();
		Bus b = (Bus)v; //강제타입 변환
		b.run();
		b.checkFare();
		
	}
}
