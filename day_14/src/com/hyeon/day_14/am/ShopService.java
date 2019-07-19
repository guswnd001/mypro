package com.hyeon.day_14.am;
//18번
public class ShopService {
	
	private static ShopService singleton = new ShopService();
	
	private ShopService() {}
	
	static ShopService getIntance() {
		return singleton;
	}
	
	
}
