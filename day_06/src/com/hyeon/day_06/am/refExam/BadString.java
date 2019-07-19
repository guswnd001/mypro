package com.hyeon.day_06.am.refExam;

public class BadString {

	public static void main(String[] args) {
		
//		String dataStr = "가";
//		//System.out.print((int)('가')); //44032
//		char baseChar = 44032;
//		
//		for (int i = 1; i < 21; i++) {
//			dataStr = dataStr + (char)(baseChar + i);
//		}
//		System.out.println(dataStr);
		
		StringBuilder dataStr = new StringBuilder("가"); //좌변은 stack영역, 우변은 heap영역
		char baseChar = 44032;
		
		for (int i = 1; i < 21; i++) {
			dataStr.append((char)(baseChar + i));
		}
		System.out.println(dataStr);
		
		String strData1 = "김현중"; //좌면은 다 stack영역에 있다.
		String strData11 = "김현중";
		String strData2 = new String("김현중");
		String strData2Copy = strData2; //strData2의 주소값 그대로 가져온다.
		
		System.out.println(strData1 + ", " + strData11);
		System.out.println(strData2 == strData2Copy);
		System.out.println(strData1.equals(strData2Copy));
		
		System.out.println("===========변경전================");
		System.out.println("strData2 : " + strData2); //== strData2.toString()
		System.out.println("strData2CP : " + strData2Copy);
		System.out.println();
		
		strData2 = strData2 + "하현지";
		System.out.println("===========변경후================");
		System.out.println("strData2 : " + strData2.toString());
		System.out.println("strData2CP : " + strData2Copy);
		
		
	}

}
