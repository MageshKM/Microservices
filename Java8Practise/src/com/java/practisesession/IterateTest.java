package com.java.practisesession;

import java.util.stream.IntStream;
import java.util.stream.Stream;
 

public class IterateTest {
	public static void main(String args[]) {
		int ii = IntStream.range(1, 10).reduce(0 , (i,j) -> i+j);
		System.out.println(ii);
		//i.forEach(System.out::println);
		Stream<Integer> streamIterated = Stream.iterate(1, n -> n*3).limit(4);
	    Stream.iterate(0, n -> n+1).limit(5).forEach(System.out::println);
	    
	    
		
	}

}
