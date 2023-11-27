package com.java8.demo;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MultipleInterface implements Interface1 {

	public static void main(String args[]) {
		MultipleInterface mul = new MultipleInterface();
		mul.run();

		Interface1.print();
		MultipleInterface.print();

		String input = "JAVA J2EE Advanced";

		Predicate<Character> emptyCheck = (c) -> !Character.isWhitespace(c);

		Map<Character, Long> m = input.chars().mapToObj(c -> (char) c).filter(emptyCheck)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(m);
	}

	static void print() {
		System.out.println("Print main Static method");
	}

	public void run() {
		System.out.println("TEST");
	}

}
