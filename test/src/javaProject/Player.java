package javaProject;

import java.util.List;
import java.util.Vector;

public class Player {
	String name;
	List<Card> card = null;

	public Player(String name, Card c1, Card c2) {
		this.name = name;
		card = new Vector<Card>();
		card.add(c1);
		card.add(c2);
	}
	
	public int getSum(List<Card> card) {

        int i = 0;
        int sum = 0;
        int aceCount = 0;
        // A= 1 or 11, JQK= 10
        // A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K
        for (i = 0; i < card.size(); i++) {
        	if (card.get(i).getNumber() > 10) { //J, Q, K일 경우 10으로 더한다.
				sum += 10;
			} else { //나머지는 그대로 더한다.
				sum += card.get(i).getNumber();
			}
            if (card.get(i).getNumber() == 1) { //A의 개수를 저장한다.
                aceCount++;
            }
        }
        
        //받은 카드 중에 A가 있을 경우
        for (i = 0; i < aceCount; i++) {
            //합이 11이하일 경우 A를 11로 생각해 점수에 더한다.
        	if (sum <= 11) {
                sum += 10;
                aceCount--;
            }
        }
        return sum;
    }
	
}
