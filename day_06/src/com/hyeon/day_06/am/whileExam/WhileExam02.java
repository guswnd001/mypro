package com.hyeon.day_06.am.whileExam;

public class WhileExam02 {

	public static void main(String[] args) {
		
		int cnt = 0;
		while (cnt <= 6) { 
			cnt++;
			System.out.println("밥은 먹고 다니냐");
		}
		System.out.println(cnt);
		System.out.println("수고 했어"); //조건이 true여서 무한루프에 빠지게 되기 때문에 에러가 난다.
	}

}
