package review;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TcpIpMultichatServerEx {
	HashMap client;
	
	TcpIpMultichatServerEx() {
		client = new HashMap();
		Collections.synchronizedMap(client);
	}
	
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");
			while (true) {
				socket = serverSocket.accept();
				
				
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	public void sendToAll(String msg) {
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
		
	}
	
	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		
		ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
		
		public void run() {
			String name = "";
			try {
				name = in.readUTF();
				sendToAll("#" + name + "님이 들어왔습니다.");
				client.put(name, out);
				System.out.println("현재 접속자 수는 " + client.size() + "입니다.");
				while (true) {
					sendToAll(in.readUTF());
				}
			} catch (IOException e) {
				// TODO: handle exception
			} finally {
				sendToAll("#" + name + "님이 나갔습니다.");
				client.remove(name);
				System.out.println("[" + socket.getInetAddress() + ":"
									+ socket.getPort() + "] 에서 접속을 종료했습니다.");
				System.out.println("현재 접속자 수는 " + client.size() + "입니다.");
			}
		}
	}

}
