package test;

import java.util.Scanner;

class Baseball {
	static String num1 = Integer.toString(1234); //(int)(Math.random()*9000) + 1000;
	String num2;
}

public class BaseballGame {

	public static void main(String[] args) {
		
		System.out.println(Baseball.num1);
		Baseball baseNo = new Baseball();
		baseNo.num2 = numberInput();
		
		String[] numArr1 = new String[4];
		String[] numArr2 = new String[4];
		
		for (int i = 0; i < numArr1.length; i++) {
			
		}
		
		
		
		
	}
	
	public static String numberInput() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
}
