package com.hyeon.day_19.pm;

public class CardTest {

	public static void main(String[] args) {
		
		Deck d = new Deck();
		Card c = d.pick(0);
		System.out.println(c);
		
		d.shuffle();
		c = d.pick(0);
		System.out.println(c);
		
	}

}

class Card {
	//spade 1, diamond 2, heart 3, clover 4
	int kind;
	int number;
	
	Card() {
		this(1, 1);
	}
	
	Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	
	public String toString() {
		String[] kinds = { " ", "spade", "diamond", "heart", "clover" };
		String numbers = "0A23456789xJQK";
		String line = "kinds: " + kinds[this.kind] + ", number";
		
		if (numbers.charAt(this.number) == 'x') {
			line += 10;
		} else {
			line = line + numbers.charAt(number);
		}
		return line;
	}
}

class Deck {
	Card[] cardArr = new Card[52];
	int index = 0;
	
	Deck() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <  14; j++) {
				cardArr[index] = new Card(i,j);
				index++;
			}
			
		}
	}
	
	public Card pick(int index) {
		return cardArr[index];  
	}
	
	public void shuffle() {
		for (int i = 0; i < 52; i++) {
			int r = (int)(Math.random()*52);
			Card tmp = cardArr[i];
			cardArr[i] = cardArr[r];
			cardArr[r] = tmp;
		}
		
	}
	
	
}
