package com.hyeon.day_15.am;

public class SandClock {

	public static void main(String[] args) {
		
		sandClockOut();
		
		
	}

	public static void sandClockOut() {
		

		int num = 4;//(int)(Math.random()*14)+2;
		int oddNum = num*2 - 1; //3부터 30아래의 무작위 홀수 
		int halfNum = num; //가운데 기준이 될 수
		int data = 0;
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
		for (int row = 0; row < halfNum; row++) {
			for (int col = 0; col < row; col++) {
				sandArr[row][col] = " ";
			}
			for (int col = row; col < sandArr[row].length; col++) {
				sandArr[row][col] =  ++data + "";
			}
		}
		
		for (int row = halfNum; row < sandArr.length; row++) {
			for (int col = 0; col < sandArr.length - 1 - row; col++) {
				sandArr[row][col] = " ";
			}
			for (int col = sandArr.length - 1 - row; col < sandArr[row].length; col++) {
				sandArr[row][col] =  ++data + "";
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
