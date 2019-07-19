package com.hyeon.day_08.multiLevelArray;

public class UpForExam {

	public static void main(String[] args) {
		
		String[] inames = {"김현중", "이순신", "세종대왕", "신사임당", "유관순", "조마리아"};
		
		for (int i = 0; i < inames.length; i++) {
			System.out.println(inames[i]);
		}
		System.out.println();
		System.out.println("향상된 for문을 사용한 배열 자료 출력");
		for (String arrData : inames) {
			System.out.println(arrData);
		}
	}

}
