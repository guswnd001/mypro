package hyeon.day_03;

public class SwitchTest { // class의 접근 지정자는 public 또는 package(접근지정자가 없는)만이 올 수 있다.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int s = 1;
		int k = -1;
		
		for (int i = 1; i < 11; i++) {
			System.out.println(s);
			k = k*(-1);
			s = (s+k)*(-1);
			//s = s*(-1) + k;
			
			//System.out.println(i*k);
			
		}
		
//		System.out.println(s);
//		
//		k = k*(-1);
//		s = (s+k)*(-1);
//		System.out.println(s);
//		
//		k = k*(-1);
//		s = (s+k)*(-1);
//		System.out.println(s);
//		k = k*(-1);
//		s = (s+k)*(-1);
//		System.out.println(s);
//		
//		k = k*(-1);
//		s = (s+k)*(-1);
//		System.out.println(s);
//		
//		
//		k = k*(-1);
//		s = (s+k)*(-1);
//		System.out.println(s);
//		
//		
//		k = k*(-1);
//		s = (s+k)*(-1);
//		System.out.println(s);
//		
		
		
	}

}
