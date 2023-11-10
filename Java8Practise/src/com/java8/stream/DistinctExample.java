package com.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DistinctExample {
	public static void main(String args[]) {

		List<String> list = Arrays.asList("JAVA", "WELCOME", "java", "JAVA", "APPPLE", "apple");
		list.stream().distinct().forEach(System.out::println);
		System.out.println("-------------------------SORTE-------------------------");
		list.stream().sorted().forEach(System.out::println);
		System.out.println("-------------------------Skip-------------------------");
		list.stream().distinct().skip(2).forEach(System.out::println);
		System.out.println("-------------------------limit-------------------------");
		list.stream().distinct().limit(3).forEach(System.out::println);

		System.out.println("-------------------------Reduce-------------------------");
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		int min = numbers.stream().min(Comparator.comparing(Integer::valueOf)).get();
		System.out.println("MIN :" + min);
		int max = numbers.stream().max(Comparator.comparing(Integer::valueOf)).get();
		System.out.println("MAX :" + max);
		int result = numbers.stream().reduce(10, (subtotal, element) -> subtotal + element);
		System.out.println("Result :" + result);

		int output = numbers.stream().reduce(0, Integer::sum);

		System.out.println("Result :" + output);
		List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
		String output1 = letters.stream().reduce("XX", String::concat);
		System.out.println("Result :" + output1);

		long count = numbers.stream().count();

		// list of characters
		List<Character> chars = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i','z');

		// get minimum char from list of characters
		char minChar = chars.stream().min(Comparator.comparing(Character::charValue)).get();

		System.out.println("1. The Minimum char is = " + minChar);

		// get maximum char from list of characters
		char maxChar = chars.stream().max(Comparator.comparing(Character::charValue)).get();

		System.out.println("2. The Maximum char is = " + maxChar);

	}

}
