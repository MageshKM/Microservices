package com.java.practisesession;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IteratorExample {
	public static void main(String args[])
	{
		Stream<Integer> evenNumInfiniteStream = Stream.iterate(0, n -> n + 2);
		
		List<Integer> newList = evenNumInfiniteStream
				.skip(5)
				.limit(10)
				.collect(Collectors.toList());
				
		System.out.println(newList);
	}

}
