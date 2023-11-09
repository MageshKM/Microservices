package com.java8.demo;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PractiseSession1 {
	public static void main(String args[]) {
		String name = "magesh, kumar, dhanvith";

		List<String> list = Arrays.asList(name.split(","));
		Map<String, Long> mapObj = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("----------------------------Find Group by count------------------------------");
		System.out.println(mapObj.toString());

		List<Person> persons = Arrays.asList(new Person("Magesh", 18, 15000), new Person("Kumar", 22, 17000),
				new Person("Dhanvith", 20, 65000));

		System.out.println("----------------------------Convert to MapObj------------------------------");
		Map<String, Person> mapObj1 = persons.stream()
				.collect(Collectors.toMap(Person::getName, (Function.identity())));
		System.out.println(mapObj1.toString());
		System.out.println("----------------------------Find Average Salary------------------------------");
		Map<String, Double> map = persons.stream()
				.collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getSalary)));

		System.out.println(map.toString());
		System.out.println("----------------------------Covert List to LinkedHashmp------------------------------");
		LinkedHashMap<String, Integer> linkedObj = list.stream().collect(
				Collectors.toMap(Function.identity(), String::length, (key1, key2) -> key1, LinkedHashMap::new));

		System.out.println(linkedObj.toString());

		System.out.println("----------------------------Covert List to Set------------------------------");
		Set<String> setString = list.stream().collect(Collectors.toSet());
		System.out.println(setString.toString());

		System.out.println("----------------------------Sorted by Age Elements------------------------------");
		Collections.sort(persons);
		persons.stream().forEach((s) -> {
			System.out.println(s.getName() + "\t" + s.getAge());
		});

		System.out.println("----------------------------Sorted by Salary Elements------------------------------");
		Collections.sort(persons, new SortByName());
		persons.stream().forEach((s) -> {
			System.out.println(s.getName() + "\t" + s.getAge() + "\t" + s.getSalary());
		});

		System.out.println("----------------------------Predicate Example------------------------------");
		Predicate<String> predicate = (m) -> m.contains("K");
		boolean output = predicate.test("MageshK");
		System.out.println("output :" + output);

		System.out
				.println("----------------------------Split chars and find count of it------------------------------");
		String nameVal = "mageshkumarm";
		List<Character> listChar = nameVal.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		Map<Character, Long> result = listChar.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(result.toString());

		System.out.println("----------------------------Convert to TreeMap------------------------------");
		Map<Character, Long> result1 = result.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
				Map.Entry::getValue, (oldValue, newValue) -> newValue, TreeMap::new));
		System.out.println(result1.toString());

		System.out.println("----------------------------Any Match------------------------------");
		Stream<String> stream = Stream.of("Geeks", "fOr", "GEEKSQUIZ", "GeeksforGeeks");
		boolean answer = stream.anyMatch(str -> Character.isUpperCase(str.charAt(1))); 
		Stream<String> stream2 = Stream.of("Geeks", "GOr", "GEEKSQUIZ", "GeeksforGeeks");
		boolean answer2 = stream2.allMatch(str -> Character.isUpperCase(str.charAt(0))); 
		System.out.println("AnyMatch :"+answer);
		System.out.println("AllMatch :"+answer2);
	}

}
