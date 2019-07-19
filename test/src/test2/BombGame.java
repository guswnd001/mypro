package test2;

import java.util.Scanner;

public class BombGame {

	public static void main(String[] args) {
		
		String[][] bombArr = new String[12][12];
		
		//bombArr 제작
		for (int i = 0; i < bombArr.length; i++) {
			for (int j = 0; j < bombArr.length; j++) {
				int randNum = (int)(Math.random()*2); //0과 1중 랜덤으로 수를 뽑는다.
				if (j == 11) { bombArr[i][j] = " "; }
				else if (i == 0) { bombArr[i][j] = j-1 +""; }
				else if (i == 11) { bombArr[i][j] = " "; }
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
		System.out.println("폭탄의 좌표를 입력해주세요.");
		Scanner sc = new Scanner(System.in);
		System.out.print("x좌표 : ");
		int row = sc.nextInt() + 1;
		while (row <= 0 || row > 10) {
			System.out.println("다시 입력해주세요");
			row = sc.nextInt() + 1; 
		}
		System.out.print("y좌표 : ");
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
	
	//폭탄 터뜨리기 메소드
	public static void bombAttack(String[][] bombArr, int x, int y) {
		
		int xUp = x, xDown = x, xLeft = x, xRight = x;
		int yUp = y, yDown = y, yLeft = y, yRight = y;
		String pattern = bombArr[x][y];
		
		//오른쪽 탐색
		if (pattern == bombArr[xRight][yRight+1]) {
			bombArr[xRight][yRight] = " ";
			yRight++;
			bombAttack(bombArr, xRight, yRight);
		} else if (pattern != bombArr[xRight][yRight+1]) {
			bombArr[xRight][yRight] = " ";
		}
		//왼쪽 탐색
		if (pattern == bombArr[xLeft][yLeft-1]) {
			bombArr[xLeft][yLeft] = " ";
			yLeft--;
			bombAttack(bombArr, xLeft, yLeft);
		} else if (pattern != bombArr[xLeft][yLeft-1]) {
			bombArr[xLeft][yLeft] = " ";
		}
		//위쪽 탐색
		if (pattern == bombArr[xUp-1][yUp]) {
			bombArr[xUp][yUp] = " ";
			xUp--;
			bombAttack(bombArr, xUp, yUp);
		} else if (pattern != bombArr[xUp-1][yUp]) {
			bombArr[xUp][yUp] = " ";
		}
		//아래쪽 탐색
		if (pattern == bombArr[xDown+1][yDown]) {
			bombArr[xDown][yDown] = " ";
			xDown++;
			bombAttack(bombArr, xDown, yDown);
		} else if (pattern != bombArr[xDown+1][yDown]) {
			bombArr[xDown][yDown] = " ";
		}

	}

	
}













