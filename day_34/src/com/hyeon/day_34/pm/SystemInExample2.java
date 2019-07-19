package com.hyeon.day_34.pm;

import java.io.InputStream;

public class SystemInExample2 {

	public static void main(String[] args) throws Exception{
		InputStream is = System.in;
		byte[] datas = new byte[100];
		
		System.out.print("이름: ");
		int nameBytes = is.read(datas);
		String name = new String(datas, 0, nameBytes-2);
		
		System.out.print("하고싶은 말: ");
		int commentBytes = is.read(datas);
		String comment = new String(datas, 0, commentBytes-2);
		
		System.out.println("입력한 이름: " + name);
		System.out.println("입력한 하고싶은말: " + comment);
		
		//utf는 3바이트이다. 
	}

}
