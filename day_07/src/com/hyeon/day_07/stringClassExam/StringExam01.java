package com.hyeon.day_07.stringClassExam;

public class StringExam01 {
	
	public static void main(String[] args) {
		/*문자열과 관련된 클래스
		*String/ StringBuffer, StringBuilder가 있다.
		*상호간의 변경을 자유자재로 다룰 수 있어야 한다.
		*String(문자열 자료)의 특징 : 불변자료이다. 문자들의 묶음 => 같은종류(문자)의 묶음 => 배열 => 문자(char)의 배열이다.
		*/
		
		String stringWord = "안녕하십니까 저는 김현중입니다. 그쪽은 누구신가요?";
		System.out.println("김현중".charAt(1));
		System.out.println(stringWord.charAt(5));
		System.out.println(stringWord);
		System.out.println(stringWord.codePointAt(1)); //"녕"
		System.out.println(stringWord.concat("리까리"));
		System.out.println(stringWord +"리까리"); //concat보다 이걸 더 권장
		System.out.println(stringWord.contains("안녕"));
		//stringWord에 주어진 문자열이 들어있는지 비교하여 boolean값을 반환
		char[] chaArr = {'a', 'b', 'c'};
		System.out.println(String.copyValueOf(chaArr, 0, 2));
		System.out.println(stringWord.endsWith("십니까"));
		/*파일 조작에서 확장자로 끝나는 파일들만을 선별하고자 할 때
		*임의의 폴더를 읽어서 file list를 유사 배열로 만든다.
		*배열의 개수만큼 반복하여 조건문(if)으로 파일이름의 확장자가 .png .jpg .gif 등을 판단해 따로저장(list = 유사배열)
		*=> json형태로 만들고 javaScript에서 활용한다.
		*/
		String data = "hyeonjoong";
		System.out.println(data.equalsIgnoreCase("HYEONjoong")); //대소문자 상관없이 비교
		System.out.println(data.toUpperCase().equals("HYEONjoong".toUpperCase()));
		
		byte[] byteArr = data.getBytes(); //영문문자열를 바이트배열로
		System.out.println(byteArr.length + "\t" + (char)byteArr[1]);
		
		byte[] stringWordByteArr = stringWord.getBytes(); //한글문자열를 바이트배열로 (X)
		System.out.println(stringWordByteArr.length + "\t" + stringWordByteArr[1]);
		
		char[] stringWordCharArr = stringWord.toCharArray(); //한글문자열를 캐릭터배열로 (O)
		System.out.println(stringWordCharArr.length + "\t" + stringWordCharArr[1]);

		System.out.println((stringWord.indexOf("안녕하") == -1)? "찾는 단어가 없다.":"찾는 단어가 있다.");
		//한글문자열에서 값이 몇번째에 있는지 인덱스값으로 반환
		
		System.out.println("stringWord안에 들어있는 글자수 : " + stringWord.length());
		
		String[] words = stringWord.split("\\s+"); // \\s : 공백, + : 1개 이상~
		System.out.println(words.length);
		System.out.println(words[0]);
		System.out.println("부분문자 얻기 : " + stringWord.substring(1)); // 인덱스1부터 끝까지 출력
		System.out.println("부분문자 얻기 : " + stringWord.substring(2,6)); //인덱스 2부터 6까지 출력
		
		String trimData = "              Hyeon              ";
		System.out.println(trimData.trim());
		
	}
}
