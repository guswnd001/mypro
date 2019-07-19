package com.hyeon.day_32.am;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class IteratorVsStreamExmaple {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("김현중", "이승주", "김주호");
		
		//Iterator 이용
		System.out.println("Iterator 이용");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
		}
		
		System.out.println();
		
		//Stream 이용
		System.out.println("Stream 이용");
		Stream<String> stream = list.stream();
		//forEach는 최종처리 메소드
		//forEach 람다식의 name은 위의 String을 받는 것이다
		stream.forEach( name -> System.out.println(name) );
	}

}
