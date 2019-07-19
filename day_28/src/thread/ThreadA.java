package thread;

public class ThreadA extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	public void run() {
		while (!stop) {
			if (work) {	System.out.println("ThreadA 작업 내용");
			} else { Thread.yield();
			} System.out.println("ThreadA 종료");
		}
	}
}

class ThreadB extends Thread {
	public boolean stop = false;
	public boolean work = true;
	
	public void run() {
		while (!stop) {
			if (work) {	System.out.println("ThreadB 작업 내용");
			} else { Thread.yield();
			} System.out.println("ThreadB 종료");
		}
	}
}
