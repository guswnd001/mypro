package com.hyeon.day_34.am;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class AirplaneFileOutput {

	public static void main(String[] args) {
		PrintStream ps = null;
		FileOutputStream fos = null;
		
		String[] company = { "대한항공", "아시아나", "기타국내", "기타해외" };
		String[] country = { "일본", "중국", "미국", "호주", "동유럽", "서유럽", "동남아" };
		String[] sex = { "남자", "여자" };
		String[] purpose = { "출장", "관광", "학업" };
		String[] reason = { "해외를 한번도 나가보지 못해서", 
							"이국적인 분위기/볼거리",
							"다양한 액티비티",
							"국내여행과 비용차이가 없어서" };
		
		try {
			fos = new FileOutputStream("AirplaneStream.txt", true);
			ps = new PrintStream(fos);
			for (int i = 0; i < 90000; i++) {
				int chkPurpose = (int)(Math.random()*3); // 1:출장 2:관광 3:학업
				String line = "" + ((int)(Math.random()*12) + 1) + ", " //월
						+ (company[(int)(Math.random()*4)]) + ", " //항공사
						+ ((int)(Math.random()*8) + 1) * 10 + ", " //나이
						+ (sex[(int)(Math.random()*2)]) + ", " //성별
						+ (country[(int)(Math.random()*7)]) + ", " //목적지
						+ (purpose[chkPurpose]);//여행 목적 1:출장 2:관광 3:학업
				if (chkPurpose == 1) {
					line += ", " + reason[(int)(Math.random()*3)]; //반품이유
				}
				ps.append(line + "\n");
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found.");
		}
	}

}
