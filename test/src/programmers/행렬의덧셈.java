package programmers;

public class 행렬의덧셈 {

	public static void main(String[] args) {
		int[][] arr1 = { {1, 2}, {2, 3} };
		int[][] arr2 = { {3, 4}, {5, 6} };
		
		;
		System.out.println();
	}
	
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = arr1;
		
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				answer[i][j] += arr2[i][j];
			}
		}
		
		return answer;
	}

}
