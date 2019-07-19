package com.hyeon.day_37.pm;

import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer5 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			//서버소켓을 생성하여 7777번 포트와 결합(bind)시킨다.
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다.");
			socket = serverSocket.accept();
			System.out.println("연결!");
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			sender.start();
			receiver.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
