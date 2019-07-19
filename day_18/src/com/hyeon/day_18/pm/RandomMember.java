package com.hyeon.day_18.pm;

public class RandomMember {

	public static void main(String[] args) {
		
		String[] member = {"전혜빈", "허가영", "김주호", "김현중", "이승주"};
		
		int num = (int)(Math.random()*5);
		
		System.out.println("이번 발표의 주인공은?! " + member[num] + "(이)다!!!!");
		System.out.println(member[num] + "은(는) 당황했다!!");
	}

}
