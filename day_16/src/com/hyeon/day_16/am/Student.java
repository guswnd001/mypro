package com.hyeon.day_16.am;

public class Student extends People {
	

	public int studentNo;
	
	public Student(String name, String ssn, int studentNo) {
		super(name, ssn);
		this.studentNo = studentNo;
	}
	
}
