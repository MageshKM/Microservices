package com.java.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindIterator {

	public static void main(String args[]) {
		List<String> apples = Arrays.asList("Macintoshllkk", "Fuji", "Gala", "Jonagold");

		/*-------------------------traditional way-------------------------*/
		boolean noneMatch = true;
		for (String apple : apples) {
			if (apple.length() > 10) {
				noneMatch = false;
				break;
			}
		}
		System.out.println("any apple name length greater then 10 = " + noneMatch);

		/*-------------------------noneMatch-------------------------*/
		noneMatch = apples.stream().noneMatch(str -> str.length() > 10);
		System.out.println("any apple name length greater then 10 = " + noneMatch);
		
		Predicate<String> rule = val -> val.length() > 10;
		apples.stream().filter(rule).collect(Collectors.toList()).forEach(System.out::println);

	}
	
}
