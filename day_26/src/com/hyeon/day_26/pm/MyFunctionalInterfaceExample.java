package com.hyeon.day_26.pm;

public class MyFunctionalInterfaceExample {

	public static void main(String[] args) {
		
		MyFunctionalInterface1 fi;
		fi = (f, f1) -> { String str = "method call1";
				 	 System.out.println(str); };
		fi.method(2, "aaa");
		
		fi = (a, b) -> { System.out.println("method call2"); };
		fi.method(3, "bbb");
		
		fi = (b, f) -> { System.out.println("method call3"); };
		fi.method(4, "ccc");
		
	}

}

@FunctionalInterface
interface MyFunctionalInterface1 {
	public void method(int x, String s);
}
