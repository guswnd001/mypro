package hyeon.day_03;

public class OperateTest03 {

	public static void main(String[] args) {
		System.out.println(50/3);
		System.out.println(50.3/3);
		System.out.println(50.3/3.2);

		System.out.println(50%3);
		System.out.println(50.3%3);
		System.out.println(50.3%3.2);
		
		double data1 = 0.3;
		double data2 = 0.1;
		double data3 = data2*10 + data2*10 + data2*10; //수학적 0.3
		System.out.println((data1*10 == data3)? "같다":"다르다");
		System.out.println("======구분======");
		double data4 = 0.75;
		double data5 = 0.25;
		double data6 = data5 + data5 + data5;
		System.out.println((data4 == data6)? "같다":"다르다"); //실수는 '=='하면 안된다.
		
	}

}
