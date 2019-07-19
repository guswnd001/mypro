package test;

import java.util.Scanner;

public class NumberPrint {

	public static void main(String[] args) {

		int num = numberInput();
		numberOutput(num);
		
	}
	
	public static int numberInput() {
		Scanner scan = new Scanner(System.in);
		System.out.print("출력할 네자리 수를 입력해주세요 > ");
		int a = scan.nextInt();
		boolean run = true;
		while (run) {
			if ((int)(Math.log10(a)+1) == 4 ) {
				run = false;
			} else {
				System.out.print("다시 네자리 수를 입력해주세요 > ");
				a = scan.nextInt();
			}
		}
		return a;
		
	}
	
	public static void numberOutput(int num) {
		
		String numToStr = String.valueOf(num);
		char[] strToArr = numToStr.toCharArray();

		String[] zero = { " *** ", "*   *", "*   *", "*   *", " *** " };
		String[] one = { "  *  ", " **  ", "  *  ", "  *  ", " *** " };
		String[] two = { " *** ", "*   *", "   * ", "  *  ", "*****" };
		String[] three = { " *** ", "*   *", "  ** ", "*   *", " *** " };
		String[] four = { "  ** ", " * * ", "*****", "   * ", "   * " };
		String[] five = { " ****", " *   ", " *** ", "    *", " *** " };
		String[] six = { "  ** ", " *   ", " *** ", "*   *", " *** " };
		String[] seven = { " ****", "   * ", "  *  ", "  *  ", "  *  " };
		String[] eight = { " *** ", "*   *", " *** ", "*   *", " *** " };
		String[] nine = { " *** ", "*   *", " ****", "    *", " *** " };

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < strToArr.length; j++) {
				switch (strToArr[j]) {
				case '0': System.out.print(zero[i]);
					break;
				case '1': System.out.print(one[i]);
					break;
				case '2': System.out.print(two[i]);
					break;
				case '3': System.out.print(three[i]);
					break;
				case '4': System.out.print(four[i]);
					break;
				case '5': System.out.print(five[i]);
					break;
				case '6': System.out.print(six[i]);
					break;
				case '7': System.out.print(seven[i]);
					break;
				case '8': System.out.print(eight[i]);
					break;
				case '9': System.out.print(nine[i]);
					break;
				
				}
			}
			System.out.println();
		}
		
		
	}
	
}














