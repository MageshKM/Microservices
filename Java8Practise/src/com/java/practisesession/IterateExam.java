package com.java.practisesession;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IterateExam {
	public static void main(String args[])
	{
		Stream<Integer> streamIterated = Stream.iterate(1, n -> n*3).limit(4);
		streamIterated.forEach(System.out::println);
		Stream<Integer> streamIterated2 = Stream.iterate(1, n -> n*3).limit(4);
		boolean flag = streamIterated2.allMatch( n -> n%3 == 0);
		System.out.println("Flag :"+flag);
		
		/*IntStream rang = IntStream.range(1, 3);
		rang.forEach(System.out::println);
		rang.close();
		
		IntStream rang1 = IntStream.range(1, 10);
		boolean output = rang1.allMatch(n -> n %3 == 0);
		
		System.out.println("output:"+output);*/
		
		
	}

}
