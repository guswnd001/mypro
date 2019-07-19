package javaProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIBlackjackClient2 extends JFrame implements ActionListener{
	JPanel p1 = null;
	JButton btnStop, btnHit, btnEnd;
	JTextArea ta1 = null;
	JLabel lb = null;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	Socket client = null;
	
	public GUIBlackjackClient2(){
		super("블랙잭 게임");
		p1 = new JPanel();
		btnHit = new JButton("HIT");
		btnStop = new JButton("STOP");
		btnEnd = new JButton("End");
		ta1 = new JTextArea();
		lb = new JLabel(" ", JLabel.CENTER);
		
		p1.add(btnHit);
		p1.add(btnStop);
		p1.add(btnEnd);
		add(ta1, "Center");
		add(p1, "South");
		add(lb, "North");
		setLocation(350, 200);
		setSize(300, 400);
		setVisible(true);
		
		String name = JOptionPane.showInputDialog("이름을 입력하세요");
		if (name == null) {
			System.exit(0);
		}
		System.out.println(name);
		lb.setText(name);
		btnHit.addActionListener(this);
		btnStop.addActionListener(this);
		btnEnd.addActionListener(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent a) {
		try {
			Object obj = a.getSource();
			if (obj == btnHit) {
				oos.write(1);
				oos.flush();
			} else if (obj == btnStop) {
				oos.write(2);
				oos.flush();
			} else if (obj == btnEnd) {
				oos.write(3);
				oos.flush();
				System.exit(0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		GUIBlackjackClient2 blackjack = new GUIBlackjackClient2();
//		String ip = "192.168.0.9";
		String ip = "211.63.89.96";
		String port = "9000";
		blackjack.init(ip, port);
	}
	
	void init(String ip, String port) {
		int sPort = 8000;
		try {
			sPort = Integer.parseInt(port);
		} catch (NumberFormatException e) {
			sPort = 8000;
		}
		
		try {
			client = new Socket(ip, sPort);
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			String usr_id = lb.getText();
			oos.writeUTF(usr_id);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Runnable rt = new ReceiveDataThread();
		Thread t = new Thread(rt);
		t.start();
	}
	
	class ReceiveDataThread implements Runnable {
		String receiveData;
		
		public void run() {
			try {
				while (true) {
					receiveData = (String) ois.readObject();
					ta1.append(receiveData + "\n");
					if (receiveData.contains("이겼")) {
						ta1.append("5초 후에 게임을 종료합니다.\n");
						for (int i = 5; i > 0; i--) {
							ta1.append(i + "초\n");
							Thread.sleep(1000);
						}
						ta1.append("게임을 종료합니다.");
						System.exit(0);
					}
				}
				
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			} catch (InterruptedException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}
}
