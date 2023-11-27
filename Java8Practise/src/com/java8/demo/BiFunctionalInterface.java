package com.java8.demo;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;

public class BiFunctionalInterface {
	public static void main(String args[]) {
		BiPredicate<Integer, Integer> comparsion = (a, b) -> a > b;

		System.out.println(comparsion.test(12, 2));

		BiFunction<String, String, String> bifun = (str1, str2) -> str1.concat(" " + str2);

		System.out.println(bifun.apply("Magesh", "Kumar"));

		BiConsumer<String, String> display = (s1, s2) -> {
			System.out.println(" S1 :" + s1);
			System.out.println(" S2 :" +s2);
		};

		display.accept("Lord", "Shiva");
		
		
		BinaryOperator<String> input = (s, s1) -> s.concat(" "+s1);
		System.out.println(input.apply("Magesh", "Kumar"));

	}

}
