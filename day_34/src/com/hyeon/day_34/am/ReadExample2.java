package com.hyeon.day_34.am;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample2 {

	public static void main(String[] args) throws Exception{
		InputStream is = new FileInputStream("c:\\tmp\\test.txt");
		int readByteNo;
		byte[] readBytes = new byte[10];
		String data = "";
		
		while (true) {
			readByteNo = is.read(readBytes, 2, 3); // 
			if (readByteNo == -1) {
				break;
			}
			for (byte bb : readBytes) {
				System.out.print(bb + ":" + (char)bb + "    ");
			}
			System.out.println();
			data += new String(readBytes, 0, readByteNo);
		}
		System.out.println(data);
		is.close();
	}

}
