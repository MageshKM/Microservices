package Stream;

import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIterate {
	public static void main(String args[]) {
		System.out.println("---Stream of 0 – 9------");
		Stream.iterate(0, n -> n + 1).limit(10).forEach(x -> System.out.println(x));
		System.out.println("---Stream of odd numbers only.------");
		Stream.iterate(0, n -> n + 1).filter(x -> x % 2 != 0) // odd
				.limit(10).forEach(x -> System.out.println(x));

		System.out.println("---A classic Fibonacci example.------");
//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233
		Stream.iterate(new int[] { 0, 1 }, n -> new int[] { n[1], n[0] + n[1] }).limit(20).map(n -> n[0])
				.forEach(x -> System.out.println(x));

		System.out.println("---Sum all the Fibonacci values..------");

		int sum = Stream.iterate(new int[] { 0, 1 }, n -> new int[] { n[1], n[0] + n[1] }).limit(10).map(n -> n[0]) // Stream<Integer>
				.mapToInt(n -> n).sum();

		System.out.println("Fibonacci 10 sum : " + sum);
		System.out.println("--- all the Fibonacci values..------");
		Stream.iterate(new int[] { 0, 1 }, n -> new int[] { n[1], n[0] + n[1] }).limit(10).map(n -> n[0]).forEach(System.out::println);
		Stream.iterate(1, n -> n + n).limit(10).forEach(System.out::println);
		OptionalDouble i = IntStream.range(0, 10).average();
		System.out.println(i.getAsDouble());
		
		

	}

}
