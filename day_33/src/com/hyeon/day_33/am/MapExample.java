package com.hyeon.day_33.am;

import java.util.Arrays;
import java.util.List;

public class MapExample {

	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList( 
				new Student("김현중", 10),
				new Student("이승주", 20),
				new Student("김주호", 30));
		
		studentList.stream()
				.mapToInt(Student :: getScore)
				.forEach( score -> System.out.println(score) );
	}

}

