package com.hyeon.day_33.pm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;;

public class SubwayFileOutput {

	public static void main(String[] args) {
		PrintStream ps = null;
		FileOutputStream fos = null;
		
		String[] route = new String[9];
		for (int i = 0; i < route.length; i++) {
			route[i] = (i+1) + "호선";
		}
	}

}
