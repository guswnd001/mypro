package javaProject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class BlackjackClient {

	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("[플레이어 이름을 입력해주세요]");
		String name = scanner1.next();
		try {
			String serverIp = "192.168.0.9";
			Socket socket = new Socket(serverIp, 8000);
			System.out.println("- 서버에 연결되었습니다.");
			Thread sender = new Thread(new ClientSender(socket, name));
			Thread receiver = new Thread(new ClientReceiver(socket));
			sender.start();
			receiver.start();
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	static class ClientSender extends Thread {
		Socket socket;
		ObjectOutputStream oos;
		String name;
		
		ClientSender(Socket socket, String name) {
			this.socket = socket;
			try {
				this.name = name;
				oos = new ObjectOutputStream(socket.getOutputStream());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		public void run() {
			Scanner scanner2 = new Scanner(System.in);
			try {
				if (oos != null) {
					oos.writeUTF(name);
					oos.flush();
				}
				while (oos != null) {					
					oos.write(scanner2.nextInt());
					oos.flush();
				}
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
	
	static class ClientReceiver extends Thread {
		Socket socket;
		String rcvData;
		ObjectInputStream ois;
		
		ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				ois = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
		
		public void run() {
			while (ois != null) {
				try {
					rcvData = (String) ois.readObject();
					System.out.println(rcvData);
					if (rcvData.contains("이겼")) {
						System.exit(0);
					}
				} catch (Exception e) {
					try {
						ois.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					e.printStackTrace();
				}
			}
		}
	}
	
}
