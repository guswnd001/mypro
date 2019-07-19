package com.hyeon.day_28.am;

import java.util.function.ToIntBiFunction;

public class ArgumentMethodReferencesExample {
	
	public static void main(String[] args) {
	
		ToIntBiFunction<String, String> function;
		
		function = (a,b) -> a.compareToIgnoreCase(b);
		print(function.applyAsInt("Java8", "JAVA8"));
		
		function = String :: compareToIgnoreCase;
		print(function.applyAsInt("Java8", "JAVA8"));
		
		//인스턴스 메소드는 앞에 클래스를 붙일 수 없지만 제너릭을 사용하는 경우에는 붙일 수 있다. 
	}
	
	public static void print(int order) {
		if (order < 0) {
			System.out.println("사전순으로 출력합니다.");
		} else if (order == 0) {
			System.out.println("동일한 문자열입니다.");
		} else {
			System.out.println("사전 역순으로 출력합니다.");
		}
	}
	
}
