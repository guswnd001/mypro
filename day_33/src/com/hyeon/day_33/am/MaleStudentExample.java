package com.hyeon.day_33.am;

import java.util.Arrays;
import java.util.List;

public class MaleStudentExample {

	public static void main(String[] args) {
		List<Student> totalList = Arrays.asList( 
				new Student("김현중", 10, Student.Sex.MALE),
				new Student("조혜빈", 6, Student.Sex.FEMALE),
				new Student("이승주", 10, Student.Sex.MALE),
				new Student("허가영", 6, Student.Sex.FEMALE) );
		
		MaleStudent maleStudent = totalList.stream()
				.filter( s -> s.getSex() == Student.Sex.MALE).parallel()
				.collect( () -> new MaleStudent(), (r, t) -> r.accumulates(t), (r1, r2) -> r1.combine(r2) );
				//3번째 람다식을 쓰려면 collect전에 parallel()을 써야한다.
		maleStudent.getList().stream()
			.forEach( s -> System.out.println(s.getName()) );
	}

}
