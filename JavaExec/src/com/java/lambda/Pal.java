package com.java.lambda;

import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

class Pal {
	public static void main(String args[]) {
		/*Scanner input = new Scanner(System.in);
		System.out.println("Please Enter your Input :");
		String word = input.next();
		boolean isPal = checkPal(word);
		System.out.println("Output:" + word + " is " + isPal);*/
		
		
		IntStream val = primes(20);
		val.forEach(System.out::println);
	}

	private static boolean checkPal(String pal) {
		if (pal.length() == 0 || pal.length() == 1) {
			return true;
		}
		if (pal.charAt(0) == pal.charAt(pal.length() - 1)) {
			return checkPal(pal.substring(1, (pal.length() - 1)));
		}

		return false;
	}

	
	public static IntStream primes(int max) {
	    IntStream primes = IntStream.range(2, max);
	    IntFunction<IntPredicate> sieve = n -> i -> i == n || i % n != 0;
	    primes = primes.filter(sieve.apply(2));
	    for (int i = 3; i * i <= max; i += 2)
	        primes = primes.filter(sieve.apply(i));
	    return primes;
	}
}