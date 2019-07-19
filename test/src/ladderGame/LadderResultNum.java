package ladderGame;

public class LadderResultNum {
	
	// 사다리 결과 숫자 출력
	public static void ladderResult(int ladderNum, String[][] ladderArr) {
		
		int[] prtNum = new int[ladderNum]; // 결과를 출력할 배열
		for (int i = 0; i < ladderNum; i++) { //열부분 반복
			int x = 1; // 행 이동을 위한 변수
			int y = i; // 열 이동을 위한 변수
			for (int j = 0; j < 5; j++) { //행부분 반복
				if (ladderArr[x][y].equals("│\t")) {
					x++;
				} else if (ladderArr[x][y].equals("├───────")) {
					x++;
					y++;
				} else if (ladderArr[x][y].equals("┤\t")) { 
					x++;
					y--;
				}
			}
			prtNum[y] = i+1; //사다리를 통해 나온 결과를 배열에 초기화
		}
		for (int j = 0; j < ladderNum; j++) { //사다리 순서대로 결과 출력
			System.out.print(prtNum[j] + "\t");
		}
		
	}

	
}
