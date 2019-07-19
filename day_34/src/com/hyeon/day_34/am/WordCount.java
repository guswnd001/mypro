package com.hyeon.day_34.am;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCount {

	public static void main(String[] args) throws FileNotFoundException{
		String path = "moon.txt";
		BufferedReader br = new BufferedReader(new FileReader(path));
		Stream<String> f = br.lines();
		Map<String, Long> map = f.flatMap( (s) -> {
			s = s.trim();
			s = s.replace("  ", " ");
			s = s.replace("'", "");
			s = s.replace("한", "");
			String[] str = s.split(" ");
			return Arrays.stream(str);
		}).filter( (s) -> s.length() > 0)
		  .collect(Collectors.groupingBy(String :: toString, Collectors.counting()));
		
		map.entrySet().stream()
		.sorted(new Comparator<Map.Entry<String, Long>>() {
			
			//@Override
			public int compare(Entry<String, Long> o1, Entry<String, Long> o2) {
				return (int)(o2.getValue() - o1.getValue());
			}
		})
		.skip(5)
		.limit(5)
		.forEach( (s) -> System.out.println(s) );
		System.out.println();
		
		Set<Map.Entry<String, Long>> set = map.entrySet();
		for (Map.Entry<String, Long> e : set) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}
	}

}
