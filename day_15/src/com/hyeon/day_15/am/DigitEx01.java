package com.hyeon.day_15.am;

public class DigitEx01 {

	public static void main(String[] args) {
		
		int num = 123;
		int origin = num;
		int digit = 16;
		String line = "";
		char[] data = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'}; 
		
		while (num!=0) { 
			   
			int mod = num % digit;
			char temp = data[mod];
			num = num / digit;
			line = temp + "" + line;
			
		}
		System.out.println(origin + "을 16진수로 " + line);
		
		
	}

}
