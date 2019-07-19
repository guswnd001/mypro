package com.hyeon.day_06.am.whileExam;

public class WhileExam01 {

	public static void main(String[] args) {
		
		int cnt = 0;
		while (true) { //무한 루프에 빠질 위험이 크다.
			cnt++;
			if (cnt > 6) break;
			System.out.println("밥은 먹고 다니냐");
		}
		System.out.println(cnt);
		System.out.println("수고 했어"); //조건이 true여서 무한루프에 빠지게 되기 때문에 에러가 난다.
	}

}
