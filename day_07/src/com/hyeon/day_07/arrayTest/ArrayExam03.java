package com.hyeon.day_07.arrayTest;

import com.hyeon.day_07.classes.MemberVO;

public class ArrayExam03 {

	public static void main(String[] args) {
		
		int paramk = 100;
		MemberVO[] memData = {new MemberVO("현중"), new MemberVO("대화")};
		System.out.println("=============호출 전============");
		System.out.println(paramk);
		System.out.println(memData[0].getIrum());
		System.out.println("================================");
		
		arrDataPrn(memData, paramk);
		System.out.println("=============호출 후============");
		System.out.println(paramk);
		System.out.println(memData[0].getIrum());
		System.out.println("================================");
		
	}
	
	public static void arrDataPrn(MemberVO[] valueObj, int k) { 
		/* 참조형 자료를 메소드로 넘겨주는 것 - call by reference
		 * 기본형 자료를 메소드로 넘겨주는 것 - call by value
		 */
		
		System.out.println("=============메소드=============");
		int arrCnt = valueObj.length;
		System.out.println(k);
		
		for (int i = 0; i < arrCnt; i += 1) {
			System.out.println(valueObj[i].getIrum());
		}
		
		valueObj[0].setIrum("현중!");
		System.out.println("================================");
		
	}

}
