package com.hyeon.day_07.stringClassExam;

public class FindWordCount {

	public static void main(String[] args) {
		
		String sourceState = "금이빨이 몇개냐 " + "나 전당포한다" + "금이빨 모조리 다 씹어먹어줄게";
		//sourceState에 저장된 문자열 중에서 금이빨이라는 단어가 몇 번 쓰였는지를 처리하는 프로그램을 작성하시오.
		
		int wordCnt = 0;
		int startPosition = 0;
		int searchPosition;
		String[] findWord = {"금이빨", "전당포"}; //찾고자하는 단어는 set컬렉션을 이용한다.
			
		for (int i = 0; i < findWord.length; i++) { //while문과 Integer조건을 이용한다.
			while ((searchPosition = sourceState.indexOf(findWord[i], startPosition)) != -1) {
				wordCnt += 1;
				startPosition = searchPosition +1;
			}
			
			System.out.println(findWord[i] + "의 개수 = " + wordCnt);
			startPosition = 0;
			wordCnt = 0;
		}

		//System.out.println((sourceState.indexOf("금이빨") == -1)? (wordCnt += 0):(wordCnt += 1));
		
		//System.out.println(sourceState.indexOf("금이빨"));
		//System.out.println("금이빨의 개수 = " + wordCnt);
	}

}
