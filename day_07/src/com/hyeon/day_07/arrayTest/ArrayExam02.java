package com.hyeon.day_07.arrayTest;

import com.hyeon.day_07.classes.MemberVO;

public class ArrayExam02 {

	public static void main(String[] args) {
		
		MemberVO[] vo;
		vo = new MemberVO[] {new MemberVO("김현중"), new MemberVO("박성범"), new MemberVO("정대화")};
		
		//arrDataPrn(vo);
		arrDataPrn(new MemberVO[] {new MemberVO("김현중"), new MemberVO("박성범"), new MemberVO("정대화")});
		System.out.println("=========================");
		arrDataPrn(new MemberVO[] {new MemberVO("조선형"), new MemberVO("장봉기"), new MemberVO("이호연"),
								   new MemberVO("누구구"), new MemberVO("우크라이나"), new MemberVO("이이")});
		
		System.out.println("=========================");
		MemberVO[] memData = {new MemberVO("유비"), new MemberVO("관우"), new MemberVO("장비")};
		arrDataPrn(memData);
		
		System.out.println("=========================");
		System.out.println(memData[0].getIrum());
		
	}
	
	public static void arrDataPrn(MemberVO[] valueObj) {
		int arrCnt = valueObj.length;
		
		for (int i = 0; i < arrCnt; i += 1) {
			System.out.println(valueObj[i].getIrum());
		}
		valueObj[0].setIrum("이런,");
		
	}

}
