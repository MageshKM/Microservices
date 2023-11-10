package com.java.practisesession;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeNumberDemo {

	public static void main(String[] args) { 

	        long count = Stream.iterate(0, n -> n + 1)
	                .limit(1000)
	                .filter(PrimeNumberDemo::isPrime)
	                .peek(x -> System.out.format("%s\t", x))
	                .count();

	        System.out.println("\nTotal: " + count);

	    }

	    public static boolean isPrime(int number) {

	        if (number <= 1) return false; // 1 is not prime and also not composite

	        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
	    }

	}