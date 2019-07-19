package com.hyeon.day_27.am;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionExample1 {
	private static List<Student> list = Arrays.asList(
			new Student("김현중", 90, 96),
			new Student("이승주", 95, 93)
			);
	
	public static void printString(Function<Student, String> function) {
		// Function<T, R> apply(T) { t -> return t.getName(); };
		for (Student student : list) {
			System.out.print(function.apply(student) + " ");
		}
		System.out.println();
	}
	
	public static void printInt(ToIntFunction<Student> function) {
		// ToIntFunction<T> Integer applyAsInt(T) { t -> return t.getEnglishScore(); };
		for (Student student : list) {
			System.out.print(function.applyAsInt(student) + " ");
		}
		System.out.println();
	}
	
	//메인 메소드
	public static void main(String[] args) {
		System.out.println("[학생 이름]");
		printString(t -> t.getName());
		
		System.out.println("[영어 점수]");
		printInt(t -> t.getEnglishScore());
		
		System.out.println("[수학 점수]");
		printInt(t -> t.getMathScore());
	}

}

class Student {
	private String name;
	private int englishScore;
	private int mathScore;
	
	public Student(String name, int englishScore, int mathScore) {
		this.name = name;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}

	public String getName() { return name; }

	public int getEnglishScore() { return englishScore; }

	public int getMathScore() { return mathScore; }
	
	
}