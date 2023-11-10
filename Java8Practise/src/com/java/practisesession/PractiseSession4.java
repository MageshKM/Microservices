package com.java.practisesession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

interface Math {
	int add(int a, int b);

	public static String getStatus() {
		return "working";
	}
}

public class PractiseSession4 {

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b); // 55
		System.out.println("Sum = " + sum);
		int total = Arrays.stream(numbers).sum();
		System.out.println("total = " + total);
		OptionalInt optionalInt = Arrays.stream(numbers).max();
		System.out.println("Max = " + optionalInt.getAsInt());
		OptionalDouble optionalAvg = Arrays.stream(numbers).average();
		System.out.println("Avg = " + optionalAvg.getAsDouble());
		OptionalInt optionalMin = Arrays.stream(numbers).min();
		System.out.println("Min = " + optionalMin.getAsInt());
		System.out.println("-----------------Statistics-------");
		IntSummaryStatistics statics = Arrays.stream(numbers).summaryStatistics();
		System.out.println("Avg :" + statics.getAverage());
		System.out.println("Count :" + statics.getCount());
		System.out.println("Max :" + statics.getMax());
		System.out.println("Min :" + statics.getMin());
		System.out.println("Total :" + statics.getSum());
		System.out.println("-----------------END-------");

		int sum2 = Arrays.stream(numbers).reduce(0, Integer::sum); // 55
		System.out.println("Sum = " + sum2);
		int sum3 = Arrays.stream(numbers).reduce(0, (a, b) -> a - b); // -55
		System.out.println("Sum = " + sum3);
		int sum4 = Arrays.stream(numbers).reduce(0, (a, b) -> a * b); // 0, initial is 0, 0 * whatever = 0
		System.out.println("Sum = " + sum4);
		int sum5 = Arrays.stream(numbers).reduce(0, (a, b) -> a / b);
		System.out.println("Sum = " + sum5);

		Math calcu = (i, j) -> i + j;
		int output = calcu.add(1, 2);
		System.out.println("Output :" + output + "output :" + Math.getStatus());

		String[][] array = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };

		String[] result = Stream.of(array).flatMap(Stream::of).toArray(String[]::new);
		System.out.println("Result :" + Arrays.toString(result));
		List<String> result2 = Stream.of(array).flatMap(Stream::of).collect(Collectors.toList());
		System.out.println(result2);

		Integer[][] nestedAry = new Integer[][] { { 1, 2 }, { 2, 3 }, { 3, 5 } };
		int[][] nA = { { 1, 2 }, { 1, 2 } };
		int[] intPrm = Arrays.asList(nA).stream().flatMapToInt(IntStream::of).toArray();
		System.out.println("IntPrm :"+Arrays.toString(intPrm));
		
		List<List<Integer>> nestAry =Arrays.asList(Arrays.asList(1,4,3,2,5),Arrays.asList(1,32,3,4));
		List<Integer> consolidated = nestAry.stream().flatMap( list -> list.stream()).collect(Collectors.toList());
		System.out.println("Consolidate :"+consolidated);

		

		// 2d array input
		int[][] input = { { 3, 2, 7 }, { 12, 2, 6 }, { 4, 3, 0 }, { 7, 3, 1 } };
		Arrays.stream(flattenArrayJDK8(input)).forEach(i -> System.out.println(i + " "));

		//flattenArray(input).stream().forEach(i -> System.out.print(i + " "));

		//oneDArray(input).stream().forEach(i -> System.out.print(i + " "));
		System.out.println("Msg:"+ sendMsg("Hi Bubble"));
		System.out.println("Msg:"+ sendMsg(null));
	}
	
	public static String sendMsg( String mayBeNothing) {
		   return Optional.ofNullable(mayBeNothing).orElse("Really Nothing");
		}

	public static List<Integer> flattenArray(int[][] array) {
		List<Integer> oneDimensionalArray = new ArrayList<>();
		for (int[] row : array) {
			for (int col : row) {
				// flattened 1D array
				oneDimensionalArray.add(col);
			}
		}
		return oneDimensionalArray;
	}

	public static int[] flattenArrayJDK8(int[][] array) {
		// flattened 1D array
		int[] intArray = Stream.of(array).flatMapToInt(IntStream::of).toArray();
		return intArray;
	}

	public static List<Integer> oneDArray(int[][] array) {
		List<Integer> oneDimensionalArray = new ArrayList<>();
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++)
				oneDimensionalArray.add(array[row][col]);
		}
		return oneDimensionalArray;
	}

}
