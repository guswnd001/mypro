package com.hyeon.day_15.am;

public class DmbCellPhoneExample {

	public static void main(String[] args) {
		//DmbCellPhone 객체 생성
		DmbCellPhone dmbCell = new DmbCellPhone("갤럭시s10", "블랙", 10);
		//CellPhone으로 부터 상속받은 필드
		System.out.println("모델 : " + dmbCell.model);
		System.out.println("색상 : " + dmbCell.color);
		//DmbCellPhone의 필드
		System.out.println("채널 : " + dmbCell.channel);
		//CellPhone으로부터 상속받은 메소드 호출
		dmbCell.powerOn();
		dmbCell.bell();
		dmbCell.sendVoice("여보세요~");
		dmbCell.receiveVoice("나야, 거기 잘 지내니");
		dmbCell.sendVoice("여보세요, 왜 말 안하니");
		dmbCell.hangUp();
		//DmbCellPhone의 메소드 호출
		dmbCell.turnOnDmb();
		dmbCell.changeChannel(11);
		dmbCell.turnOffDmb();
		
	}

}
