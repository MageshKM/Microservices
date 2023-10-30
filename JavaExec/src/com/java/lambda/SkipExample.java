package com.java.lambda;

import java.util.stream.Stream;

public class SkipExample {

	public static void main(String args[]) {
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(i -> i % 2 == 0).skip(1)
				.forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(i -> i % 2 == 0).limit(3)
		.forEach(i -> System.out.print(i + " "));
	}

}
