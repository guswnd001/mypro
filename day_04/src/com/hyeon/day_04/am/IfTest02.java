package com.hyeon.day_04.am;

public class IfTest02 {

	public static void main(String[] args) {
		
		int korScore = 58;
		String hakjum = ""; 
//		String hakjum = "가"; 너무너무 중요!!!!! 이렇게 생각하면 if문 하나를 줄일 수 있다.
		
		if (korScore < 101 && korScore >= 90) {
			hakjum = "수";
		} else if(korScore >= 80) {
			hakjum = "우";
		} else if(korScore >= 70) {
			hakjum = "미";
		} else if(korScore >= 60) {
			hakjum = "양";
		} else{
			hakjum = "가";
	}
		
		System.out.println("내 국어 점수는 " + korScore + "\n내 학점은 " + hakjum);
	}

}

// 문제점
// 1. 초기값을 주지 않아서 1개의 if절이 더 생겼다.
// 2. 5단계 평가에서 9단계 평가로 바뀐다면?
// 	    => 배열과 반복문으로 해결 가능 하다. 독립된 메서드, 클래스로 분리.
