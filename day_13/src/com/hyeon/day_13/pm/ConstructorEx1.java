package com.hyeon.day_13.pm;

class Number1 {
	int num;
}

class Number2 {
	int num;
	
	Number2(){
		
	}
	
	Number2(int x) {
		num = x;
	}
}


public class ConstructorEx1 {

	public static void main(String[] args) {

		Number1 n1 = new Number1();
		n1.num = 10;
		Number2 n2 = new Number2(20);
		Number2 n3 = new Number2();
		
		
	}

}
