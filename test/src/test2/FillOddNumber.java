package test2;

public class FillOddNumber {

	public static void main(String[] args) {
		
		int[] result = new int[11]; //결과가 들어갈 배열
		int[] randomArr = {1, 2, 3, 4, 5, 6, 7, 8, 9}; //숫자를 가져올 배열
		int randomIndex; //randomArr에서 랜덤으로 숫자를 빼올 인덱스
		boolean run;
		
		//중복되지 않게 2개씩 짝지어 숫자 출력
		for (int i = 0; i < result.length/2; i++) {
			run = true;
			while (run) {
				randomIndex = (int)(Math.random()*9); //0 ~ 8
				if (randomArr[randomIndex] != 0) {
					result[i] = randomArr[randomIndex];
					result[result.length-1-i] = result[i];
					randomArr[randomIndex] = 0;
					run = false;
				}
			}
		}
		
		//가운데 1개의 수 출력
		run = true;
		while (run) {
			randomIndex = (int)(Math.random()*9);
			if (randomArr[randomIndex] != 0) {
				result[5] = randomArr[randomIndex];
				run = false;
			}
		}
		
		//결과 출력
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
