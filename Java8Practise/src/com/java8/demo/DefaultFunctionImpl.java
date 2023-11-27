package com.java8.demo;

public class DefaultFunctionImpl {
	public static void main(String args[]) {
		DefaultFunction<Integer, Integer, Integer> c = (a, b) -> a * b;

		System.out.println(c.add(3, 25));
		System.out.println(c.multiple(12).apply(2));
		
		Runnable r1 = () -> System.out.println("running");
	}

}
