package com.hyeon.day_28.pm;

public class Calculator {
	private int memory;
	
	public int getMemory() { return memory; }
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try { Thread.sleep(200);
		} catch (InterruptedException e) { }
		System.out.println(Thread.currentThread().getName() + ": " + this.memory);
	}
}

