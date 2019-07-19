package com.hyeon.day_14.am;

class Value {
	int val; //인스턴스 변수이다.
}

public class ParameterEx01 {

	public static void main(String[] args) {

		Value v = new Value(); //인스턴스 변수이기때문에 사용하기 위해서는 객체를 생성해야 한다.
		v.val = 100;
		change1(v.val);
		System.out.println("change1()실행 이후 = " + v.val); //100
		change2(v);
		System.out.println("change2()실행 이후 = " + v.val); //200
		
	}
	
	private static void change1(int val) { //파라미터가 기본형, 값 자체를 받아온다.
		//값 자체를 가져다 쓰는 파라미터이기 때문에 실행 후에도 실제 값에는 영향을 주지 못한다.
		val += 100;
		System.out.println("change1() = " + val); //200
	}
	
	private static void change2(Value v) { //파라미터가 참조형, 값이 들어있는 주소를 받아온다.
		//값이 들어있는 주소를 가져오기 때문에 메소드 실행 후에도 실제 값에 영향을 준다.
		v.val += 100;
		System.out.println("change2() = " + v.val); //200
	}

}
