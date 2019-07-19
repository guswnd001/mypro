package com.hyeon.day_33.am;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByExample {

	public static void main(String[] args) {
		List<Student> totalList = Arrays.asList(
				new Student("김현중", 10, Student.Sex.MALE, Student.City.Seoul),
				new Student("조혜빈", 6, Student.Sex.FEMALE, Student.City.Busan),
				new Student("이승주", 10, Student.Sex.MALE, Student.City.Busan),
				new Student("허가영", 6, Student.Sex.FEMALE, Student.City.Seoul) );
		
		Map<Student.Sex, List<Student>> mapBySex = totalList.stream()
				.collect(Collectors.groupingBy(Student :: getSex));
		
		System.out.print("[남학생] ");
		mapBySex.get(Student.Sex.MALE).stream()
			.forEach(s -> System.out.print(s.getName() + " "));
		
		System.out.print("\n[여학생] ");
		mapBySex.get(Student.Sex.FEMALE).stream()
			.forEach(s -> System.out.print(s.getName() + " "));
		
		System.out.println();
		
		Map<Student.City, List<String>> mapByCity = totalList.stream()
				.collect(
						Collectors.groupingBy(
								Student :: getCity, 
								Collectors.mapping(Student :: getName, Collectors.toList())
						)
				);
		
		System.out.print("\n[서울] ");
		mapByCity.get(Student.City.Seoul).stream()
			.forEach(s -> System.out.print(s + " "));
		
		System.out.print("\n[부산] ");
		mapByCity.get(Student.City.Busan).stream()
		.forEach(s -> System.out.print(s + " "));
		
	}

}
