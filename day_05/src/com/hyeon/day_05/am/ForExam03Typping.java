package com.hyeon.day_05.am;

import java.util.Scanner;

public class ForExam03Typping {

	public static void main(String[] args) {

		String words = "한번 더 나에게 질풍같은 용기를 " + "거친 파도에도 굴하지 않게"; //선택된 파일
		String[] wordArr = words.split(" "); //문장을  공백으로 나누어 배열로 저장, 정규표현식을 이용하여 white space를 지정(복수개)
		int wordCnt = wordArr.length; //배열(단어)의 개수를 파악
		int trueCnt = 0; //맞은 개수를 셀 변수
		String prtWrd = ""; //파일에서 출력될 변수
		String testWrd = ""; //내가 타자칠 변수
		Scanner scan = new Scanner(System.in); //키보드로 입력받을 준비
		
		for (int i = 0; i < 3; i = i + 1) {
			int ranNum = (int)(Math.random() * wordCnt); //단어 중에서 임의의 수를 만들어 낸다. Math.random은 0과 1사이의 무작위의 수 
			prtWrd = wordArr[ranNum];
			System.out.println("연습할 단어 : " + prtWrd);
			testWrd = scan.next();
			
			if (testWrd.equals(wordArr[ranNum])) {
				trueCnt = trueCnt + 1;
			}
		}
		System.out.println("맞은 개수는 : " + trueCnt);
	}

}
