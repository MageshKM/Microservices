package com.java.practisesession;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirstorAny {
	public static void main(String args[]) {
		List<String> lst1 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill", "Dany", "Julia", "Jenish",
				"Divya");
		List<String> lst2 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill", "Dany", "Julia", "Jenish",
				"Divya");

		Optional<String> findFirst = lst1.parallelStream().filter(s -> s.startsWith("D")).findFirst();
		Optional<String> fidnAny = lst2.parallelStream().filter(s -> s.startsWith("J")).findAny();

		System.out.println(findFirst.get()); // Always print David
		System.out.println(fidnAny.get());
	}
}
