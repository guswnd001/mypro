package com.hyeon.day_30.pm;

import java.util.*;

public class HashSetExample2 {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		set.add(new Member("이승주", 27));
		set.add(new Member("이승주", 27)); //인스턴스는 다르지만 내부 데이터가 동일하므로 객체 1개만 저장 
		set.add(new Member("김현중", 28));
		
		System.out.println("총 객체수: " + set.size()); //저장된 객체 수 얻기
	}

}

class Member {
	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) { //name과 age값이 같으면 true를 리턴
		if (obj instanceof Member) {
			Member member = (Member)obj;
			return member.name.equals(name) && (member.age == age);
		} else {
			return false;
		}
	}
	@Override
	public int hashCode() { //name과 age 값이 같으면 동일한 hashCode를 리턴
		return name.hashCode() + age;
	}
	
}