package test2;

import java.util.Scanner;

public class SnakeGame1 {

	public static Board[][] snakeBoard = new Board[17][17];
	//static Board[] snake = new Board[3];
	static Board[] snake = new Board[3];
	
	public static void main(String[] args) {
		
		for (int i = 0; i < snakeBoard.length; i++) {
			for (int j = 0; j < snakeBoard.length; j++) {
				if (i == 0 || i == 16) {
					snakeBoard[i][j] = new Board(i, j, "──");
				} else if (j == 0 || j == 16) {
					snakeBoard[i][j] = new Board(i, j, "│");
				} else {
					snakeBoard[i][j] = new Board(i, j, " ");
				}
				snakeBoard[0][0] = new Board(i, j, "┌");
				snakeBoard[0][16] = new Board(i, j, "─┐");
				snakeBoard[16][0] = new Board(i, j, "└");
				snakeBoard[16][16] = new Board(i, j, "─┘");
			}
		}
		
		int x1 = (int)(Math.random()*9) + 2;
		int y1 = (int)(Math.random()*14) + 2;
		int x2 = compareRandomNum(x1);
		int y2 = compareRandomNum(y1);
		snakeBoard[x2][y2].s = "x"; //먹이
		snakeBoard[x1][y1].s = "Q";
		snakeBoard[x1+1][y1].s = "1";
		snakeBoard[x1+2][y1].s = "2";
		
		for (int i = 0; i < snake.length; i++) {
			snake[i] = snakeBoard[x1+i][y1];
		}
		
		for (int i = 0; i < snakeBoard.length; i++) {
			for (int j = 0; j < snakeBoard.length; j++) {
				System.out.printf("%2s", snakeBoard[i][j].s);
			}
			System.out.println();
		}
		
		moveSnake(x1, y1);
		
	}
	
	public static void moveSnake(int x, int y) {

		System.out.print("움직일 방향의 키를 입력해주세요. (W:상|S:하|A:좌|D:우) : ");
		Scanner sc = new Scanner(System.in);
		//String tmpHead = " ";
		//String tmpTail = "";
		String tmp = " ";
		for (int i = 0; i < snake.length; i++) {
			snake[i] = snakeBoard[x+i][y];
		}

		switch (sc.next()) {
		
		case "w":
//			tmp = snakeBoard[x-1][y].s;
//			snakeBoard[x-1][y].s = snake[0].s;
//			snakeBoard[snake[0].x][snake[0].y].s = snake[1].s;
//			snakeBoard[snake[1].x][snake[1].y].s = snake[2].s;
//			snakeBoard[snake[2].x][snake[2].y].s = tmp;
//			snake[0].x--;
//			snake[1].x--;
//			snake[2].x--;
//			x--;
			for (int i = 0; i < snake.length; i++) {
				snakeBoard[x-1+i][y] = snake[i];
			}
			snakeBoard[x+3][y].s = tmp;
			x--;
			break;
		case "s":
			
			break;

		case "a":
			tmp = snakeBoard[x][y-1].s;
			snakeBoard[x][y-1].s = snake[0].s;
			snakeBoard[snake[0].x][snake[0].y].s = snake[1].s;
			snakeBoard[snake[1].x][snake[1].y].s = snake[2].s;
			snakeBoard[snake[2].x][snake[2].y].s = tmp;
			y--;
			break;

		case "d":
			
			break;
		}

		for (int i = 0; i < snakeBoard.length; i++) {
			for (int j = 0; j < snakeBoard.length; j++) {
				System.out.printf("%2s", snakeBoard[i][j].s);
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
}

class Board {
	int x;
	int y;
	String s;
	
	public Board(int x, int y, String s) {
		this.x = x;
		this.y = y;
		this.s = s;
	}
}
