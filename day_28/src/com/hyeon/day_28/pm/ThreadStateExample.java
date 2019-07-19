package com.hyeon.day_28.pm;

public class ThreadStateExample {

	public static void main(String[] args) {
		StatePrintThread statePrintThread = 
										new StatePrintThread(new TargetThread());
		statePrintThread.start();
	}

}

class TargetThread extends Thread {
	public void run() {
		for (long i = 0; i < 1000000000; i++) {	}
		
		try {
			//1.5초간 일시정지
			System.out.println("run============");
			Thread.sleep(1500);
		} catch (Exception e) { }
		
		for (long i = 0; i < 1000000000; i++) {	}
	}
}