package com.hyeon.day_34.pm;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) throws Exception{
		OutputStream os = new FileOutputStream("c:/tmp/outtest.txt");
		byte[] data = "ABC".getBytes();
		System.out.println(data.length);
		for (int i = 0; i < data.length; i++) {
			os.write(data[i]);
		}
		
		os.flush();
		os.close();
	}

}
