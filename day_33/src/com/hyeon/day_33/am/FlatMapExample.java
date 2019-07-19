package com.hyeon.day_33.am;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample {

	public static void main(String[] args) {
		List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");
		inputList1.stream() //return Stream<String>
				.flatMap( data -> Arrays.stream(data.split(" ")) ) //data는 String
				.forEach( word -> System.out.println(word) ); //word는 String
		
		System.out.println();
		
		List<String> inputList2 = Arrays.asList("10, 20, 30", "40, 50, 60");
		inputList2.stream() //return Stream<String>
				.flatMapToInt( data -> { //data는 String
					String[] strArr = data.split(",");
					int[] intArr = new int[strArr.length];
					for (int i = 0; i < strArr.length; i++) {
						intArr[i] = Integer.parseInt(strArr[i].trim());
					}
					return Arrays.stream(intArr); })
				.forEach( number -> System.out.println(number) ); //number는 int
		
	}

}
