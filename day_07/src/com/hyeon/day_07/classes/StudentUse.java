package com.hyeon.day_07.classes;

import java.util.Scanner;

public class StudentUse {

	public static void main(String[] args) {
		// 학생 김현중에 대한 성적을 처리하기
//		Student std01 = new Student();
//		std01.iName = getStudent("이름");
//		std01.stCode = getStudent("학번");
//		std01.kor = getScore("국어");
//		std01.eng = getScore("영어");
//		std01.mat = getScore("수학");
//		int totalScore = std01.sum();
//		std01.studentInfo();
		
		//학생 하현지에 대한 성적을 처리하기
		Student std02 = new Student("하현지", "3181", 100, 100 ,100); 
		Student std03 = new Student("하현지", "3181", 100, 100 ,100); 
		//엑셀이나 DB에 들어있는 자료를 가져와서 사용한다.
//		std02.studentInfo();
		
		System.out.println(std02.equals(std03));
		
		
	}
	
	public static String getStudent(String aaa) {
		System.out.println(aaa + "을 입력해주세요");
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	public static int getScore(String bbb) {
		System.out.println(bbb + "점수를 입력해주세요");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

}
