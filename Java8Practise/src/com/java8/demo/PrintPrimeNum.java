package com.java8.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintPrimeNum {
	public static void main(String argsp[]) {
		System.out.println(primeNumberInRange(1,200));
	}

	public static List<Integer> primeNumberUntil(int n) {
		return IntStream.rangeClosed(2, n).filter(x -> isPrime(x)).boxed().collect(Collectors.toList());
	}

	public static List<Integer> primeNumberInRange(int startNumber, int endNumber) {
		return IntStream.rangeClosed(startNumber, endNumber).filter(x -> isPrime(x)).boxed()
				.collect(Collectors.toList());
	}

	private static boolean isPrime(int number) {
		return number > 1 && IntStream.range(2, number).noneMatch(i -> number % i == 0);
	}

}
