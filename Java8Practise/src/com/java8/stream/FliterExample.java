package com.java8.stream;

import java.util.Arrays;
import java.util.List;

public class FliterExample {
	public static void main(String args[]) {
		
		List<String> list = Arrays.asList("JAVA", "WELCOME", "Confusion");
		list.stream().filter(n -> n.length() > 4).map(n -> n.toLowerCase()).forEach(System.out::println);
	}

}
