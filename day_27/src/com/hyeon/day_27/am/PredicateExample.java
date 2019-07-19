package com.hyeon.day_27.am;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
	private static List<Student1> list = Arrays.asList(
			new Student1("김현중", "남성", 90),
			new Student1("이승주", "여성", 95),
			new Student1("조혜빈", "남성", 90),
			new Student1("허가영", "여성", 92)
			);
	
	public static double avg(Predicate<Student1> predicate) {
		int count = 0, sum = 0;
		for (Student1 student1 : list) {
			if (predicate.test(student1)) {
				count++;
				sum += student1.getScore();
			}
		}
		return (double)sum/count;
	}
	
	public static void main(String[] args) {
		double maleAvg = avg(t -> t.getSex().equals("남성"));
		System.out.println("남자 평균 점수: " + maleAvg);
		
		double femaleAvg = avg(t -> t.getSex().equals("여성"));
		System.out.println("여자 평균 점수: " + femaleAvg);
		
	}

}
