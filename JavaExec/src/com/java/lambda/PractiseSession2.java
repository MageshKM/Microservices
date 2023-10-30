package com.java.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PractiseSession2 {
	public static void main(String args[]) {
		System.out.println("-------Example1");
		// --skip Example
		IntStream rangStream = IntStream.range(1, 11).skip(5);
		rangStream.forEach(System.out::println);

		System.out.println("-------Example2");
		// --Sum
		int total = IntStream.range(1, 11).sum();
		System.out.println("Result:" + total);

		System.out.println("-------Example4");
		// --sorted function
		Stream.of("name", "age", "address").sorted().findFirst().ifPresent(System.out::println);

		System.out.println("-------Example4");
		// Convert to array to stream to do reverse order
		String[] namelist = { "Mag", "kum", "Raju", "Ganesh", "Muruga" };
		Stream.of(namelist).sorted(Collections.reverseOrder()).forEach(System.out::println);

		System.out.println("-------Example5");
		Stream.of(namelist).filter(x -> x.startsWith("M")).forEach(System.out::println);

		System.out.println("-------Example6");
		Arrays.stream(new int[] { 1, 2, 3, 4 }).map(x -> x * x).average().ifPresent(System.out::println);

		System.out.println("-------Example7");
		String[] namelist1 = { "Mag", "kum", "Raju", "Ganesh", "Muruga" };
		Stream.of(namelist1).map(String::toUpperCase).filter(x -> x.contains("M")).forEach(System.out::println);

		System.out.println("-------Example8");
		try {
			Stream<String> lines = Files.lines(Paths.get("namelist.txt"));
			lines.filter(l -> l.startsWith("L")).forEach(System.out::println);
			lines.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("-------Example9");
		double tot = Stream.of(1.2, 1.4, 1.5).reduce(0.0, (Double a, Double b) -> a + b);
		System.out.println("Total :" + tot);

		System.out.println("-------Example10");
		IntSummaryStatistics summary = IntStream.of(1, 2, 6, 7, 9).summaryStatistics();
		System.out.println("Int Summary :" + summary);

		System.out.println("-------Example11");
		Function<Integer, Integer> sqFun = i -> i * i;
		System.out.println(sqFun.apply(5));

		System.out.println("-------Example12");
		Predicate<Integer> check = i -> i % 2 == 0;
		System.out.println(check.test(4));

		System.out.println("-------Example13");
		Function<Integer, Integer> calc = i -> i * 5;
		System.out.println(calc.apply(9));

		System.out.println("-------Example14");
		Consumer<String> consumer = PractiseSession2::printNames;
		consumer.accept("C++");
		consumer.accept("Java");
		consumer.accept("Python");
		consumer.accept("Ruby On Rails");

		System.out.println("-------Example15");
		Consumer<String> conOps = (c) -> System.out.println("Consumered Value :" + c);
		conOps.accept("Magesh");

		System.out.println("-------Example16");
		Supplier<Integer> supplier = () -> 8 * 9;
		System.out.println("Supplier :" + supplier.get());

		Predicate<Integer> greaterthanCondition = i -> i > 5;

		boolean conCheck = greaterthanCondition.test(2);
		System.out.println("Check :" + conCheck);

	}

	private static void printNames(String name) {
		System.out.println(name);
	}

}
