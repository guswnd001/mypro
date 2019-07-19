package hyeon.day_03;

public class OperateTest04 {

	public static void main(String[] args) {
		
		int numData = 120;
		String changeNumData = "" + numData; //숫자를 문자형으로 변환
		
		System.out.println(changeNumData + 123 + 123); //120123
		System.out.println(numData + 123); //243
		System.out.println("===================================");
		
		String strData = "12345";
		System.out.println(strData + 100); //12345100
		System.out.println(Integer.parseInt(strData) + 100); //12445
		System.out.println(Double.parseDouble(strData) + 100); //12445 
		
		
		
		
	}

}
