package com.java8.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Anon {
	public static void main(String args[]) {

		List<String> listStr = Arrays.asList("Magesh", "Kumar", "Raj", "Ramesh", "Siva");

		Optional<String> output = listStr.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);

		String concate = listStr.stream().reduce("Mr.", (s1, s2) -> s1.concat(" "+s2));
		System.out.println(concate);

		System.out.println("Output :" + output.get());

		int product = IntStream.range(2, 8).peek(System.out::println).reduce((num1, num2) -> num1 * num2).orElse(-1);

		System.out.println("Product :" + product);
	}
}