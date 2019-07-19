package com.hyeon.day_32.pm;

import java.util.Arrays;
import java.util.List;

public class FilteringExample {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("김현중", "이승주", "조혜빈", "김현중", "김주호");
		
		names.stream()
			.distinct()
			.forEach( n -> System.out.println(n));
		System.out.println();
		
		names.stream()
			.filter( n -> n.startsWith("김"))
			.forEach( n -> System.out.println(n));
		System.out.println();
		
		names.stream()
			.distinct()
			.filter( n -> n.startsWith("김"))
			.forEach( n -> System.out.println(n));
	}

}
