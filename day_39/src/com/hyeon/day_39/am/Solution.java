package com.hyeon.day_39.am;

import java.io.BufferedReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
//		String t = sc.nextLine();
//		int T = Integer.parseInt(t);
		int T = sc1.nextInt();
		String str = sc1.next();
//		String s = "1 2 3";
//		System.out.println(s);
//		String[] sArr = str.split(" ");
//		for (String string : sArr) {
//			System.out.println(string);
//		}
//		int w = Integer.parseInt(str.split(" ")[0]);
		int w = (int)str.charAt(0) - '0';
		int h = Integer.parseInt(str.split(" ")[1]);
		int s = Integer.parseInt(str.split(" ")[2]);
		System.out.print(w + ", " + h + ", " + s);
	}

}

class DustXy {
	int x;
	int y;
	
	public DustXy(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
}