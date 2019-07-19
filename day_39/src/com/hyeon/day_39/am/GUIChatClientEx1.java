package com.hyeon.day_39.am;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//**ActionListner: 실제 액션에 관한 기능을 가지고 있다.
public class GUIChatClientEx1 extends Frame implements ActionListener{
	static int port = 6000;
	Socket client = null;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	String userId;
	Button btnExit, btnSend, btnConnect;
	TextArea taList;
	TextField tfIp, tfName, tfInput;
	CardLayout c1;
	
	GUIChatClientEx1() {
		super("채팅프로그램");
		c1 = new CardLayout();
		setLayout(c1);
		
		Panel connect = new Panel();
		connect.setLayout(new BorderLayout());
		connect.add("North", new Label("채팅접속화면", Label.CENTER));
		
		Panel conn_sub = new Panel();
		conn_sub.setLayout(new GridLayout(10, 1));
		conn_sub.add(new Label("서버 IP", Label.CENTER));
		tfIp = new TextField("192.168.0.9", 15);
		conn_sub.add(tfIp);
		conn_sub.add(new Label("사용자 ID", Label.CENTER));
		tfName = new TextField("홍길동", 15);
		conn_sub.add(tfName);
		connect.add("Center", conn_sub);
		btnConnect = new Button("서버접속");
		connect.add("South", btnConnect);
		
		Panel chat = new Panel();
		chat.setLayout(new BorderLayout());
		chat.add("North", new Label("채팅 ver1.0"));
		taList = new TextArea();
		chat.add("Center", taList);
		
		Panel chat_sub = new Panel();
		tfInput = new TextField("대화내용", 25); //*
		btnSend = new Button("전송");
		btnExit = new Button("종료");
		chat_sub.add(tfInput);
		chat_sub.add(btnSend);
		chat_sub.add(btnExit);
		btnConnect.addActionListener(this);
		tfInput.addActionListener(this);
		btnExit.addActionListener(this);
		btnSend.addActionListener(this);
		
		chat.add("South", chat_sub);
		add(connect, "접속창");
		add(chat, "채팅창");
		c1.show(this, "접속창"); //초기화면
		setSize(500, 400);
		setVisible(true); //화면에 표시함
		
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("Exit");
				//현재 실행하고 있는 프로세스를 정상 종료를 시킨다.
				System.exit(0); 
			}
		});
		
	}
	
	public static void main(String[] args) {
		new GUIChatClientEx1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Object obj = e.getSource(); //이벤트를 발생시킨 이벤트 소스 객체를 가져온다.
			if (obj == btnConnect) {
				init();
			} else if (obj == btnExit) {
				System.exit(0);
			} else if (obj == btnSend || obj == tfInput) {
				String sendData = tfInput.getText();
				oos.writeObject(sendData);
				oos.flush();
				tfInput.setText("");
				tfInput.requestFocus();
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
	private void init() {
		try { //211.63.89.68
			String ipArr = tfIp.getText();
			client = new Socket(ipArr, port);
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			userId = tfName.getText();
			oos.writeObject(userId);
			oos.flush(); //stream에 남아있는 데이터를 강제로 내보내는 메소드
			ReceiveDataThread rt = new ReceiveDataThread();
			rt.setDaemon(true); //데몬스레드는 다른 스레드의 작업을 돕는 보조적인 역할을 수행
			rt.start(); //데몬스레드 시작
			c1.show(this, "채팅창");
			setTitle(userId + "채팅창");
			tfInput.requestFocus(); //*
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	class ReceiveDataThread extends Thread {
		String rcvData;
		
		public void run() {
			try {
				while (true) {
					rcvData = (String) ois.readObject();
					taList.append(rcvData + "\n"); //*
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
