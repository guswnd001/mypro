package com.hyeon.day_39.am;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class ChatServerEx1 {
	static ServerSocket server;
	static int port = 6000;
	static Hashtable<String, ObjectOutputStream> ht;
	
	//**메인메소드**
	public static void main(String[] args) throws IOException{		
		server = new ServerSocket(port);
		System.out.println("채팅 서버 시작");
		ht = new Hashtable<String, ObjectOutputStream>();
		//포트 열어두고 대기
		while (true) {
			System.out.println("클라이언트 접속 대기 중");
			Socket client = server.accept();
			ChatServerThread ct = new ChatServerThread(client);
			ct.start();
		}
	}
	
	static class ChatServerThread extends Thread {
		Socket client;
		ObjectInputStream ois;
		ObjectOutputStream oos;
		String userId;
		
		ChatServerThread(Socket client) {
			this.client = client;
			
			try {
				System.out.println(client.getInetAddress() + "접속");
				ois = new ObjectInputStream(client.getInputStream());
				oos = new ObjectOutputStream(client.getOutputStream());
				userId = (String) ois.readObject();
				System.out.println("User_ID: " + userId + "접속함");
				ht.put(userId, oos);
				broadcast(userId + "님이 입장하셨습니다.");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		private void broadcast(String msg) {
			try {
				for (ObjectOutputStream o : ht.values()) {
					o.writeObject(msg);
					o.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void run() {
			String rcvData;
			try {
				while (true) {
					rcvData = (String) ois.readObject();
					if (rcvData.equals("/bye")) { break; }
					else if (rcvData.startsWith("/to")) { sendMsg(rcvData); }
					else { broadcast(userId + ":" + rcvData); }
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				broadcast(userId + "님이 퇴장하셨습니다.");
				ht.remove(userId);
				try {
					if (client != null) {
						client.close();
					}
				} catch (IOException e2) {
					// TODO: handle exception
				}
			}
		}
		//이해 요망
		private void sendMsg(String rcvData) {
			int begin = rcvData.indexOf(" ") + 1;
			int end = rcvData.indexOf(" ", begin);
			if (end != -1) {
				String id = rcvData.substring(begin, end);
				String msg = rcvData.substring(end + 1);
				ObjectOutputStream oos = ht.get(id);
				ObjectOutputStream oos2 = ht.get(userId);
				if (oos != null) {
					try {
						oos.writeObject(userId + "님의 귓속말: " + msg);
						oos.flush();
						oos2.writeObject(id + "님에게 귓속말 전송: " + msg);
						oos2.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}

}
