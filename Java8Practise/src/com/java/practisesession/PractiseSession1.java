package com.java.practisesession;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PractiseSession1 {
	public static void main(String args[]) throws InterruptedException, ExecutionException {

		System.out.println("***********************Map**************");
		Stream<String> strStream = Stream.of("Magesh", "Kumar", "Rajesh");
		strStream.map(name -> name + " Kunar").forEach(System.out::println);

		System.out.println("**********************flatMap**************");
		List<List<String>> nestedList = Arrays.asList(Arrays.asList("A"), Arrays.asList("B"));
		List<String> singleList = nestedList.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
		System.out.println(singleList);

		System.out.println("***********************Reverse Order**************");
		List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);
		numList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

		System.out.println("***********************Find Min**************");
		Optional<Integer> min = numList.stream().min(Integer::compareTo);
		int value = min.get();
		System.out.println(value);

		System.out.println("***********************Find Max**************");
		Optional<Integer> max = numList.stream().max(Integer::compareTo);
		value = max.get();
		System.out.println(value);

		System.out.println("***********************Acculmation**************");
		Integer acculmation = numList.stream().reduce(0, (prev, curr) -> prev + curr);
		System.out.println(acculmation);

		System.out.println("***********************Limit**************");
		numList.stream().limit(3).forEach(System.out::println);

		System.out.println("***********************Skip**************");
		numList.stream().skip(3).forEach(System.out::println);

		System.out.println("***********************Skip**************");
		long count = numList.stream().count();
		System.out.println(count);

		System.out.println("***********************FindFirst**************");
		Optional<Integer> findFirst = numList.stream().findFirst();
		System.out.println(findFirst.get());
		

		System.out.println("***********************Function**************");
		Function<String, String> f1 = (s) -> {
			return s + " Java";
		};
		String output = f1.apply("J2EE");
		System.out.println("Function Output:" + output);

		System.out.println("***********************Consumer**************");
		Consumer<String> consumer = (str) -> {
			System.out.println("String Value:" + str);
		};
		consumer.accept("Radha Krishna");

		System.out.println("***********************Supplier**************");
		Supplier<Instant> supplier = () -> Instant.now();
		System.out.println("TimeNow :" + supplier.get().now());
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("TimeNow :" + supplier.get().now());

		System.out.println("***********************ExecutorService**************");

		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<?> op = executor.submit(() -> {
			System.out.println("Executor Services");
		});
		executor.shutdown();

		System.out.println("***********************CompletableFuture**************");

		Consumer<String> print = (str) -> System.out.println("This is final output : " + str);
		CompletableFuture<String> compFuture = CompletableFuture.supplyAsync(() -> {
			return "Welcome To Java";
		});
		compFuture.thenApply((s) -> s.toUpperCase()).thenAccept(print);

		System.out.println("***********************Predicate**************");

		Predicate<Integer> p1 = i -> i > 2;
		Predicate<Integer> p2 = j -> j < 5;

		boolean result = p1.and(p2).test(3);

		System.out.println("IS 3 fall between 2 to 5 = " + result);

		System.out.println("***********************range**************");
		IntStream range = IntStream.range(0, 100);
		range.filter(n -> n % 2 == 0).boxed().forEach(System.out::print);

		System.out.println("***********************Iterate**************");
		IntStream iterate = IntStream.iterate(1, i -> i + 5).limit(10);
		iterate.forEach(System.out::print);

		System.out.println("***********************Optional**************");
		String[] list = new String[5];
		list[0] = "A";
		list[2] = "B";
		Optional<String> optionalObj = Optional.ofNullable(list[1]);

		if (optionalObj.isPresent()) {
			System.out.println("Value is present");
		} else {
			System.out.println("value is null");
		}

	}

}
