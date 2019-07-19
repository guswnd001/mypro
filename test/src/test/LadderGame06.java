package test;

public class LadderGame06 {

	public static void main(String[] args) {

		LadderOutput(LadderInput());
			
	}
	
	//5부터 12까지 숫자 랜덤부분
	public static int LadderInput() {
		
		int num = (int)(Math.random()*8) + 5; //5부터 12까지의 무작위 수
		return num;
		
	}
	
	// 사다리 출력 부분
	public static void LadderOutput(int num) {
		
		String[][] ladderArr = new String[6][num]; // 행이 6개인 2중 배열 출력
		String[] ladderParts = { "│\t", "├───────", "┤\t" }; // 사다리를 3개로 나누어 배열에 저장
		
		for (int i = 0; i < ladderArr.length; i++) {
			for (int j = 0; j < ladderArr[i].length; j++) {
				if (i == 0) { //사다리 맨 위의 숫자 출력
					ladderArr[i][j] = j+1 + "\t";
				} else if (j == ladderArr[i].length-1) { // 사다리 맨 끝 열  수직으로 사다리 그리기
					ladderArr[i][j] = ladderParts[0];
				} else {	
					ladderArr[i][j] = ladderParts[(int)(Math.random()*2)]; // 나머지 사다리 랜덤
				}
				ladderConnect(ladderArr, ladderParts, i); //사다리 연결메소드 
				System.out.print(ladderArr[i][j]); //사다리 출력
			}
			System.out.println();
		}
		

		// 사다리 결과 숫자 출력
		int[] prtNum = new int[num]; // 결과를 출력할 배열
		for (int i = 0; i < num; i++) { //열부분 반복
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
		for (int j = 0; j < num; j++) { //사다리 결과 출력
			System.out.print(prtNum[j] + "\t");
		}
		
		
	}
	
	// 사다리 잇는 부분
	public static String[][] ladderConnect(String[][] strArr1, String[] strArr2, int num) { //사다리 연결
		
		for (int k = 0; k < strArr1[num].length-1; k++) {
			if (strArr1[num][k] == strArr2[1]) {
				strArr1[num][k+1] = strArr2[2];
			}
		}
		return strArr1;
	}

}
