package com.java.practisesession;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderingChars {
	public static void main(String args[]) {
		char[] chars = "Hello, World!".toCharArray();

		// Sort the characters in ascending order.
		Arrays.sort(chars);

		// Print the sorted characters.
		System.out.println(Arrays.toString(chars));
		
		String name ="mageshkumar";
		List<Character> cList = name.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		Collections.sort(cList);
		System.out.println(cList);
 
		List<Character> ccList = Arrays.asList('1','3','7', '@', '#', '9' );
		
		Collections.sort(ccList);
		System.out.println(ccList);
		
		String sentence ="Welcome to java world";
		
		List<String> words = Arrays.asList(sentence.split("\s"));
		
		words.stream().map( w -> new StringBuilder(w).reverse()+" ").forEach(System.out::print);
		

	}
}
