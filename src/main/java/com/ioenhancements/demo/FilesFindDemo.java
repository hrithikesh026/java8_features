package com.ioenhancements.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesFindDemo {
	public static void main(String args[]) {
		try {
			Path path = Paths.get(".");
			Stream<Path> match = Files.find(path, 10, ((p, BasicFileAttributes) -> {
				return p.getFileName().toString().endsWith(".java");
			}));

			match.forEach(System.out::println);
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
}
