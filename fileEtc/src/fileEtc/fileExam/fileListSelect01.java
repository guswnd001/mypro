package fileEtc.fileExam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class fileListSelect01 {

	public static void main(String[] args) {
		
		File file = new File("."); //현재폴더를 파일객체로 생성한다
		File[] currentFileList = file.listFiles(); //현재 폴더의 파일 목록을 구하여 파일배열에 저장
		int fileCnt = currentFileList.length; //현재폴더의 파일 개수를 구한다
		List<String> filterImgFile = new ArrayList<String>();//DB자료를 담아온다
		
		for (int i = 0; i < fileCnt; i++) { //파일 개수만큼 반복
			if (currentFileList[i].isFile()) { //폴더일 경우 수행할 문장
				String fileName = currentFileList[i].getName();
				
				if (fileName.endsWith(".jpg")) {
					filterImgFile.add(fileName);
				}
			
			}
		}
		// filterImgFile의 내용을 JSON객체로 만들어 준다 
		for (String imgFileName : filterImgFile) {
			System.out.println(imgFileName);
		}
		
	}

}
