package com.java8.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PractiseSession2 {

	public static void main(String[] args) {
		System.out.println(
				"1). Given a list of integers, find out all the numbers starting with 1 using Stream functions?----------------");

		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		myList.stream().map(s -> s + "") // Convert integer to String
				.filter(s -> s.startsWith("1")).forEach(System.out::println);

		System.out.println(
				"2). How to find duplicate elements in a given integers list in java using Stream functions?----------------");

		myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		Set<Integer> set = new HashSet();
		myList.stream().filter(n -> !set.add(n)).forEach(System.out::println);

		System.out.println(
				"3). Given the list of integers, find the first element of the list using Stream functions?----------------");
		myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		myList.stream().findFirst().ifPresent(System.out::println);

		System.out.println(
				"4). Given a list of integers, find the total number of elements present in the list using Stream functions?----------------");
		myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		long count = myList.stream().count();
		System.out.println(count);

		System.out.println(
				"5). Given a list of integers, find the maximum value element present in it using Stream functions?----------------");
		myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		int max = myList.stream().max(Integer::compare).get();
		System.out.println(max);

		System.out.println(
				"6). Given a String, find the first non-repeated character in it using Stream functions?----------------");
		String input = "Java articles are Awesome";

		Character result = input.chars() // Stream of String
				.mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() == 1L).map(entry -> entry.getKey()).findFirst()
				.get();
		System.out.println(result);

		System.out.println(
				"7). Given a String, find the first repeated character in it using Stream functions?----------------");
		result = input.chars() // Stream of String
				.mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() > 1L).map(entry -> entry.getKey()).findFirst()
				.get();
		System.out.println(result);

		System.out.println(
				"8). Given a list of integers, sort all the values present in it using Stream functions?----------------");
		myList.stream().sorted().forEach(System.out::println);

		System.out.println(
				"9).Given a list of integers, sort all the values present in it in descending order using Stream functions?----------------");
		myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

		System.out.println(
				"9).Given a list of integers, sort all the values present in it in descending order using Stream functions?----------------");
		int[] values = { 1, 2, 3, 4, 5, 1 };
		System.out.println("Is Duplicate Contains :" + isDuplicate(values));

		System.out.println(
				"10). How will you get the current date and time using Java 8 Date and Time API?----------------");
		System.out.println("Current Local Date: " + java.time.LocalDate.now());
		// Used LocalDate API to get the date
		System.out.println("Current Local Time: " + java.time.LocalTime.now());
		// Used LocalTime API to get the time
		System.out.println("Current Local Date and Time: " + java.time.LocalDateTime.now());
		// Used LocalDateTime API to get both date and time

		System.out.println("11). Write a Java 8 program to concatenate two Streams?----------------");

		List<String> list1 = Arrays.asList("Java", "8");
		List<String> list2 = Arrays.asList("explained", "through", "programs");

		Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());

		// Concatenated the list1 and list2 by converting them into Stream

		concatStream.forEach(str -> System.out.print(str + " "));

		// Printed the Concatenated Stream

		System.out.println(
				"12).Java 8 program to perform cube on list elements and filter numbers greater than 50.----------------");

		List<Integer> integerList = Arrays.asList(4, 5, 6, 7, 1, 2, 3);
		integerList.stream().map(i -> i * i * i).filter(i -> i > 50).forEach(System.out::println);

		System.out.println(
				"13).Write a Java 8 program to sort an array and then convert the sorted array into Stream?.----------------");

		int arr[] = { 99, 55, 203, 99, 4, 91 };
		Arrays.parallelSort(arr);
		Arrays.stream(arr).forEach(n -> System.out.print(n + " "));

		System.out.println(
				"14).Write a Java 8 program to sort an array and then convert the sorted array into Stream?.----------------");
		List<String> nameLst = list2.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(nameLst);

		System.out.println(
				"15). Write a Java 8 program to sort an array and then convert the sorted array into Stream?----------------");
		// int arr[] = { 99, 55, 203, 99, 4, 91 };
		Arrays.parallelSort(arr);
		Arrays.stream(arr).forEach(n -> System.out.print(n + " "));

		System.out.println("16). How to use map to convert object into Uppercase in Java 8?----------------");
		nameLst = list2.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(nameLst);

		System.out.println(
				"17). How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?----------------");

		List<Notes> noteLst = new ArrayList<>();
		noteLst.add(new Notes(1, "note1", 11));
		noteLst.add(new Notes(2, "note2", 22));
		noteLst.add(new Notes(3, "note3", 33));
		noteLst.add(new Notes(4, "note4", 44));
		noteLst.add(new Notes(5, "note5", 55));

		noteLst.add(new Notes(6, "note4", 66));

		Map<String, Integer> notesRecords = noteLst.stream()
				.sorted(Comparator.comparingLong(Notes::getTagId).reversed()).collect(Collectors.toMap(
						Notes::getTagName, Notes::getTagId, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

		System.out.println("Notes : " + notesRecords);

		System.out.println("18). How to count each element/word from the String ArrayList in Java8?----------------");
		List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
		Map<String, Long> mapObj = names.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println("Map Object : " + mapObj);

		System.out.println("19). How to count each element/word from the String ArrayList in Java8?----------------");

		Map<String, Long> namesCount = names.stream().filter(x -> Collections.frequency(names, x) > 1)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(namesCount);

		System.out.println("20). Write a Program to find the Maximum element in an array?----------------");
		int maxOutput = findMaxElement(arr);
		System.out.println(maxOutput);

		System.out.println("21). Write a program to print the count of each character in a String?----------------");
		String name = "mageshkumarm";
		Map<String, Long> map = Arrays.stream(name.split("")).map(String::toLowerCase)
				.collect(Collectors.groupingBy(str -> str, LinkedHashMap::new, Collectors.counting()));
		System.out.println(map);

	}

	public static int findMaxElement(int[] arr) {
		return Arrays.stream(arr).max().getAsInt();
	}

	private static boolean isDuplicate(int[] value) {
		List<Integer> list = Arrays.stream(value).boxed().collect(Collectors.toList());
		Set<Integer> numSet = new HashSet<Integer>(list);

		if (numSet.size() == list.size())
			return false;
		else
			return true;

	}

}

class Notes {
	int tagId;
	String tagName;
	int price;

	public Notes(int tagId, String tagName, int price) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
		this.price = price;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
