package com.hyeon.day_31.pm;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<Message>();

		messageQueue.offer(new Message("sendMail", "김현중"));
		messageQueue.offer(new Message("sendSMS", "김주호"));
		messageQueue.offer(new Message("sendKakao", "이승주"));

		while (!messageQueue.isEmpty()) {
			Message m = messageQueue.poll();
			switch (m.command) {
			case "sendMail":
				System.out.println(m.to + "님에게 메일을 보냅니다.");
				break;

			case "sendSMS":
				System.out.println(m.to + "님에게 SMS을 보냅니다.");
				break;

			case "sendKakao":
				System.out.println(m.to + "님에게 카카오톡을 보냅니다.");
				break;
			}
		}
	}

}

class Message {
	public String command;
	public String to;

	public Message(String command, String to) {
		this.command = command;
		this.to = to;
	}
}