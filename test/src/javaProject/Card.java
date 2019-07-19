package javaProject;

public class Card {
	// spade 1, diamond 2, heart 3, clover 4
	int kind;
	int number;

	Card() {
		this(1, 1);
	}

	Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}

	public int getNumber() { //카드의 숫자를 가져온다.
		return number;
	}

	public String toString() { //카드 출력시 보여줄 문구.
		String[] kinds = { " ", "♠", "◆", "♥", "♣" };
		String numbers = "0A23456789xJQK";
		String line = "card: " + kinds[this.kind] + ", ";

		if (numbers.charAt(this.number) == 'x') {
			line += 10;
		} else {
			line = line + numbers.charAt(number);
		}
		return line;
	}
}
