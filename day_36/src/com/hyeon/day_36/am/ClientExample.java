package com.hyeon.day_36.am;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket(); //Socket 생성
			System.out.println("[연결 요청]");
			socket.connect(new InetSocketAddress("localhost", 5001)); //연결 요청
			System.out.println("[연결 성공]");
			
			byte[] bytes = null;
			String message = null;
			
			OutputStream os = socket.getOutputStream();
			message = "Hello, Server";
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("[데이터 보내기 성공]");
			
			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			int readByteCount = is.read(bytes);
			message = new String(bytes, 0, readByteCount, "UTF-8");
			System.out.println("[데이터 받기 성공] " + message);
		} catch (Exception e) { }
		
		if (!socket.isClosed()) { //연결 되어 있을 경우
			try {
				socket.close(); //연결 끊기
			} catch (IOException e) { }
			
		}
	}

}
