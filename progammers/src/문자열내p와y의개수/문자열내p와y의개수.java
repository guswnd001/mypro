package 문자열내p와y의개수;

public class 문자열내p와y의개수 {
	
	public static void main(String[] args) {
		
//		String s = "pPoooyY";
		String s = "Pyy";
		boolean answer = true;
		
		int pCnt = 0;
		int yCnt = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
				pCnt++;
			} else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
				yCnt++;
			}
		}
		
		if (pCnt != yCnt) { answer = false; }
		
		System.err.println(answer);
		
	}
	
}
