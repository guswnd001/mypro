package com.hyeon.day_05.am;

public class StringReverse {

	public static void main(String[] args) {

		String strData = "hyeonjoongClub";
		int strSize = strData.length();
		System.out.println("문자열의 개수 : " + strSize);
		
		//reverse 
		
		for (int i = 0; i < strSize; i += 1) {
			int indexNum = strSize-1-i;
			//System.out.println("i = " + i + "\t\t" + "indexNum = " + indexNum);
			System.out.print((char)(strData.charAt(indexNum)+1));
		}
		
		
	}

}
