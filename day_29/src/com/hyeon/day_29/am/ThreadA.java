package com.hyeon.day_29.am;

public class ThreadA extends Thread {
	private WorkObject workObject;
	
	public ThreadA(WorkObject workObject) {
		this.workObject = workObject;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.print(i);
			workObject.methodA();
		}
	}
}

class ThreadB extends Thread {
private WorkObject workObject;
	
	public ThreadB(WorkObject workObject) {
		this.workObject = workObject;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.print(i);
			workObject.methodB();
		}
	}
}