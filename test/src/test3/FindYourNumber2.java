package test3;

import java.util.Scanner;

public class FindYourNumber2 {

	public static void main(String[] args) {

		int[][] numbers = { { 0, 1, 2, 3 }, { 4, 5, 6, 7 }, { 8, 9, 10, 11 }, { 12, 13, 14, 15 } };
		Scanner sc = new Scanner(System.in);
		String[] check = new String[2];
		int groupNumber = 0;
		int yourNumber = 0;

		System.out.println("0부터 15까지의 숫자 중 1개를 생각하세요.\n");

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(numbers[i][j] + ", ");
				System.out.print(numbers[i + 1][j] + ", ");
			}
			System.out.println("\n번호가 있으면 y 아니면 n을 입력하세요.");
			if (sc.next().equals("y")) { check[i] = "y"; } 
			else { check[i] = "n"; }
		}

		if (check[0].equals("y") && check[1].equals("y")) {
			groupNumber = 1;
		} else if (check[0].equals("y") && check[1].equals("n")) {
			groupNumber = 0;
		} else if (check[0].equals("n") && check[1].equals("y")) {
			groupNumber = 2;
		} else {
			groupNumber = 3;
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(numbers[i][j] + ", ");
			}
		}
		System.out.println("\n번호가 있으면 y 아니면 n을 입력하세요.");
		if (sc.next().equals("y")) {
			check[0] = "y";
		} else {
			check[0] = "n";
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j += 2) {
				System.out.print(numbers[i][j] + ", ");
			}
		}
		System.out.println("\n번호가 있으면 y 아니면 n을 입력하세요.");
		if (sc.next().equals("y")) {
			check[1] = "y";
		} else {
			check[1] = "n";
		}

		if (check[0].equals("y") && check[1].equals("y")) {
			yourNumber = numbers[groupNumber][0];
		} else if (check[0].equals("y") && check[1].equals("n")) {
			yourNumber = numbers[groupNumber][1];
		} else if (check[0].equals("n") && check[1].equals("y")) {
			yourNumber = numbers[groupNumber][2];
		} else {
			yourNumber = numbers[groupNumber][3];
		}

		System.out.println("당신이 생각한 수는: " + yourNumber);
	}

}
