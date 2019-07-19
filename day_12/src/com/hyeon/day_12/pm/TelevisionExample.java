package com.hyeon.day_12.pm;

public class TelevisionExample {

	public static void main(String[] args) {
		
		System.out.println(Television.info); //순서 2
		System.out.println("========================");
		
		Television t1 = new Television();
		Television t2 = new Television();
		Television t3 = new Television();
		Television t4 = new Television();
		t2.model = "aaa";
		t3.model = "bbb";
		System.out.println(t1.model);
		
	}

}

class Television {
	
	static String company = "Samsung";
	 String model = "LCD";
	static String info;
	
	static {
		info = company + "-" + model;
		System.out.println("========================"); //순서 1
	}
	
}
