package com.hyeon.day_28.pm;

public class ThreadB extends Thread{
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + "가 출력한 내용");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
