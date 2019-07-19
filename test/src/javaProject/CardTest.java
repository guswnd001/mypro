package javaProject;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class CardTest {
	
	public static void showCard(Player p, int size) {
		for (int i = 0; i < size; i++) {
			System.out.println(p.name + "의 " + p.card.get(i));
		}
	}

	public static void compareScore(Player p1, Player p2) {
		System.out.println(p1.name + "의 점수는 " + p1.getSum(p1.card));
		System.out.println(p2.name + "의 점수는 " + p2.getSum(p2.card));

//		if (p1.getSum() > 21 && p2.getSum() > 21) {
//			System.out.println("버스트 - 딜러가 이겼습니다.");
//		if (p1.getSum() <= 21 && p2.getSum() <= 21) {
		if (p1.getSum(p1.card) < p2.getSum(p2.card)) {
			System.out.println(p2.name + "(이)가 이겼습니다.");
		} else if (p1.getSum(p1.card) == p2.getSum(p2.card)) {
			System.out.println("무승부 입니다.");
		} else {
			System.out.println(p1.name + "(이)가 이겼습니다.");
		}
//		} 

	}

	// ***메인 메소드***
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deck d = new Deck();
		d.shuffle();
		Player dealer = new Player("딜러", d.pick(0), d.pick(1));
		Player player = new Player("플레이어", d.pick(2), d.pick(3));
		showCard(dealer, dealer.card.size());
		showCard(player, player.card.size());
		
		int dealerSum = dealer.getSum(dealer.card);
		int pickNum = 4;
		while (true) {
			System.out.println("선택해 주세요");
			System.out.print("[1: 카드추가, 2: 스탑 ]");
			int answer = sc.nextInt(); // 1: 카드추가, 2:스탑
			if (answer == 1) {
				player.card.add(d.pick(pickNum));
				pickNum++;
				if (dealerSum <= 16) {
					dealer.card.add(d.pick(pickNum));
					pickNum++;
				}
				showCard(dealer, dealer.card.size());
				showCard(player, player.card.size());
			} else if (answer == 2) {
				dealerSum = 0;
				System.out.println(dealer.card.size());
				System.out.println(player.card.size());
				compareScore(dealer, player);
				break;
			} else {
				
				System.out.print("다시 ");
			}
		}
		sc.close();
	}

}

	