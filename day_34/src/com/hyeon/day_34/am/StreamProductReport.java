package com.hyeon.day_34.am;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamProductReport {

	public static void main(String[] args) throws FileNotFoundException{
		Path path = Paths.get("c:\\tmp\\streamtest01.txt");
		File file = path.toFile();
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		
		
		String carName = "아반떼";
		
		Stream<Product> sp = br.lines().parallel()
					.map( (s) -> {
						String[] str = s.split(", ");
						String temp = "";
//						System.out.println(s);
						try { temp = str[4]; }
						catch (Exception e) { temp = ""; }
						
						return new Product(Integer.parseInt(str[0]), Integer.parseInt(str[1]),
									str[2], Integer.parseInt(str[3]), temp); } );
	
		Map<Integer, Map<Integer, Integer>> report
			= sp.filter( (s) -> { return s.getCar().equals(carName); } )
				.collect(Collectors.groupingBy(Product :: getMonth,
						Collectors.groupingBy(Product :: getCon,
					   Collectors.summingInt(Product :: getQty))));
		
		System.out.println("\t  생산\t  판매\t  반품\t  재고");
		System.out.println("==========================================");
		for (int mon = 1; mon < 13; mon++) {
			System.out.print(mon + "월:\t");
			if (report.get(mon) != null) {
				for (int con = 1; con < 4; con++) {
					if (report.get(mon).get(con) != null) {
						System.out.print(report.get(mon).get(con) + "\t");
					}
				}
			} else {
				System.out.print("   \t");
			}
			System.out.println();
		}
		
	}

}
