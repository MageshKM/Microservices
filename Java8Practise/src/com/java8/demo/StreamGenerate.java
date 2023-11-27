package com.java8.demo;

import java.util.Random;
import java.util.stream.Stream;

public class StreamGenerate {
	public static void main(String args[]) {
		Stream.generate(new Random()::nextDouble).limit(5).forEach(System.out::println);
	}
}
