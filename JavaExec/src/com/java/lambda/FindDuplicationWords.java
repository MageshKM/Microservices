package com.java.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicationWords {
	public static void main(String args[]) {
		String sentence = "Welcome to Mphasis and Mphasis";
		List<String> wordsList = Arrays.stream(sentence.split(" ")).collect(Collectors.toList());

		Set<String> tempSet = new HashSet<>();

		/*
		 * List<String> duplicateWords = wordsList.stream() .filter(w ->
		 * !tempSet.add(w)) .collect(Collectors.toList());
		 */

		// System.out.println(duplicateWords);

		List<String> hashMap = wordsList.stream().filter(w -> !tempSet.add(w)).collect(Collectors.toList());
		System.out.println(tempSet);
		System.out.println(hashMap);

		Map<String, Integer> map = Stream.of("bla", "blabla", "blablabla").distinct()
				.collect(Collectors.toMap(Function.identity(), String::length));

		System.out.println(map);

		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

		Map<String, String> mapObj = Stream.of("A", "B", "C", "D").map(e -> {
			String value = e.length() + "_" + e + "Test";
			return value;
		}).collect(Collectors.toMap(Function.identity(), Function.identity()));
		System.out.println(mapObj);
		
		int[] id = {1,2,3,4,5};
		OptionalDouble avg = Arrays.stream(id).average();
		
		System.out.println("Output :"+avg.getAsDouble());
	}

}
