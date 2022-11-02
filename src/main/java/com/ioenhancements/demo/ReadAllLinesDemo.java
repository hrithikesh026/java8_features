package com.ioenhancements.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ReadAllLinesDemo {
	
	public static void main(String[] args) {
//		readAllLinesMethod();
		bufferedReaderMethod();
	}
	private static void bufferedReaderMethod() {
		Path path = Paths.get("data.txt");
		BufferedReader bReader = null;
		try {
			bReader = Files.newBufferedReader(path);
			bReader.lines().forEach(System.out::println);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
	}

	private static void readAllLinesMethod() {
		Path path = Paths.get("data.txt");
		List<String> lineList = null;
		try {
			lineList = Files.readAllLines(path);
			System.out.println(lineList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
