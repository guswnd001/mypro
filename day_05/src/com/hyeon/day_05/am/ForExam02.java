package com.hyeon.day_05.am;

public class ForExam02 { //class도 자료 타입이다. 

	public static void main(String[] args) {
		
		String[] inames = {"김현중", "박성범", "정대화", "양우영", "기리기리"}; 
		int arrCnt = inames.length; //미리 길이 값을 초기화한 후 남은 연산을 진행해야 더 빠르다.
		
//		for (int i = 0; i < inames.length; i++) { 반복할때마다 길이 값을 받아와야 하기 때문에 속도가 느리다. 피해야하는 패턴이다. 
		for (int i = 0; i < arrCnt; i++) {
			System.out.println("배열에 들어있는 이름 : " + inames[i]);
		}
		
		String words = "I just be alone";
		
	}

}
