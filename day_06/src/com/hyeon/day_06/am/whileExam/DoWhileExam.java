package com.hyeon.day_06.am.whileExam;

public class DoWhileExam {

	public static void main(String[] args) {

		boolean hasRun = false;
		
		while (hasRun) {
			System.out.println("이건 실행 안되지롱");
		}
		
		do { //반드시 한번은 실행해야할때 씀
			System.out.println("이건 실행 되지롱"); //while과의 차이는 순서의 차이이다.
		} while (hasRun);
		
	}

}
