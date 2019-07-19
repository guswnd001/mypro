package com.hyeon.day_14.am;

class Sonata {
	String color; //인스턴스 변수
	int number; //인스턴스 변수
	static int width = 250; //클래스 변수
	static int height = 150; //클래스 변수
	@Override
	public String toString() { 
		//참조형 변수를 그대로 출력하면 주소값이 나온다. 
		//이를 주소값이 아닌 실제 값을 확인 하기 위해 toString()을 사용한다.
		//클래스의 인스턴스 변수를 사용해 값을 만들어 리턴해 준다. 
		return color + ":" + number + "(" + width + ", " + height + ")";
	}
}

public class SonataEx01 {

	public static void main(String[] args) {
		System.out.println("자동차의 크기 : " + Sonata.width + ", " + Sonata.height);
		Sonata car1 = new Sonata();
		car1.color = "white";
		car1.number = 1234;
		System.out.println("car1 = " + car1);
		
		Sonata car2 = new Sonata();
		car2.color = "black";
		car2.number = 4567;
		System.out.println("car2 = " + car2);
		
		car1.width = 300;
		car1.height = 200;
		System.out.println("car1 = " + car1);
		System.out.println("car2 = " + car2);
		System.out.println("=========================");
		System.out.println((int)(Math.random()*2));
		
	}

}
