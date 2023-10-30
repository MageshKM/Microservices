package com.java.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PractiseSession6 {
	
	public static void main(String args[]) {
		int[] ay = { 1, 2, 3, 4, 5 };
		List<Integer> listNum = Arrays.asList(1, 2, 3, 5, 6);

		Optional<Integer> min = listNum.stream().min(Integer::compareTo);
		System.out.println("Min 1:" + min.get());
		OptionalInt min2 = Arrays.stream(ay).min();
		System.out.println("Min 2:" + min2.getAsInt());

		IntStream intStream = IntStream.range(0, 10);
		int output = intStream.reduce(0, (i, j) -> i + j);
		System.out.println("Reduce output:" + output);

		IntStream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

		List<Integer> list = Stream.iterate(0, n -> n + 1).limit(100).toList();// Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8,
																				// 9, 10);

		List<Integer> result = math(list, x -> x * 2, x -> x + 1);

		System.out.println(result); // [3, 5, 7, 9, 11, 13, 15, 17, 19, 21]

		// creating a list of Strings
		List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");
		Optional<String> longestString = words.stream()
				.reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);

		// Displaying the longest String
		longestString.ifPresent(System.out::println);
		
		Map<String, String> hmobj = new LinkedHashMap<String, String>();
		hmobj.put(null, null);
		hmobj.put(null, null);
		System.out.println(hmobj.size());
		
		Set<String> setList = new HashSet<String>();
		setList.add("JAVA");
		setList.add("Welcome");
		
		setList.forEach(System.out::println);
		
		

	}

	public static <T> List<T> math(List<T> list, UnaryOperator<T> uo, UnaryOperator<T> uo2) {
		List<T> result = new ArrayList<>(100);
		for (T t : list) {
			result.add(uo.andThen(uo2).apply(t));
		}
		return result;
	}

}
