package com.hyeon.day_34.am;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAirplaneReport {

	public static void main(String[] args) throws FileNotFoundException{
		Path path = Paths.get("D:\\Hyeonjoong\\Java_H\\day_34\\AirplaneStream.txt");
		File file = path.toFile();
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		String[] country = { "일본", "중국", "미국", "호주", "동유럽", "서유럽", "동남아" };
		
		String companyName = "기타해외";
		
		Stream<Airplane> sa = br.lines().parallel()
					.map( (s) -> {
						String[] str = s.split(", ");
						String temp = "";
//						System.out.println(s);
						try { temp = str[6]; }
						catch (Exception e) { temp = ""; }
						
						return new Airplane(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2]),
								str[3], str[4], str[5], temp); } );
		
		Map<Integer, Map<String, Long>> report
			= sa.filter( (s) -> { return s.getCompany().equals(companyName); } )
				.collect(Collectors.groupingBy(Airplane :: getMonth,
						Collectors.groupingBy(Airplane :: getCountry,
					   Collectors.counting())));
		System.out.println(companyName + " 항공사의 월별 나라 출국인원");
		System.out.println("\t  일본\t  중국\t  미국\t  호주\t  동유럽\t  서유럽\t  동남아");
		System.out.println("=================================================================");
		for (int mon = 1; mon < 13; mon++) {
			System.out.print(mon + "월:\t");
			if (report.get(mon) != null) {
				for (int coun = 0; coun < 7; coun++) {
					if (report.get(mon).get(country[coun]) != null) {
						System.out.print(report.get(mon).get(country[coun]) + "\t");
					}
				}
			} else {
				System.out.print("   \t");
			}
			report.get(mon).entrySet().stream()
			.sorted(new Comparator<Map.Entry<String, Long>>() {
				
				//@Override
				public int compare(Entry<String, Long> o1, Entry<String, Long> o2) {
					return (int)(o2.getValue() - o1.getValue());
				}
			})
			.limit(1)
			.forEach( (s) -> System.out.print(s.getKey()) ); //맵을 리턴
			System.out.println();
		}
	}

}
