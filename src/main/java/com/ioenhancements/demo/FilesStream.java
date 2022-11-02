package com.ioenhancements.demo;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;

public class FilesStream {
	public static void main(String args[]) {
//		listMethod();
		walkMethod();
	}

	private static void walkMethod() {
		Path start = Paths.get(".");
		try(Stream<Path> walk = Files.walk(start, Integer.MAX_VALUE, FileVisitOption.FOLLOW_LINKS)) {
			walk.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void listMethod() {
		try {
			Stream<Path> pathStream = Files.list(Paths.get("."));
			
			System.out.println("Before filtering");
			pathStream.forEach(System.out::println);
			
			pathStream = Files.list(Paths.get("C:\\Users\\Hrithikesh\\Documents\\"));
			System.out.println("after filtering");
			pathStream.filter(Files::isDirectory).forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
