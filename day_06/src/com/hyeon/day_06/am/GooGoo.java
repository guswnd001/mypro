package com.hyeon.day_06.am;

public class GooGoo {

	public static void main(String[] args) {
		
		int lineCnt = 3;
			
		for (int i = 1; i < 10; i += lineCnt) {
			System.out.print(i + "단을 구해봅시다.\t");
			System.out.print((i+1) + "단을 구해봅시다.\t");
			System.out.println((i+2) + "단을 구해봅시다.");

			for (int j = 1; j < 10; j++) {
//				System.out.print(i + " x " + j + " = " + i*j + "\t\t");
//				System.out.println((i+1) + " x " + j + " = " + (i+1)*j + "\t\t");
//				System.out.println((i+2) + " x " + j + " = " + (i+2)*j);
				//아래의 문장을 독립된 메소드로 분리하면 3중 for문을 2중 for문의 구조로 바꿀 수 있다.
				for (int k = i; k < i+lineCnt; k++) {
					if (k >9) break;
					System.out.print(k + " x " + j + " = " + k*j + "\t\t");
				}
				System.out.println();
			
			}
		// [\n] : 줄바꿈 그냥 다음줄 | [\r] : 다음줄로 바뀌면서 맨 처음으로(= Enter키)
			System.out.println("\n\n");
		}
	}
			
}


