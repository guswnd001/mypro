package com.hyeon.day_12.am;

public class CarExample {
	
	public static void main(String[] args) {
		
		Car myCar = new Car();
		
		myCar.setGas(5);
		
		boolean gasState = myCar.isLeftGas();
		if (gasState) {
			System.out.println("출발합니다.");
			myCar.run();
		}
		
		if (myCar.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 없습니다.");
		} else {
			System.out.println("gas를 주입해주세요.");
		}
	}
	
}

class Car {
	
	int gas;
	
	public void setGas(int i) {
		this.gas = i;
	}

	public void run() {
		while (true) {
			if (gas > 0) {
				System.out.println("달립니다. (남은 gas : " + gas + ")");
				gas -= 1;
			}else {
				System.out.println("멈춥니다. (남은 gas : " + gas + ")");
				return;
			}
		}
	}

	public boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("gas가 없습니다.");
			return false;
		} else {
			System.out.println("gas가 있습니다.");
			return true;
		}
	}
	
	
	
	
}

