package com.hyeon.day_28.pm;

public class PriorityExample {

	public static void main(String[] args) {
		
		for (int i = 1; i < 11; i++) {
			Thread thread = new CalcThread("Thread" + i);
			if (i != 10) {
				thread.setPriority(Thread.MIN_PRIORITY);
			} else {
				thread.setPriority(Thread.MAX_PRIORITY);
			}
			thread.start();
		}
		
	}

}

class CalcThread extends Thread {
	public CalcThread(String name) {
		setName(name);
	}
	
	public void run() {
		for (int i = 0; i < 2000000000; i++) {
		}
		System.out.println(getName());
	}
	
}
