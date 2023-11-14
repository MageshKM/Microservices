package com.java.practisesession;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharArray {
	public static void main(String args[]) {
		List<Character> cList = Arrays.asList('5', '8', '9', '1', '2', '2', '3', '$', '%', '*');
		Collections.sort(cList);
		System.out.println(cList);
		List<Integer> nList = Arrays.asList(11, 8, 9, 1);
		// nList.stream().map( c -> (char) c)
		System.out.println("---------------Character Sorting----------------------------");
		String name = "mageshkumar";
		List<Integer> listVal = name.chars().boxed().map(ch -> ch.intValue()).collect(Collectors.toList());
		Collections.sort(listVal);
		System.out.println(listVal);
		int REDIX = 16;
		int i = '1';
		listVal.stream().map(c -> (char) ((int) c)).forEach(System.out::println);

		System.out.println("---------------Printing Duplicate----------------------------");
		Set<Character> setObj = new HashSet<Character>();
		listVal.stream().map(c -> (char) ((int) c)).filter(c -> !setObj.add(c)).forEach(System.out::println);
		long sumCharVal = listVal.stream().reduce(0, (a,b) -> a+b);
		System.out.println("sumCharVal :"+ (char) sumCharVal);

		System.out.println("---------------Group by Characters----------------------------");

		Map<Character, Long> mapObj = listVal.stream().map(c -> (char) ((int) c))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

		System.out.println("GroupBy Character :" + mapObj);
		
		System.out.println("---------------Reduce Method----------------------------");
		String output = listVal.stream().map(c -> Character.toString(c)).reduce("",(a,b) -> (a +"|"+b));
		System.out.println("Added Pile delimiter:" + output);
		
		Stream.of(10,20,22,12,14).reduce(Integer::sum).ifPresent(System.out::println);

		name="this is my home";
		
		Stream.of(name.split("\s")).map(s -> new StringBuilder(s).reverse()).forEach(System.out::print);
	}

}
