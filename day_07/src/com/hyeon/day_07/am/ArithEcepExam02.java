package com.hyeon.day_07.am;

public class ArithEcepExam02 {

	public static void main(String[] args) {
		
		int[] intArr = null;
		/*stack영역에 생성된 참조형 변수이며, 4byte짜리 변수이다. 
		배열이기 때문에 주소값을 가질 수 있다.*/
		intArr = new int[6]; 
		/*heap영역에 6칸짜리 배열을 생성.
		이때 각각 값을 주지 않아도 기본값으로 0이 들어간다.*/
		intArr [5] = 10;
		System.out.println(intArr[0]);
		System.out.println(intArr[5]);
		System.out.println(intArr[6]);
		
		
	}

}
