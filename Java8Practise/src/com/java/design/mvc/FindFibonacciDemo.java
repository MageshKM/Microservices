package com.java.design.mvc;

import java.util.stream.Stream;

public class FindFibonacciDemo {
public static void main(String args[]) {
	Stream.iterate(new int[] { 0, 1 }, n -> new int[] { n[1], n[0] + n[1] }).limit(10).map(n -> n[0]).forEach(System.out::println);
}
}
