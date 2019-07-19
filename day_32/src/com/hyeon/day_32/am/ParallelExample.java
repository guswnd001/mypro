package com.hyeon.day_32.am;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelExample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList(
				"김현중", "이승주", "김주호",
				"조혜빈", "허가영"
				);
		
		//순차 처리
		Stream<String> stream = list.stream();
		stream.forEach(ParallelExample :: print);
					//메소드 참조(s -> ParallelExample.print(s)와 동일
		System.out.println();
		
		//병렬 처리
		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(ParallelExample :: print);
							//메소드 참조(s -> ParallelExample.print(s)와 동일
	}
	
	public static void print(String str) {
		System.out.println(str + " : " + Thread.currentThread().getName());
	}

}
