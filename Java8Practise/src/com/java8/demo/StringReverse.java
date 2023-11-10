package com.java8.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringReverse {

	public static void main(String args[]) {

		// sample string
		String str = "quick brown fox jumps over lazy dog";


		// reverse a String using Java 8
		String reverseStr = Stream.of(str)
				.map(string -> new StringBuilder(string).reverse())
				.collect(Collectors.joining());


		// print both strings to console
		System.out.println("Original String = " + str);
		System.out.println("Reversed String = " + reverseStr);


		// print both string length to console
		System.out.println("\n\nOriginal String length = " + str.length());
		System.out.println("Reversed String length = " + reverseStr.length());
	}
}
