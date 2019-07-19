package com.hyeon.day_10.am;

public class MainStringArrayArgument {

	public static void main(String[] args) {//args 외부에서 값을 넣을 수 있다.(특수한 목적을 위해)
		
		if (args.length != 2) {
			System.out.println("프로그램 사용법");
			System.out.println("java MainStringArrayArgument num1 num2");
			System.exit(0);
		}
		
		String strNum1 = args[0];
		String strNum2 = args[1];
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
		
	}

}
