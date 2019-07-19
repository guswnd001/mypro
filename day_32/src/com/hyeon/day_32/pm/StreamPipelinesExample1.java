package com.hyeon.day_32.pm;

import java.util.Arrays;
import java.util.List;

public class StreamPipelinesExample1 {

	public static void main(String[] args) {
		List<Member1> names = Arrays.asList(
				new Member1("김현중", Member1.MALE, 30),
				new Member1("이승주", Member1.MALE, 20),
				new Member1("조혜진", Member1.FEMALE, 45),
				new Member1("조혜진", Member1.FEMALE, 45),
				new Member1("허가영", Member1.FEMALE, 27) );
		
		names.stream()
			.distinct()
			.forEach( n -> System.out.println(n));
		System.out.println();
		
		names.stream()
		.filter( n -> n.getName().startsWith("조"))
		.forEach( n -> System.out.println(n));
		System.out.println();
	
		names.stream()
		.distinct()
		.filter( n -> n.getName().startsWith("조"))
		.forEach( n -> System.out.println(n));
				
	}

}

class Member1 {
	public static int MALE = 0;
	public static int FEMALE = 1;
	
	private String name;
	private int sex;
	private int age;
	
	public Member1(String name, int sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public String getName() { return name; }
	public int getSex() { return sex; }
	public int getAge() { return age; }
	
	@Override
	public boolean equals(Object obj) {
		return name.equals(((Member1)obj).name);
	}
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	@Override
	public String toString() {
		return "Member1 [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
}