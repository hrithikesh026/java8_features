package com.ioenhancements.demo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

public class WriteFunctionDemo {
public static void main(String[] args) throws IOException   {
		
		Path p1 = Paths.get("data1.txt");
		String s = "This string is written to data1.txt";
		Path write1 = Files.write(p1, s.getBytes(), StandardOpenOption.APPEND);
		System.out.println(write1.toUri().getPath());


		Path p2 = Paths.get("data2.txt");
		List<String> names = new LinkedList<>();
		names.add("KK");
		names.add("PK");
		names.add("PK");
		names.add("PK");
		names.add("KK");
		Path write2 = Files.write(p2, names, Charset.forName("UTF-8"), StandardOpenOption.WRITE);
		System.out.println(write2.toUri().getPath());
		
	}
}
