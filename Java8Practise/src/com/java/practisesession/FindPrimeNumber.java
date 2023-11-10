package com.java.practisesession;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindPrimeNumber {
	public static void main(String args[]) {
		IntStream intStrm = IntStream.range(1, 20);
		List<Integer> primeList = intStrm.filter(FindPrimeNumber::isPrime).boxed().collect(Collectors.toList());
		primeList.forEach(System.out::println);
	}

	public static boolean isPrime(int i) {
		IntPredicate isDivisible = index -> i % index == 0;
		return i > 1 && IntStream.range(2, i).allMatch(isDivisible);
	}

	
}
