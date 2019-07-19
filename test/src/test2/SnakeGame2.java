package test2;

import java.util.Scanner;

public class SnakeGame2 {

   public static String[][] snakeBoard = new String[17][17];
   public static Board1[] snake = new Board1[5];
   
   public static void main(String[] args) {
	   
	   //스네이크게임보드 만들기
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
      
	   //스네이크와 먹이 위치 선정//
	   //스네이크 머리
	   int x1 = (int)(Math.random()*9) + 2; 
	   int y1 = (int)(Math.random()*14) + 2;
	   //먹이
	   int x2 = compareRandomNum(x1);
	   int y2 = compareRandomNum(y1);
	   snakeBoard[x2][y2] = "x";
	   snakeBoard[x1][y1] = "Q";
	   for (int i = 1; i < snake.length; i++) {
		   snakeBoard[x1+i][y1] = "o";
	   }

	   for (int i = 0; i < snake.length; i++) {
		  snake[i] = new Board1(x1+i, y1);
	   }
	   
	   for (int i = 0; i < snakeBoard.length; i++) {
		   for (int j = 0; j < snakeBoard.length; j++) {
			   System.out.printf("%2s", snakeBoard[i][j]);
		   }
		   System.out.println();
	   }

	   moveSnake(x1, y1);

   }

   
   
   
   
   //뱀 움직이는 부분
   public static void moveSnake(int x, int y) {

	   System.out.print("움직일 방향의 키를 입력해주세요. (W:상|S:하|A:좌|D:우) : ");
	   Scanner sc = new Scanner(System.in);
	   boolean checkGameOver = true;
	   
	   switch (sc.next()) {
	   case "w":
		   if (snakeBoard[x-1][y].equals("──")) {
			   System.out.println("\nGame Over");
			   checkGameOver = false;
			   break;
//			   if (snakeBoard[x-1][y].equals(" ")) {
//			   snakeBoard[x-1][y] = snakeBoard[snake[0].x][snake[0].y];
//			   change(snakeBoard, snake);
//			   snake[0].x = x-1;
//			   snake[0].y = y;
		   } else {
			   snakeBoard[x-1][y] = snakeBoard[snake[0].x][snake[0].y];
			   change(snakeBoard, snake);
			   snake[0].x = x-1;
			   snake[0].y = y;
//			   if (snakeBoard[x-1][y].equals("──")) {
//			   System.out.println("\nGame Over");
//			   checkGameOver = false;
//			   break;
		   }
		   x--;
		   break;
		   
	   case "s":
		   if (snakeBoard[x+1][y].equals(" ")) {
			   snakeBoard[x+1][y] = snakeBoard[snake[0].x][snake[0].y];
			   change(snakeBoard, snake);
			   snake[0].x = x+1;
			   snake[0].y = y;
		   } else if (snakeBoard[x+1][y].equals("──")) {
			   System.out.println("\nGame Over");
			   checkGameOver = false;
			   break;
		   }
		   x++;
		   break;

	   case "a":
		   if (snakeBoard[x][y-1].equals(" ")) {
			   snakeBoard[x][y-1] = snakeBoard[snake[0].x][snake[0].y];
			   change(snakeBoard, snake);
			   snake[0].x = x;
			   snake[0].y = y-1;
		   } else if (snakeBoard[x][y-1].equals("│")) {
			   System.out.println("\nGame Over");
			   checkGameOver = false;
			   break;
		   }
		   y--;
		   break;

	   case "d":
		   if (snakeBoard[x][y+1].equals(" ")) {
			   snakeBoard[x][y+1] = snakeBoard[snake[0].x][snake[0].y];
			   change(snakeBoard, snake);
			   snake[0].x = x;
			   snake[0].y = y+1;
		   } else if (snakeBoard[x][y+1].equals("│")) {
			   System.out.println("\nGame Over");
			   checkGameOver = false;
			   break;
		   }
		   y++;
		   break;
	   }
	   
	   //결과 뿌리기
	   if (checkGameOver) {
		   for (int i = 0; i < snakeBoard.length; i++) {
			   for (int j = 0; j < snakeBoard.length; j++) {
				   System.out.printf("%2s", snakeBoard[i][j]);
			   }
			   System.out.println();
		   }
		   moveSnake(x, y);
	   }
	   
   }
   
   //중복 랜덤 판별
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

   //위치 바꾸는 메소드
   public static void change(String[][] snakeBoard, Board1[] snake) {
	   String tmp = " ";
	   //실제 값 바꾸기
	   for (int i = 0; i < snake.length-1; i++) {
		   snakeBoard[snake[i].x][snake[i].y] = snakeBoard[snake[i+1].x][snake[i+1].y];
	   }
	   snakeBoard[snake[snake.length-1].x][snake[snake.length-1].y] = tmp;
	   
	   //좌표 바꾸기
	   for (int i = snake.length-1; i > 0; i--) {
		   snake[i].x = snake[i-1].x;
		   snake[i].y = snake[i-1].y;
	   }
	   
   }
}

//보드 클래스
class Board1 {
	int x;
	int y;

	public Board1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}