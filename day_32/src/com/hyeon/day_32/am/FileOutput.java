package com.hyeon.day_32.am;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileOutput {

	public static void main(String[] args) throws IOException{
		Path path = Paths.get("D:\\Hyeonjoong\\Java_H\\day_32\\2018년 지하철 호선,역별 승하차 이용객수1.txt");
		Stream<String> stream;
		
		File file = path.toFile();
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		
		stream = br.lines();
		stream.
		
	}

}
