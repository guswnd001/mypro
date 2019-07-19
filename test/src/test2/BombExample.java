package test2;

import java.util.Scanner;

public class BombExample {

	public static void main(String[] args) {
		
		String[][] bombArr = new String[11][11];
		
		//bombArr 제작
		for (int i = 0; i < bombArr.length; i++) {
			for (int j = 0; j < bombArr[i].length; j++) {
				
				int randNum = (int)(Math.random()*2); //0과 1중 랜덤으로 수를 뽑는다.
				
				if (i == 0) { bombArr[i][j] = j-1 +""; }
				else if (j == 0) { bombArr[i][j] = i-1 +""; }
				else if (randNum == 0){ //랜덤으로 배열에 모양을 할당한다.
					bombArr[i][j] = "□";
				} else {
					bombArr[i][j] = "■";
				}					
				bombArr[0][0] = " ";
				
				System.out.printf("%2s", bombArr[i][j]);
			}
			System.out.println();
		}
		
		//좌표 입력받기
		System.out.println("\n폭탄의 좌표를 입력해주세요.");
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt() + 1;
		while (row <= 0 || row > 10) {
			System.out.println("다시 입력해주세요");
			row = sc.nextInt() + 1; 
		}
		
		int col = sc.nextInt() + 1;
		while (col <= 0 || col > 10) {
			System.out.println("다시 입력해주세요");
			col = sc.nextInt() + 1; 
		}
		System.out.println(bombArr[row][col]);
		
		//주변에 있는 같은 모양 터뜨리기
		bombAttack(bombArr, row, col);
		
		//결과 출력
		System.out.println("==========================");
		for (int i = 0; i < bombArr.length; i++) {
			for (int j = 0; j < bombArr[i].length; j++) {
				System.out.printf("%2s", bombArr[i][j]);
			}
			System.out.println();
		}
		
		
	}
	
	public static void bombAttack(String[][] bombArr, int x, int y) {
		
		int xUp = x, xDown = x, xLeft = x, xRight = x;
		int yUp = y, yDown = y, yLeft = y, yRight = y;
		
			
		if (bombArr[xRight][yRight] == bombArr[xRight][yRight+1]) {
			bombArr[xRight][yRight] = " ";
			yRight++;
		} else {
			bombArr[xRight][yRight] = " ";
		}
		
		if (bombArr[xLeft][yLeft] == bombArr[xLeft][yLeft-1]) {
			bombArr[xLeft][yLeft] = " ";
			yLeft--;
		} else {
			bombArr[xLeft][yLeft] = " ";
		}
		
		if (bombArr[xUp][yUp] == bombArr[xUp+1][yUp]) {
			bombArr[xUp][yUp] = " ";
			xUp++;
		} else {
			bombArr[xUp][yUp] = " ";
		}
		
		if (bombArr[xDown][yDown] == bombArr[xDown-1][yDown]) {
			bombArr[xDown][yDown] = " ";
			xDown--;
		} else {
			bombArr[xDown][yDown] = " ";
		}
		
	}

	
}













