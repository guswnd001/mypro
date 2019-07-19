package javaProject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Hashtable;
import java.util.Iterator;

public class BlackjackServer2 {
	static ServerSocket server;
	static Hashtable<String, ObjectOutputStream> ht;
	final static int port = 9000;
	Socket client;

	public BlackjackServer2() {
		int dealerScore = 0;
		ht = new Hashtable<String, ObjectOutputStream>();
		System.out.println("======블랙잭 서버======");
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Deck deck = new Deck();
		deck.shuffle();
		Player dealer = new Player("딜러", deck.pick(0), deck.pick(1));
		for (int i = 0; i < dealer.card.size(); i++) {
			System.out.println(dealer.name + "의 " + dealer.card.get(i));
		}
		dealerScore = dealer.getSum(dealer.card);
		System.out.println("딜러의 점수는 " + dealerScore + "입니다.");

		while (true) {
			try {
				System.out.println("접속요청 대기");
				client = server.accept();
				ChatServerThread childThread = new ChatServerThread(client, dealer, deck);
				Thread t = new Thread(childThread);
				t.start();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}

	public static String compareScore(Player p1, Player p2) {
		if (p1.getSum(p1.card) > 21 && p2.getSum(p2.card) > 21) {
			return "버스트 - 딜러가 이겼습니다.";
		} else if (p1.getSum(p1.card) < 21 && p2.getSum(p2.card) < 21) {
			if (p1.getSum(p1.card) < p2.getSum(p2.card)) {
				return p2.name + "(이)가 이겼습니다.";
			} else if (p1.getSum(p1.card) == p2.getSum(p2.card)) {
				return "무승부 입니다.";
			} else {
				return p1.name + "(이)가 이겼습니다.";
			}
		} else {
			if (p1.getSum(p1.card) > 21 && p2.getSum(p2.card) < 21) {
				return p2.name + "(이)가 이겼습니다.";
			} else {
				return p1.name + "(이)가 이겼습니다.";
			}
		}

	}

	// **메인메소드**
	public static void main(String[] args) throws IOException {
		new BlackjackServer2();
	}

	// 접속 스레드
	static class ChatServerThread extends Thread {
		int dealerScore;
		Socket client;
		ObjectInputStream ois;
		ObjectOutputStream oos;
		String userId;
		Deck deck;
		Player dealer;

		ChatServerThread(Socket client, Player dealer, Deck deck) {
			this.client = client;
			this.dealer = dealer;
			this.deck = deck;

			try {
				System.out.println(client.getInetAddress() + "접속");
				ois = new ObjectInputStream(client.getInputStream());
				oos = new ObjectOutputStream(client.getOutputStream());
				userId = ois.readUTF();
				System.out.println("User_ID: " + userId + "접속함");
				ht.put(userId, oos);
				broadcast(userId + "님이 입장하셨습니다.\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private void broadcast(String msg) {
			try {
				for (ObjectOutputStream oos : ht.values()) {
					oos.writeObject(msg);
					oos.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			Player player = new Player(userId, deck.pick(2), deck.pick(3));
			int pickNum = 4;
			try {
//				while (true) {
				while (true) {
					broadcast(dealer.name + "의 " + dealer.card.get(0));
					for (int i = 0; i < player.card.size(); i++) {
						broadcast(player.name + "의 " + player.card.get(i));
					}
					oos.flush();
					if (dealer.getSum(dealer.card) == 21 || player.getSum(player.card) > 21) {
						broadcast(dealer.name + "의 점수는 " + dealer.getSum(dealer.card));
						broadcast(player.name + "의 점수는 " + player.getSum(player.card));
						broadcast(dealer.name + "(이)가 이겼습니다.");
						break;
					} else if (player.getSum(player.card) == 21 || dealer.getSum(dealer.card) >= 21) {
						broadcast(dealer.name + "의 점수는 " + dealer.getSum(dealer.card));
						broadcast(player.name + "의 점수는 " + player.getSum(player.card));
						broadcast(player.name + "(이)가 이겼습니다.");
						break;
					} else {
						broadcast("버튼을 선택해 주세요");
						int answer = ois.read();

						if (answer == 1) {
							player.card.add(deck.pick(pickNum));
							pickNum++;
							if (dealer.getSum(dealer.card) <= 16) {
								dealer.card.add(deck.pick(pickNum));
								for (int i = 0; i < dealer.card.size(); i++) {
									System.out.println(dealer.name + "의 " + dealer.card.get(i));
								}
								pickNum++;
								System.out.println("딜러의 점수는 " + dealer.getSum(dealer.card) + "입니다.");
							}
						} else if (answer == 2) {
							
							broadcast(dealer.name + "의 점수는 " + dealer.getSum(dealer.card));
							broadcast(player.name + "의 점수는 " + player.getSum(player.card));
							broadcast(compareScore(dealer, player));
							
						} else if (answer == 3) {
							System.exit(0);
						}
					}
					
				}
				

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
	}
}
