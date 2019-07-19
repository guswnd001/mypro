package com.hyeon.day_26.pm;

public class UsingLocalVariable {
	
	void method(int arg) {
		int localVar = 40;
		//arg = 31;
		//localVar = 40;
		/*위의 서식은 에러가 난다.
		* 그 이유는 내부 메소드(클래스)안에서 변수는 상수(한번 정하면 바꿀 수 없는 수)가 되는데
		* 값이 초기화된 이후로 값을 바꾸었기에 에러가 난다.*/
		//람다식
		MyFunctionalInterface4 fi = () -> {
			//로컬변수 사용
			System.out.println("arg: " + arg);
			System.out.println("localVar: " + localVar + "\n");
		};
		fi.method();
	}
}

interface MyFunctionalInterface4 {
	public void method();
}
