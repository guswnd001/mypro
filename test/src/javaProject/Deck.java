package javaProject;

public class Deck {
	Card[] cardArr = new Card[52]; //52장의 카드
	int index = 0;

	Deck() {
		for (int i = 1; i <= 4; i++) { //카드 문양
			for (int j = 1; j < 14; j++) { //카드 숫자
				cardArr[index] = new Card(i, j);
				index++;
			}
		}
	}

	public Card pick(int index) {
		return cardArr[index];
	}

	public void shuffle() {
		for (int i = 0; i < 52; i++) {
			int r = (int) (Math.random() * 52);
			Card tmp = cardArr[i];
			cardArr[i] = cardArr[r];
			cardArr[r] = tmp;
		}
	}
}
