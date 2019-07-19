package day_35.pm;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample {

	public static void main(String[] args) throws Exception{
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		
		int readCharNo;
		char[] cbuf = new char[100];
		while ( (readCharNo = reader.read(cbuf)) != -1) {
//			for (int i = 0; i < readCharNo; i++) {
//				System.out.print(cbuf[i] + "=" + (int)(cbuf[i]) + " ");
//			}
			String data = new String(cbuf, 0, readCharNo);
			System.out.println(data);
		}
		reader.close();
	}

}
