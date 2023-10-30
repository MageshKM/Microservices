package com.java.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindOddEvenNumbers {

	public static void main(String args[]) throws InterruptedException {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		Predicate<Integer> formulaEVENNumber = n -> n % 2 == 0;
		Predicate<Integer> formualODDNumber = n -> n % 2 != 0;
		System.out.println("--------------EVEN Number-----------");
		numbers.stream().filter(formulaEVENNumber).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("-------------- PRIME Number ---------------");
		numbers.stream().filter(formualODDNumber).collect(Collectors.toList()).forEach(System.out::println);

		IntStream genNumber = IntStream.range(1, 100);
		IntStream genNumber1 = IntStream.range(1, 100);
		IntPredicate formulaE = n -> n % 2 == 0;
		IntPredicate formulaO = n -> n % 2 != 0;
		genNumber.filter(formulaE).boxed().collect(Collectors.toList()).forEach(System.out::println);
		genNumber1.filter(formulaO).boxed().collect(Collectors.toList()).forEach(System.out::println);

		IntStream randomNumber = IntStream.range(1, 1000);
		randomNumber.filter(FindOddEvenNumbers::isNumber).boxed().collect(Collectors.toList())
				.forEach(System.out::println);

		Supplier<Date> supplyDate = () -> new Date();

		Date d = supplyDate.get();

		Consumer<String> appendTitle = (s) -> System.out.println(s);

		System.out.println("Date :" + d);
		//.sleep(10000);
		System.out.println("Date :" + d);

		appendTitle.accept("God is Great!!");

		List<String> list = Arrays.asList("Magesh", "Kumar", "Rajesh");

		Consumer<List<String>> result = (ll) -> ll.forEach(System.out::println);

		result.accept(list);

		Consumer<List<Integer>> dispList = listObj -> listObj.stream().forEach(a -> System.out.print(a + " "));

		/***********************AND OR ************************/
		
		
		Predicate<String> startsWithA = (text) -> text.startsWith("A");
		Predicate<String> endsWithX   = (text) -> text.endsWith("x");

		Predicate<String> composed = startsWithA.and(endsWithX);

		String input = "A hardworking person must relax";
		boolean reslt = composed.test(input);
		System.out.println(reslt);
		
		/**************** Compose method Sample ****************/
		
		Function<Integer, Integer> multiply = (value) -> value * 2;     
		Function<Integer, Integer> add      = (value) -> value + 3;

		Function<Integer, Integer> addThenMultiply = multiply.compose(add);

		Integer result1 = addThenMultiply.apply(3);
		System.out.println(result1);
		
		/***********************andThen**************/

		Function<Integer, Integer> multiplyThenAdd = multiply.andThen(add);

		Integer result2 = multiplyThenAdd.apply(3);
		System.out.println(result2);
		
		/***************Custom Logic*******/
		Function<Integer, String> covertToStr = (i) -> "ID"+i;
		
		Function<String, String> convertStr = (str) -> "String Message UserName: "+str;
		System.out.println(convertStr.apply("Magesh Kumar"));
		
		
		/*************************Function Example******************/
		Function<Integer, Integer> half = (a) -> a - 3;
		Function<Integer, Integer> twice = (a) -> a + 1;
		  
		Function<Integer, Integer> squareAndThenCube = twice.andThen(half);
		Integer result3 = squareAndThenCube.apply(5);
		System.out.println(result3);
		  
		Function<Integer, Integer> squareComposeCube = half.compose(twice);
		Integer result5 = squareComposeCube.apply(9);
		System.out.println(result5);

	}

	private static boolean isNumber(int i) {
		if (i % 5 == 0)
			return true;
		else
			return false;
	}

}
