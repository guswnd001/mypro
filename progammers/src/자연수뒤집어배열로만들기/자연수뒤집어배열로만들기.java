package 자연수뒤집어배열로만들기;


public class 자연수뒤집어배열로만들기 {

	public static void main(String[] args) {
		
		long n = 54263;

		
		String[] arr = Long.toString(n).split("");
		int[] answer = new int[arr.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = Integer.parseInt(arr[arr.length-1-i]);
		}
		
//		String str = n + "";
//		int[] answer = new int[str.length()];
//		int index = 0;
//		
//		while (n > 0) {
//			answer[index] = (int) (n % 10);
//			n /= 10;
//			index++;
//		}
		
//		String str = n + "";
//		int[] answer = new int[str.length()];
//		for (int i = 0; i < answer.length; i++) {
//			answer[i] = (int) (n % 10);
//			n /= 10;
//		}
		
		for (int a : answer) {
			System.out.print(a + ",");
		}
		
				
	}

}


