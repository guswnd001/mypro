package com.hyeon.day_38.am;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TcpIpMultichatServer {
	HashMap client; //컬렉션의 맵
	
	TcpIpMultichatServer() { //생성자
		client = new HashMap();
		Collections.synchronizedMap(client);
	}
	
	public void start() { //start메소드
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다");
			while (true) { //계속 서버를 열어둬서 입력을 처리
				socket = serverSocket.accept();
				System.out.println("[" + socket.getInetAddress() + ":"
									+ socket.getPort() + "]" + "에서 접속하였습니다.");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void sendToAll(String msg) {
		Iterator it = client.keySet().iterator();
		while (it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream)client.get(it.next());
				out.writeUTF(msg);
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) {
		new TcpIpMultichatServer().start();
	}
	
	class ServerReceiver extends Thread {
		Socket socket;
		//socket에 관한 정보를 in, out에 저장
		DataInputStream in;
		DataOutputStream out;
		
		ServerReceiver(Socket socket) { //생성자
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream()); //이름
				out = new DataOutputStream(socket.getOutputStream()); //주소
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
		
		public void run() {
			String name = "";
			try {
				name = in.readUTF(); //이름을 받음
				sendToAll("#" + name + "님이 들어오셨습니다.");
				client.put(name, out); //key= name(이름), value= out(소켓의 주소) 이름 값을 받음
				System.out.println("현재 서버 접속자 수는 " + client.size() + "입니다.");
				while (in != null) {
					sendToAll(in.readUTF());
				}
			} catch (IOException e) {
				// TODO: handle exception
			} finally {
				sendToAll("#" + name + "님이 나가셨습니다.");
				client.remove(name);
				System.out.println("[" + socket.getInetAddress()
									+ ":" + socket.getPort() + "에서 접속을 종료하였습니다.");
				System.out.println("현재 서버접속자 수는 " + client.size() + "입니다.");
			}
		}
	}
}
