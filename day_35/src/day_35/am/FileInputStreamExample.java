package day_35.am;

import java.io.FileInputStream;

public class FileInputStreamExample {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(
					"D:\\Hyeonjoong\\Java_H\\day_35\\bin\\day_35\\am\\FileInputStreamExample.java");
			int data;
			//1byte씩 읽고 콘솔에 출력
			while ( (data = fis.read()) != -1) {
				System.out.write(data);
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
