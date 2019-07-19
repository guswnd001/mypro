package com.hyeon.day_14.am;

class Sonata2 {
	String color; //인스턴스 멤버
	int number; //인스턴스 멤버
	int serialNo; //인스턴스 멤버
	static int sno; //클래스 멤버, 기본값 = 0
	static int width = 250; //클래스 멤버
	static int height = 150; //클래스 멤버
	@Override
	public String toString() {
		return "자동차 고유번호 : " + serialNo + ", " + color + " : " + number + 
					"(" + width + ", " + height + ", 자동차 생산번호 : " + sno + ")";
	}
}

public class SonataEx02 {

	public static void main(String[] args) {
		
		Sonata2 car1 = new Sonata2(); //지역변수
		car1.color = "white";
		car1.number = 1234;
		car1.serialNo = ++Sonata2.sno; //1
		System.out.println(car1);
		
		Sonata2 car2 = new Sonata2(); //지역변수
		car2.color = "black";
		car2.number = 4567;
		car2.serialNo = ++Sonata2.sno; //2
		System.out.println(car2);
		
		Sonata2 car3 = new Sonata2(); //지역변수
		car3.color = "red";
		car3.number = 8910;
		car3.serialNo = ++Sonata2.sno; //3
		
		Sonata2 car4 = car3;
		System.out.println(car3);
		System.out.println(car4);
		
		
	}

}
