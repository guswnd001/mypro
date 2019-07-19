package com.hyeon.day_15.am;

public class SandClock01 {

	public static void main(String[] args) {
		
		sandClockOut();
		
		
	}

	public static void sandClockOut() {
		

		//int num = (int)(Math.random()*14)+2;
		int oddNum = 7; 
		int halfNum = oddNum/2; //가운데 기준이 될 수
		int data = 0; //배열안에 들어갈 숫자값
		String[][] sandArr = new String[oddNum][];
		System.out.println("모래지계를 만들 무작위 홀수 : " + oddNum); 
		System.out.println();
		//모래시계 모양 배열 생성
		for (int row = 0; row < halfNum; row++) {
			sandArr[row] = new String[oddNum - row];
		}
		for (int row = halfNum; row < sandArr.length; row++) {
			sandArr[row] = new String[row + 1];
		}
		//배열에 모래시계 모양으로 숫자 초기화
		for (int row = sandArr.length-1; row > halfNum-1; row--) {
			for (int col = sandArr[row].length-1; col > sandArr.length-row-2; col--) {
				sandArr[row][col] =  ++data + "";
			}
			for (int col = 0; col < sandArr.length - 1 - row; col++) {
				sandArr[row][col] = " ";
			}
		}
		for (int row = halfNum-1; row > -1; row--) {
			for (int col = sandArr[row].length - 1; col > row-1; col--) {
				sandArr[row][col] =  ++data + "";
			}
			for (int col = 0; col < row; col++) {
				sandArr[row][col] = " ";
			}
		}
		//모래시계 배열 출력
		for (int row = 0; row < sandArr.length; row++) {
			for (int col = 0; col < sandArr[row].length; col++) {
				System.out.print("\t" + sandArr[row][col]);
			}
			System.out.println();
		}
		
		
	}
	
}
