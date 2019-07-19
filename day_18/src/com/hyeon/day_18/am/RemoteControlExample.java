package com.hyeon.day_18.am;

public class RemoteControlExample {

	public static void main(String[] args) {
		
//		RemoteControl rc;
//		rc = new Television();
//		rc.turnOn();
//		rc = new Audio();
//		rc.turnOn();
//		rc.setMute(true);
		
		RemoteControl rc = new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("sss");
			}
			
			@Override
			public void turnOff() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setVolume(int volume) {
				// TODO Auto-generated method stub
				
			}
		};
		rc.turnOn();
		
		SmartTelevision sTv = new SmartTelevision();
		RemoteControl rc1 = sTv;
		rc1.turnOn();
		RemoteControl.changeBattery();
		Searchable s = sTv;
		s.search("http://naver.com/");
		
	}

}
