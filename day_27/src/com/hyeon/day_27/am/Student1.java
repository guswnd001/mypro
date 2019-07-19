package com.hyeon.day_27.am;

public class Student1 {
	private String name;
	private String sex;
	private int score;
	
	public Student1(String name, String sex, int score) {
		this.name = name;
		this.sex = sex;
		this.score = score;
	}
	
	public String getSex() { return sex; }
	public int getScore() { return score; }

	@Override
	public String toString() {
		return "Student1 [name=" + name + ", sex=" + sex + ", score=" + score + "]";
	}
	
}
