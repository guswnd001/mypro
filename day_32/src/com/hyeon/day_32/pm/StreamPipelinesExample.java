package com.hyeon.day_32.pm;

import java.util.Arrays;
import java.util.List;

public class StreamPipelinesExample {

	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
				new Member("김현중", Member.MALE, 30),
				new Member("이승주", Member.MALE, 20),
				new Member("조혜진", Member.FEMALE, 45),
				new Member("허가영", Member.FEMALE, 27) );
		
		double ageAvg = list.stream() //오리지날 스트림
				//중간처리 스트림
				.filter( m -> m.getSex() == Member.MALE)
				.mapToInt(Member :: getAge)
				//최종처리 스트림
				.average()
				.getAsDouble();
				
		System.out.println("남자 평균 나이: " + ageAvg);
				
	}

}

class Member {
	public static int MALE = 0;
	public static int FEMALE = 1;
	
	private String name;
	private int sex;
	private int age;
	
	public Member(String name, int sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public int getSex() { return sex; }
	public int getAge() { return age; }
	
}