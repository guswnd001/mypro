package hyeon.day_03;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int k = 20;
		long j = k; //자동 형변환 => 묵시적일지라도 명시적으로 사용하길 권장
		long longData = 300L;
		//int intData = longData; 자동으로 형변환되지 않음
		int intData = (int)(longData + longData); //명시적 형변환 
		float floatData = longData;
		
		System.out.println(4%3);
		
	}

}
