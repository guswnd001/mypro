package com.hyeon.day_32.am;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class RandomFileOutput {

	public static void main(String[] args) {
		PrintStream ps = null;
		FileOutputStream fos = null;
		
		String[] car = { "소나타", "K3", "아반떼", "K5", "티볼리" };
		String[] remark = { "단순변심", "차량불량", "오배송" };
		try {
			fos = new FileOutputStream("streamTest.txt", true);
			ps = new PrintStream(fos);
			for (int i = 0; i < 90000; i++) {
				int chk = (int)(Math.random()*3) + 1; //1(생산), 2(판매), 3(반품)
				String line = "" + ((int)(Math.random()*12) + 1) + ", " //월
								+ chk + ", " //체크
								+ (car[(int)(Math.random()*5)]) + ", " //차종
								+ ((int)(Math.random()*5) + 1); //수량
				if (chk == 3) {
					line += ", " + remark[(int)(Math.random()*3)]; //반품이유
				}
				ps.append(line + "\n");
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found.");
		}
	}

}
