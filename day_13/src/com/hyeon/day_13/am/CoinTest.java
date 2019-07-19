package com.hyeon.day_13.am;

public class CoinTest {

	public static void main(String[] args) {
		
		Coin1 coin1 = new Coin1();
		Coin1 coin2 = new Coin1();
		
		int cnt1 = 0;
		int cnt2 = 0;
		
		while (true) {
			
			coin1.flip();
			coin2.flip();
			System.out.println(coin1.side + " : " +coin2.side);
			
			if(coin1.side.equals("<앞면>100원     ") ) {
				cnt1 += 1;
			} else {
				cnt1 = 0;
			}
			
			if (coin2.side.equals("<앞면>100원     ")) {
				cnt2 += 1;
			} else {
				cnt2 = 0;
			} 
			
			if (cnt1 == 3) {
				System.out.println("첫번째 동전 승!");
				break;
			} else if (cnt2 == 3) {
				System.out.println("두번째 동전 승!");
				break;
			}
		}
		
		System.out.println("===============================");
		
		MyPoint p = new MyPoint(1, 1);
		System.out.println(p.getDistance(2, 2));
		
	
	}

}
class Coin1 {
	
	String side;
	
	public void flip() {
		int setNum = (int)(Math.random()*2);
		if (setNum == 0) {
			side = "<앞면>100원     ";
		} else {
			side = "<뒷면>이순신장군";
		}
	}
	
}

/* width, height, 
 *  kind, num
 *  k, n, card
 */

class MyPoint {
	int x;
	int y;
	
	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double getDistance(int a, int b) {
		
		int x2 = (a-x) * (a-x);
		int y2 = (b-y) * (b-y);
		
		double length = Math.sqrt(x2 + y2);
		
		return Math.round(length*100)/100.0;
	}
	
	
}




















