package com.hyeon.day_29.pm;

class Account {
	private int balance = 1000; //private로 해야 동기화가 의미가 있다.
	public int getBalance() {
		return balance;
	}
	public synchronized void withdraw(int money) { //synchronized로 메소드를 동기화
		if (balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			balance -= money;
		}
	}
}

class Child implements Runnable {
	Account acc = new Account();
	public void run() {
		while (acc.getBalance() > 0) {
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance: " + acc.getBalance() + Thread.currentThread().getName());
		}
	}
}

public class MomAccount {

	public static void main(String[] args) {
		Runnable r = new Child();
		new Thread(r, "아들").start();
		new Thread(r, "딸").start();
	}
}
