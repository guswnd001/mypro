package com.hyeon.day_18.pm;

public class Driver {
	public void drive(Vehicle vehicle) {
		if (vehicle instanceof Bus) {
			Bus bus = (Bus)vehicle;
		}
		
		vehicle.run();
	}
}
