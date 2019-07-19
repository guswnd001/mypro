package com.hyeon.day_17.am;

public class InstanceOfExample {

	public static void method1(Parents parents) {
		if (parents instanceof Child) {
			Child child = (Child) parents;
			System.out.println("method1 - Child로 변환 성공");
		} else {
			System.out.println("method1 - Child로 변환되지 않음");
		}
	}
	
	public static void method2(Parents parents) {
		Child child = (Child) parents;
		System.out.println("method2 - Child로 변환 성공");
	}
	
	public static void main(String[] args) {
		Parents parentsA = new Child();
		method1(parentsA);
		method2(parentsA);
		
		Parents parentsB = new Parents();
		method1(parentsB);
		method2(parentsB);
	}

}
