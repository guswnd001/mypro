package com.hyeon.day_09.am;

import java.io.IOException;

import javax.swing.plaf.SliderUI;

public class WhileKeyControlExample {

	public static void main(String[] args) throws Exception {
		
		boolean run = true;
		int speed = 0;
		int keyCode = 0;
		
		while (run) {
			if (keyCode != 13 && keyCode != 10) { //엔터키를 제외
				System.out.println("---------------------------");
				System.out.println("1. 증속 | 2. 감속 | 3. 중지");
				System.out.println("---------------------------");
				System.out.println("선택 : ");
			}
			keyCode = System.in.read(); //아스키 코드로 받아옴
			
			if (keyCode == 49) { // 49 == 1
				speed += 1;
				System.out.println("현재속도 = " + speed);
			} else if (keyCode == 50) { //50 == 2
				speed -= 1;
				System.out.println("현재속도 = " + speed);
			} else if (keyCode == 51) { // 51 == 3
				run = false;
			}
		}
		System.out.println();
		System.out.println("프로그램 종료");
		
		
		
	}

}
