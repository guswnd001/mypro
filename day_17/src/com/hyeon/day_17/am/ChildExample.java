package com.hyeon.day_17.am;

public class ChildExample {

	public static void main(String[] args) {
		
		Parents parents = new Child();
		
		parents.field1 = "부모 필드";
		parents.method1();
		parents.method2();
		
		//불가능
//		parents.field2 = "자식 필드"; 	
//		parents.method3();			
		
		//가능
		Child child = new Child();
		child.field2 = "자식 필드";
		child.method3();
		
	}

}
