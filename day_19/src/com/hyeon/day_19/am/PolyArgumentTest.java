package com.hyeon.day_19.am;

import java.util.Vector;

class Product {
	int price;
	int bonusPoint;
	
	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
	
	public String toString() { return "Product"; }
	
}

interface Repairable {
	
}

interface Gift {
	
}

class Tv extends Product implements Repairable, Gift{
	
	Tv() { super(100); }
	
	public String toString() { return "TV"; }
	
}

class Computer extends Product implements Repairable, Gift{
	
	Computer() { super(200); }
	
	public String toString() { return "Computer"; }
	
}

class Audio extends Product implements Gift{
	
	Audio() { super(50); }
	
	public String toString() { return "Audio"; }
	
}

class Buyer {
	
	int money = 1000;
	int bonusPoint = 0;
	int index = 0;
	//Product[] item = new Product[10];
	Vector item = new Vector(); 
	
	void buy(Product p) { //파라미터로 Object가 들어올 수 있지만 price멤버가 없어서 계산은 불가능하다.
		if (money < p.price) {
			System.out.println("잔액 부족");
			return; //if조건에 맞을때 아래 수식을 하지 않기 위해 리턴을 붙인다.
			//더이상 메소드를 진행하지 말고 나가라는 뜻이다.
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		//item[index++] = p;
		item.add(p); //add의 파라미터는 Object로 모든 클래스를 파라미터로 받을 수 있다.
		System.out.println(p + "을/를 구입하셨습니다.");
	}
	
	void print() {
		int sum = 0;
		String itemList = "";
		
		for (Object p : item) {
			Product np = (Product)p;
			if (np == null) { break; }
			sum += np.price;
			itemList += np + ", ";
		}
		System.out.println("합계 : " + sum);
		System.out.println(itemList);
	}
	
	void refund(Product p) {
		if (item.remove(p)) {
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p + "반품");
		} else {
			System.out.println("반품할 제품이 없습니다.");
		}
	}
	
	void repair(Repairable r) {
		System.out.println(r + "수리했습니다.");
	}
	
	void gift(Gift g) {
		System.out.println("선물입니다.");
	}
	
}

class PolyArgumentTest {
	public static void main(String[] args) {
		
		Buyer b = new Buyer();
		Tv t = new Tv();
		Computer c = new Computer();
		Audio a = new Audio();
		
		b.buy(t);
		b.buy(c);
		b.buy(a);
		
		System.out.println();
		System.out.println("현재 남은 돈 : " + b.money);
		System.out.println("현재 보너스포인트 : " + b.bonusPoint);
		
		System.out.println();
		b.print();
		
		System.out.println();
		b.refund(c);
		System.out.println("현재 남은 돈 : " + b.money);
		System.out.println("현재 보너스포인트 : " + b.bonusPoint);
		
		System.out.println();
		b.repair(c);
		b.repair(t);
		//b.repair(a);
		
		System.out.println();
		b.gift(a);
		b.gift(t);
		b.gift(c);
		
	}
}














