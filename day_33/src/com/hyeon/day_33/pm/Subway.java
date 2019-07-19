package com.hyeon.day_33.pm;

import java.util.Map;

public class Subway {
	private int month;
	private int day;
	private Map<String, String> routeStation;
	private int inPeople;
	private int outPeople;
	
	public Subway(int month, int day, Map<String, String> routeStation, int inPeople, int outPeople) {
		this.month = month;
		this.day = day;
		this.routeStation = routeStation;
		this.inPeople = inPeople;
		this.outPeople = outPeople;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public Map<String, String> getRouteStation() {
		return routeStation;
	}

	public int getInPeople() {
		return inPeople;
	}

	public int getOutPeople() {
		return outPeople;
	}
	
	
	

}
