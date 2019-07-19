package com.hyeon.day_32.pm;

import java.util.Arrays;
import java.util.List;

public class MapExample {

	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("김현중", 90),
				new Student("이승주", 80),
				new Student("김주호", 70));
		
		studentList.stream()
			.mapToInt(Student :: getScore)
			.forEach( score -> System.out.println(score));
	}

}

class Student {
	private String name;
	private int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
}