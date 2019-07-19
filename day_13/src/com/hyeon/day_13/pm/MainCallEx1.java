package com.hyeon.day_13.pm;

import java.lang.reflect.Method;

public class MainCallEx1 {
	
	static int cv1 = 10;
	static int cv2 = cv1;
	int iv1 = 100;
	int iv2 = iv1;
	
	public static void main(String[] args) {
		
		MainCallEx1 mc = new MainCallEx1();
		
		cv2 = mc.iv1;
		mc.method1();
		method2(mc.iv1, mc.iv2);
		
	}
	
	void method1() {
		System.out.println(cv1 + cv2);
		System.out.println(iv1 + iv2);
	}

	static void method2(int iv1, int iv2) {
		System.out.println(cv1 + cv2);
		System.out.println(iv1 + iv2); 
	}
}
