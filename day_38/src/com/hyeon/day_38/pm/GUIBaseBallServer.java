package com.hyeon.day_38.pm;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class GUIBaseBallServer {
	ServerSocket server;
	final static int port = 5000;
	Socket client;
	HashMap<String, ObjectOutputStream> hm;

	public GUIBaseBallServer() {
		String data = "";
		System.out.println("=====야구 게임 서버=====");
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		hm = new HashMap<String, ObjectOutputStream>();
		Set dset = new HashSet();
		Random r = new Random();
		while (true) {
			int num = r.nextInt(10);
			dset.add(num);
			if (dset.size() == 4) {
				break;
			}
		}
		StringBuffer sb = new StringBuffer();
		Iterator it = dset.iterator();
		while (it.hasNext()) {
			sb.append(it.next());
		}
		data = sb.toString();
		System.out.println("숫자는 " + data + "입니다.");
		while (true) {
			try {
				System.out.println("접속요청 대기"); // 서버는 클라이언트 소켓의 접속 요청을 기다리고 있음.
				client = server.accept();
				ChatServerThread childThread = new ChatServerThread(data, client, hm);
				Thread t = new Thread(childThread);
				t.start();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		new GUIBaseBallServer();
	}
}

class ChatServerThread implements Runnable {
	String data;
	Socket client;
	HashMap<String, ObjectOutputStream> hm;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	String user_id;

	public ChatServerThread(String data, Socket client, HashMap<String, ObjectOutputStream> hm) {
		this.data = data;
		this.client = client;
		this.hm = hm;
		try {
			System.out.println(client.getInetAddress() + "로부터 연결요청");
			ois = new ObjectInputStream(client.getInputStream());
			oos = new ObjectOutputStream(client.getOutputStream());
			user_id = (String) ois.readObject();
			System.out.println("server : user_id = " + user_id);
			broadcast(user_id + "님이 접속했습니다");
			System.out.println("접속 ID: " + user_id);
			synchronized (hm) {
				hm.put(this.user_id, oos);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String receiveData;
		try {
			while (true) {
				receiveData = (String) ois.readObject();
				if (receiveData.length() != 4) {
					oos.writeObject("4자리 숫자를 입력하세요");
					continue;
				}
				Set s = new HashSet();
				for (int i = 0; i < 4; i++) {
					char c = receiveData.charAt(i);
					if (!s.add(c)) {
						oos.writeObject("서로다른 4개숫자입력하세요");
						break;
					}
				}
				int strike = 0;
				int ball = 0;
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (receiveData.charAt(i) == data.charAt(j)) {
							if (i == j) {
								strike++;
							} else {
								ball++;
							}
						}
					}
				}
				if (strike == 4) {
					broadcast(receiveData + "정답입니다. " + user_id + "님이 승리\n 게임을 종료합니다");
					System.exit(0);
				} else {
					oos.writeObject(receiveData + ":" + strike + "스트라이크" + ball + "볼");
				}
			}
		} catch (Exception e) {
			System.out.println("클라이언트 강제종료");
		} finally {
			synchronized (hm) {
				hm.remove(user_id);
			}
			broadcast(user_id + "님이 나갔습니다");
			System.out.println(user_id + "님이 나갔습니다");
			try {
				if (client != null) {
					client.close();
				}
			} catch (Exception e2) {
			}
		}
	}

	private void broadcast(String message) {
		synchronized (hm) {
			try {
				for (ObjectOutputStream oos : hm.values()) {
					oos.writeObject(message);
					oos.flush();
				}
			} catch (Exception e) {
			}
		}
	}
}
