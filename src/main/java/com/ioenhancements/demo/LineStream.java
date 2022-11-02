package com.ioenhancements.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;



public class LineStream {

	public static void main(String[] args) {
		Path path = Paths.get("data.txt");
		Stream<String> lineStream = null;
		try {
			lineStream = Files.lines(path);
			lineStream.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
