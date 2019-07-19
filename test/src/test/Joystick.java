package test;

public class Joystick {
	
	public static void main(String[] args) {
		
		System.out.println(solution("JAN"));
		
	}
	
	 public static int solution(String name) {
	        
		 int answer = 0;
		 char[] charArr = new char[name.length()];
		 for (int i = 0; i < charArr.length; i++) {
			 charArr[i] = name.charAt(i);
		 }
		 
		 answer = (int)charArr[0]; //문자를 아스키 코드로 변환
				 
	     
		 return answer;
	        
	        
    }

}

