package com.hyeon.day_33.am;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortingExample {

	public static void main(String[] args) {
		//숫자 요소일 경우
		IntStream intStream = Arrays.stream( new int[] {5, 4, 3, 2, 1} );
		intStream.sorted()
				.forEach( n -> System.out.print(n + ", ") );
		System.out.println();
		
		//객체요소일 경우
		List<Student> studentList = Arrays.asList(
				new Student("김현중", 30),
				new Student("이승주", 10),
				new Student("김주호", 20));
		studentList.stream()
				.sorted()
				.forEach( s -> System.out.print(s.getScore() + ", ") );
		System.out.println();
		
		studentList.stream()
				.sorted( Comparator.reverseOrder() )
				.forEach( s -> System.out.print(s.getScore() + ", ") );
	}

}
