package com.hyeon.day_06.am.refExam;

public class EqualTest {

	public static void main(String[] args) {
		
		String data1 = new String("김현중"); // new는 무조건 heap영역
		String data2 = new String("김현중");
		
		System.out.println("== 연산자 비교 결과 : " + (data1 == data2));
		System.out.println(".equals 연산자 비교 결과 : " + (data1.equals(data2)));
		
		int k = 0; //메소드안에 존재 : 지역변수, 기본타입 변수, stack영역에 생성(stack영역에 생성하려면 꼭 초기화를 해야한다.)
		k += 1;
		DataObj obj; //지역변수, 참조타입(DataObj)의 변수, stack영역에 생성
////		System.out.println(obj); // => 초기화가 되지 않았는데 사용하여 오류발생 : 컴파일 오류
//		obj = null; // null과 색이 같은 것은 '예약어'이다. 
//		System.out.println(obj);
//		
		obj = new DataObj(); //객체 생성. //obj => 인스턴스 // 인스턴스는 객체
//		System.out.println(DataObj()); //주소값 출력.
		System.out.println(obj.num1); //실제 들어있는 값 출력.
		System.out.println(obj.isCheck); 
		
	}

}
