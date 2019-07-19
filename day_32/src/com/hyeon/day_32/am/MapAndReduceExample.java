package com.hyeon.day_32.am;

import java.util.Arrays;
import java.util.List;

public class MapAndReduceExample {

	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("김현중", 10),
				new Student("이승주", 20),
				new Student("김주호", 30));
		
		double avg = studentList.stream()
				//중간처리(학생 객체에서 점수로 매핑)
				.mapToInt(Student :: getScore)
						// s --> s.getScore()
				//최종처리(평균 점수)
				.average()
				.getAsDouble();
		System.out.println("평균 점수: " + avg);
	}

}
