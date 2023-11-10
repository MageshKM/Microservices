package com.java8.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapStreamDemo {
	public static void main(String[] args) {
		ArrayList<String> fruit = new ArrayList<>();
		fruit.add("Apple");
		fruit.add("mango");
		fruit.add("pineapple");
		fruit.add("kiwi");
		System.out.println("List of fruit-" + fruit);

		// lets use map() to convert list of fruit
		List list = fruit.stream().map(s -> s.length()).collect(Collectors.toList());
		System.out.println("List generated by map-" + list);

		Function<String, String> validStrLen = (s1) -> {
			if (s1.length() > 5)
				return s1;
			else
				return "NA";
		};
		List<String> appendList = fruit.stream().map(validStrLen).collect(Collectors.toList());
		System.out.println("Transformed Data" + appendList);

	}
}