package test2;

public class FillOddNumber1 {

	public static void main(String[] args) {
		
		int[] result = new int[11];
	
		
		
		//배열 출력
		System.out.print("{");
		for (int i = 0; i < result.length; i++) {
			if (i == result.length-1) {
				System.out.print(result[i]);
			} else {
				System.out.print(result[i] + ",");
			}
		}
		System.out.print("}");
		
		
	}

}
