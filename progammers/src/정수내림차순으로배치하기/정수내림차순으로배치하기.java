package 정수내림차순으로배치하기;

import java.util.Arrays;
import java.util.Collections;

public class 정수내림차순으로배치하기 {

	public static void main(String[] args) {
		
		long n = 118372;
//		int length = (int) Math.log10(n) + 1;
//		
//		int index = 0;
//		long[] arr = new long[length];
//		while (n != 0) {
//			arr[index] = n % 10;
//			n /= 10;
//			index++;
//		}
//		String str = Integer.toString((int)n);
//		System.out.println(str);
//		
//		for (long l : arr) {
//			System.out.print(l + ",");
//		}
//		
//		int tmp = 0;
		
		String[] arr = Long.toString(n).split("");
		
		for (String string : arr) {
			System.out.print(string + ",");
		}
		
		System.out.println("\n==========================");
		Arrays.sort(arr, Collections.reverseOrder());
		
		for (String string : arr) {
			System.out.print(string + ",");
		}
		
		System.out.println("\n==========================");
		n = Long.parseLong(String.join("", arr));
		System.out.println(n);
		
		
	}

}
