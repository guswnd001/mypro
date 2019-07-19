package test2;

import java.util.Scanner;

public class SnakeGame {
	public static String[][] snakeBoard = new String[17][17];
	static String[] snakeParts = {"Q", "1", "2"};
	
	public static void main(String[] args) {
		
		
		for (int i = 0; i < snakeBoard.length; i++) {
			for (int j = 0; j < snakeBoard[i].length; j++) {
				if (i == 0 || i == 16) { snakeBoard[i][j] = "──"; }
				else if (j == 0 || j == 16) { snakeBoard[i][j] = "│"; }
				else { snakeBoard[i][j] = " "; }
				snakeBoard[0][0] = "┌";
				snakeBoard[0][16] = "─┐";
				snakeBoard[16][0] = "└";
				snakeBoard[16][16] = "─┘";
			}
		}
		
		int x1 = (int)(Math.random()*10) + 1;
		int y1 = (int)(Math.random()*15) + 1;
		int x2 = compareRandomNum(x1);
		int y2 = compareRandomNum(y1);
		snakeBoard[x2][y2] = "x"; //먹이
		
		for (int i = 0; i < 3; i++) {
				snakeBoard[x1+i][y1] = snakeParts[i];
		}
		
		for (int i = 0; i < snakeBoard.length; i++) {
			for (int j = 0; j < snakeBoard.length; j++) {
				System.out.printf("%2s", snakeBoard[i][j]);
			}
			System.out.println();
		}
		
		moveSnake(x1, y1);
		
	}
	
	
	public static void moveSnake(int x, int y) {
		
		System.out.print("움직일 방향의 키를 입력해주세요. (W:상|S:하|A:좌|D:우) : ");
		Scanner sc = new Scanner(System.in);
		String tmpHead = " ";
		String tmpTail = "";
		String tmp;
		
		switch (sc.next()) {
		case "w":
			tmp = snakeBoard[x-1][y];
			for (int i = 0; i < snakeParts.length; i++) {
				snakeBoard[(x-1)+i][y] = snakeParts[i];
			}
			snakeBoard[x+2][y] = tmp;
			x--;
			break;

		case "s":
			tmpHead = snakeBoard[x][y];
			snakeBoard[x][y] = snakeBoard[x+1][y];
			snakeBoard[x+1][y] = tmpHead;
			x++;
			break;
			
		case "a":
			snakeBoard[x][y-1] = snakeParts[0];
			snakeBoard[x][y] = snakeParts[2];
			snakeBoard[x+2][y] = " "; 
			y--;
			break;
			
		case "d":
			tmpHead = snakeBoard[x][y];
			snakeBoard[x][y] = snakeBoard[x][y+1];
			snakeBoard[x][y+1] = tmpHead;
			y++;
			break;
		}
		
		for (int i = 0; i < snakeBoard.length; i++) {
			for (int j = 0; j < snakeBoard.length; j++) {
				System.out.printf("%2s", snakeBoard[i][j]);
			}
			System.out.println();
		}
		
		moveSnake(x, y);
		
	}
	
	public static int compareRandomNum(int i) {
		boolean run = true;
		int x = (int)(Math.random()*10) + 1;
		while (run) {
			if (i != x) {
				run = false;
			} else {
				x = (int)(Math.random()*10) + 1;
			}
		}
		return x;
	}
	
//	public static int[] follow(int x, int y) {
//		
//	}

}
