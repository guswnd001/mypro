package com.hyeon.day_08.multiLevelArray;

public class MultiLevelArr03 {

	public static void main(String[] args) {
		
		String[] strArr = new String[] {"java", "java", new String("java")};
		
		System.out.println(strArr[0] == strArr[1]);
		System.out.println(strArr[0].equals(strArr[1]));
		System.out.println(strArr[0] == strArr[2]);
		System.out.println(strArr[1].equals(strArr[2]));
		
	}
	
	
	
}
