package com.hyeon.day_32.am;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FromArrayExample {

	public static void main(String[] args) {
		String[] strArr = { "김현중", "이승주", "김주호" };
		Stream<String> strStream = Arrays.stream(strArr);
		strStream.forEach(s -> System.out.print(s + ", "));
		System.out.println();
		
		int[] intArr = { 1, 2, 3, 4, 5};
		IntStream intStream = Arrays.stream(intArr);
		intStream.forEach(i -> System.out.print(i + ", "));
		System.out.println();
	}

}
