package com.hyeon.day_07.classes;

public class MemberUse {

	public static void main(String[] args) {
		
		MemberVO vo1 = new MemberVO();
		vo1.setIrum("김현중");
		vo1.setPwd("aa123");
		vo1.setId("guswnd001");
		
		System.out.println(vo1.toString());
	}

}
