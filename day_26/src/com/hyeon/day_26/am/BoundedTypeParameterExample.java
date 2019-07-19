package com.hyeon.day_26.am;

public class BoundedTypeParameterExample {

	public static void main(String[] args) {
		int result1 = Util1.compare(10, 20);
		System.out.println(result1);
		
		int result2 = Util1.compare(4.5, 3);
		System.out.println(result2);
	}

}

class Util1 {
	public static <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue();
		System.out.println(t1.getClass().getName());
		double v2 = t2.doubleValue();
		System.out.println(t2.getClass().getName());
		return Double.compare(v1, v2);
	}
}