package com.java.practisesession;

import java.util.stream.IntStream;

public class IterateTest {
	public static void main(String args[]) {
		int ii = IntStream.range(1, 10).reduce(0 , (i,j) -> i+j);
		System.out.println(ii);
		//i.forEach(System.out::println);
		
		
	}

}
