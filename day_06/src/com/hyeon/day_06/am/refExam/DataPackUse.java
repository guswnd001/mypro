package com.hyeon.day_06.am.refExam;

import java.util.Scanner;

public class DataPackUse {

	public static void main(String[] args) {
		
//		Scanner scan = new Scanner(System.in);
//		DataPack useData;
//		useData = new DataPack(); //heap영역에 객체를 만든다. 주소를 저장
//		System.out.println(useData.numData);
//		useData.prnData(); //메소드이기 때문에 호출해야한다.

		double value = Math.PI;
		StringBuffer sb = new StringBuffer(); //좌변은 stack영역, 우변은 heap영역
		sb.append("영구없다~");
		sb.append(" 에? 짱구는 있네");
		
		System.out.println(value);
		System.out.println(sb.toString());
		System.out.println(sb.reverse());
		
		
		
	}

}
