package hyeon.day_02;

public class VarExample {

	public static void main(String[] args) {
		//왜 오류가 나는지에 대해 이해하기 위한 예제 
		
		short data1 = 120; //4바이트인 120을 2바이트인 short에 억지로 넣은것. 
		short data2 = 240;
		//short result = data1 + data2; //연산은 4바이트이상부터 가능하다.
		short result0 = (short)(data1 + data2); //연산은 4바이트이상부터 가능하다.
		  
		System.out.println(result0);
		System.out.println();
		 
		
		int data11 = 120; //4바이트인 120을 2바이트인 short에 억지로 넣은것.
		int data12 = 240;
		int result00 = data11 + data12; //연산은 4바이트이상부터 가능하다.
		
		System.out.println(result00); 
		
		
	}

}
