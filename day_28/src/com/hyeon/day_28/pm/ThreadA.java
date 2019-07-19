package com.hyeon.day_28.pm;

public class ThreadA extends Thread{
	public ThreadA() {
		setName("ThreadA");
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + "가 출력한 내용");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
