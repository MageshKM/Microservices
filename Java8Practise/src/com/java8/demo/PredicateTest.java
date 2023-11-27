package com.java8.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PredicateTest {
	public static void main(String argsp[]) {
		Predicate<String> startWithCond = (s) -> s.startsWith("m");
		Predicate<String> endWithCond = (s) -> s.endsWith("r");

		Predicate<String> condCheck = startWithCond.and(endWithCond);
		boolean output = condCheck.test("mageshe");
		System.out.println(output);

		Function<String, String> concatName = (name) -> name.concat(" Gowda");

		System.out.println(concatName.apply("Magesh"));

		Stream.of("Magesh", "Kumar", "Rajesh").map(concatName).forEach(System.out::println);

		Stream.iterate(0, n -> n + 1).limit(21).forEach(System.out::println);
		int op = IntStream.range(0, 20).boxed().reduce(0, (i, j) -> (i + j));
		System.out.println("Output :" + op); 
		
		Stream<List<Integer>> consolidateList = Stream.of(Arrays.asList(1,3,4,6,7),Arrays.asList(9,25,14,51));
		
		consolidateList.flatMap(list -> list.stream()).sorted(Collections.reverseOrder()).forEach(System.out::println);

	}

}
