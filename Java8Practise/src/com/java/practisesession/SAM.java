package com.java.practisesession;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface maths {

	public int addition(int a, int b);
}

public class SAM {
	public static void main(String args[]) {

		maths obj = (a, b) -> a + b;
		int output = obj.addition(1, 9);

		System.out.println(output);
		
		List<Integer> numList = Arrays.asList(1,2,2,3,4,5);
		numList.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
		
		List<String> namelist = Arrays.asList("magesh","kumar","karuna","shiva", "shiva");

		System.out.println("Name Transferred to Upper Case");
		namelist.stream().map(name -> name.toUpperCase()).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("Name Transferred to Lower Case");
		namelist.stream().map(name -> name.toLowerCase()).distinct().collect(Collectors.toList()).forEach(System.out::println);
		
	}
}
