package com.hyeon.day_09.am;

public class OpExam {

	public static void main(String[] args) {
		
		int time = 54321;
		int houTime = (time/3600)%60;
		int minTime = (time/60)%60;
		int secTime = time%60;
		
		System.out.println("[결과] " + time + "초 = " + 
							houTime + "시간 " + minTime + "분 "+ secTime + "초");
		System.out.println("=======================================");
		
		byte a = 10;
		byte b = 20;
		byte c = (byte)(a + b);
		char ch ='A';
		ch = (char)(ch + 2);
		float f = 3/2f;
		long l = 3000 * 3000 * 3000l;
		float f2 = 0.1f;
		double d = 0.1;
		boolean result = (float)d==f2;
		
		System.out.println("c = " + c);
		System.out.println("ch = " + ch);
		System.out.println("f = " + f);
		System.out.println("l = " + l);
		System.out.println("result = " + result);
		
		
	}

}
