package com.java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
	public static void main(String[] args) {
		String fname = "C:\\workspace\\test.txt";
		try (Stream<String> st = Files.lines(Paths.get(fname))) {
			st.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
