package com.hyeon.day_27.pm;

import java.util.function.UnaryOperator;

public class IdentityExample {

	public static void main(String[] args) {
		//
		UnaryOperator<Member1> operator = UnaryOperator.identity();
		Member1 member = operator.apply(new Member1("김현중", "kim"));
		System.out.println("이름 : " + member.getName());
		System.out.println("아이디 : " + member.getId());
	}

}

class Member1 {
	private String name;
	private String id;
	
	public Member1(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
}
