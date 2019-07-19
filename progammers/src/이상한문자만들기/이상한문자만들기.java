package 이상한문자만들기;

public class 이상한문자만들기 {

	public static void main(String[] args) {

		String s = "What    time  is it    now        ";

		String answer = "";
		String[] sArr = s.split(" ", -1);
		
//		for (String string : sArr) {
//			System.out.println(string);
//		}
//		
//		System.out.println(sArr.length);
		for (int i = 0; i < sArr.length; i++) {
			for (int j = 0; j < sArr[i].length(); j++) {
				if ((j % 2) == 0) { //짝수번째 판별
					answer += sArr[i].split("")[j].toUpperCase(); //짝수 일시 - 대문자
				} else {
					answer += sArr[i].split("")[j].toLowerCase(); //홀수 일시 - 소문자
				}			
			}
			if(i != sArr.length - 1) answer += " ";
		}

		System.out.println(answer);
		
		
		
	}

}
