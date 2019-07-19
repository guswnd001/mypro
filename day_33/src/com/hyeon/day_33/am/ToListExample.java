package com.hyeon.day_33.am;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ToListExample {

	public static void main(String[] args) {
		List<Student> totalList = Arrays.asList(
				new Student("김현중", 10, Student.Sex.MALE),
				new Student("조혜빈", 6, Student.Sex.FEMALE),
				new Student("이승주", 10, Student.Sex.MALE),
				new Student("허가영", 6, Student.Sex.FEMALE)
				);
		
		//남학생들만 묶어 List생성
		List<Student> maleList = totalList.stream()
										.filter( s -> s.getSex() == Student.Sex.MALE)
										.collect(Collectors.toList());
		maleList.stream()
				.forEach( s -> System.out.println(s.getName()) );
		
		System.out.println();
		
		//여학생만 묶어 HashSet생성
		Set<Student> femaleSet = totalList.stream()
										.filter( s -> s.getSex() == Student.Sex.FEMALE)
										//.collect(Collectors.toCollection(HashSet :: new));
										//.collect(Collectors.toCollection( () -> {return new HashSet<Student>();}) );
										.collect(Collectors.toCollection( () -> new HashSet<Student>()) );
										
		femaleSet.stream()
				.forEach( s -> System.out.println(s.getName()) );
		
	}

}
