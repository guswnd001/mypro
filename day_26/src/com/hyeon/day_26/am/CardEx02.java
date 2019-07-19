package com.hyeon.day_26.am;

//클래스 변수 : width, height
//인스턴스 변수 : kind, num
//지역 변수 : k, n, card

public class CardEx02 {
	int num;
	boolean joker;
	
	public CardEx02() {	this.num = 1;}
	public CardEx02(int num, boolean joker) {
		this.num = num;
		this.joker = joker;
	}
	
	public String info() {
		if (joker) { return num + " " + "joker 입니다.";	}
		else { return num + " " + "joker가 아닙니다.";	}
	}
	
	public static void main(String[] args) {
		CardEx02 card1 = new CardEx02(3, true);
		CardEx02 card2 = new CardEx02();
		
		System.out.println(card1.info());
		System.out.println(card2.info());
		
	}
	
}
