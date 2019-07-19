package hyeon.day_03;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * System.out.println("나는 \"무지 졸립다.\'");
		 * System.out.println("파일 경로는 c:\\window\\.");
		 * System.out.println("나는 \"무지 \'졸립다.\"");
		 * System.out.println("\n");
		 * System.out.println("파일 경로는 c:\\window\\."); 
		 * System.out.println("\n");
		 */
		System.out.write('3'); // write의 경우 flush 명령어를 꼭 써야한다.
		System.out.write('\n'); // write의 경우 flush 명령어를 꼭 써야한다.
		System.out.write(51); // write의 경우 flush 명령어를 꼭 써야한다.
		System.out.write('\n'); // write의 경우 flush 명령어를 꼭 써야한다.
		System.out.flush();
		//System.out.write(167583); // write의 경우 flush 명령어를 꼭 써야한다.
		//System.out.flush();
		
		//배열학습 후 생각해보기
		byte[] chardata = {65,66,67,68,69,70};
		System.out.write(chardata, 1, 4);
		System.out.flush();
		
	}

}
