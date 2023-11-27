package com.java8.demo;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PrimeTest {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please entery the input value :");
		int input = scanner.nextInt();

		IntStream.range(1, input).filter(PrimeTest::isPrime).forEach(System.out::println);
		;
	}

	private static boolean isPrime(int number) {
		return number > 1 && IntStream.range(2, number).noneMatch(i -> (number % i) == 0);
	}
}
