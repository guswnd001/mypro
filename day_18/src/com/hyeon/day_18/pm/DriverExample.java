package com.hyeon.day_18.pm;

public class DriverExample {

	public static void main(String[] args) {
		Driver d = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		d.drive(bus);
		d.drive(taxi);
		
	}

}
