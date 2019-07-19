package com.hyeon.day_13.am;

public class ClassMaker {

	public static void main(String[] args) {
		//1.동전 던지기
		Coin c = new Coin();
		c.flip();
		System.out.println("===================");
		
		//2.동물 구현하기
		Animal a = new Animal();
		a.eat();
		System.out.println("===================");
		
		//3.학생 만들기
		Student s = new Student();
		s.name = "김현중";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		
		System.out.println(s.name);
		System.out.println(s.getTotal());
		System.out.println(s.getAverage());
		
	}

}

class Coin {
	
	String side;
	
	public void flip() {
		int setNum = (int)(Math.random()*2);
		if (setNum == 0) {
			side = "<앞면>100원";
			System.out.println(side);
		} else {
			side = "<뒷면>이순신장군";
			System.out.println(side);
		}
	}
	
}

//2.
class Animal {
	
	String name;
	int age;
	
	public void eat() {
		System.out.println("맛있게 냠냠");
	}
}

//3.
class Student {
	
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	public int getTotal() {
		int total = kor + eng + math;
		return total;
	}
	
	public float getAverage() {
		float average = getTotal()/3.0f;
		return Math.round(average*100)/100.0f;
		//return average;
	}
	
}





















