package com.hyeon.day_04.am;

import java.lang.invoke.SwitchPoint;

public class IfTest0203 {

	public static void main(String[] args) {
		
		int korScore = 100; //점수를 입력받는다고 가정 => 전제조건 유효한 값이 입력되었다는 것.
		String hakjum = "가";
		int switchValue = korScore / 10; // 0~10
		
		switch (switchValue) {
			case 10 :
			case 9 : hakjum = "수"; break; //switch문을 탈출해서 다음 문장을 수행해라.
			case 8 : hakjum = "우"; break;
			case 7 : hakjum = "미"; break;
			case 6 : hakjum = "양"; break;
			//default: hakjum = "가"; break; 초기값을 미리 초기화한다면 생략가능 하다. 
		} //switch문의 끝
		
		System.out.println("내 국어 점수는 " + korScore + "\n내 학점은 " + hakjum);
	}

}

// 문제점
// 1. 초기값을 주지 않아서 1개의 if절이 더 생겼다.
// 2. 5단계 평가에서 9단계 평가로 바뀐다면?
// 	    => 배열과 반복문으로 해결 가능 하다. 독립된 메서드, 클래스로 분리.
