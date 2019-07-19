package fileEtc.fileExam;

import java.io.File;
import java.util.Date;
//import java.lang.*;

public class fileListSelect {

	public static void main(String[] args) {
		
		File file = new File("."); //현재폴더를 파일객체로 생성한다
		File[] currentFileList = file.listFiles(); //현재 폴더의 파일 목록을 구하여 파일배열에 저장
		int fileCnt = currentFileList.length; //현재폴더의 파일 개수를 구한다
		int fileListCnt = 0;
		int dirListCnt = 0;
		long fileTotalSize = 0L;
		
		for (int i = 0; i < fileCnt; i++) { //파일 개수만큼 반복
			String fileCheck = "     \t";
			long dataClaData = currentFileList[i].lastModified();
			String modifyData = new Date(dataClaData).toString();
			int fileSize = 0;
			
			if (currentFileList[i].isDirectory()) { //폴더일 경우 수행할 문장
				fileCheck = "<DIR>\t";
				dirListCnt++;
			} else { //폴더가 아닐 결우 수행할 문장(파일일 경우 수행할 문장) 
				fileSize = (int)(currentFileList[i].length());
				fileListCnt++;
				fileTotalSize += fileSize;
			}
			System.out.print(modifyData + "\t\t"); //파일생성날짜 출력
			System.out.print(fileCheck); //폴더인지, 파일인지를 출력
			System.out.print((fileSize == 0)? "      ":fileSize + "   "); //파일크기 출력
			System.out.println(currentFileList[i].getName());
				
		}
		System.out.println("\t\t\t" + fileListCnt + "개의 파일\t\t" + + fileTotalSize + " byte");
		long freeSpace = file.getFreeSpace();
		System.out.println("\t\t\t" + dirListCnt + "개의 디렉토리\t" + freeSpace + "byte 남음");
		
	}

}
