package com.hyeon.day_26.am;

public class CompareMethodExample {

	public static void main(String[] args) {
		
		Pair<Integer, String> p1 = new Pair<>(1, "사과");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "사과");
		boolean result1 = Util.<Integer, String>compare(p1, p2);
		if (result1) {
			System.out.println("논리적으로 같은 객체입니다.");
		} else {
			System.out.println("논리적으로 같지 않은 객체입니다.");
		}
		
		Pair<String, String> p3 = new Pair<String, String>("user1", "김현중");
		Pair<String, String> p4 = new Pair<String, String>("user1", "김현중");
		boolean result2 = Util.compare(p3, p4);
		if (result2) {
			System.out.println("논리적으로 같은 객체입니다.");
		} else {
			System.out.println("논리적으로 같지 않은 객체입니다.");
		}
		
	}

}
