package model;

public class StrigUtils {

	public static boolean isNotEmpty(String str) {
		if (str == null || str.trim().equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
}
