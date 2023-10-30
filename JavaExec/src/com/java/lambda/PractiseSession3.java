package com.java.lambda;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PractiseSession3 {
	public static void main(String args[]) throws IOException {
		
		int[] ids = {1,3324,454,4543,34534};
		List<Integer> list = Stream.of(1,2,3,4).collect(Collectors.toList());
		
		System.out.println("Converted List"+ list);
		
		List<Integer> intStream = IntStream.of(ids).boxed().collect(Collectors.toList());
		System.out.println("Converted List"+ intStream);
		
		Consumer<String> display = (t) -> System.out.println(t);
		
		System.out.println("---------------ASC Order--------------");
		intStream.stream().sorted().forEach( System.out::println);
		System.out.println("---------------DESC Order--------------");
		intStream.stream().sorted(Collections.reverseOrder()).forEach( System.out::println);
		System.out.println("---------------Student List Order--------------");
		
		List<Employee> listEmp = Stream.of(new Employee(115,"Magesh",15,"D"), new Employee(28,"Kumar",16,"T"),new Employee(78,"Raj",16,"K")).collect(Collectors.toList());
		
		System.out.println("List:"+ listEmp);
		Collections.sort(listEmp, Employee.getNameSort());
		System.out.println("Sort By id:"+ listEmp);
		Collections.sort(listEmp);
		System.out.println("Sort by Name:"+ listEmp);
		
		String sentence = "Welcome to Mphasis and Mphasis";
		long count = Arrays.stream(ids).count();
		System.out.println(count);
		List<String> wordsList = Arrays.stream(sentence.split(" ")).collect(Collectors.toList());
		System.out.println(wordsList);
		
		Set<String> hset = new HashSet<String>();
		
		//wordsList.stream().filter(s -> !hset.add(s)).forEach(display);

		Map<String, String> mapObj = wordsList.stream().filter(e -> hset.add(e))
				.collect(Collectors.toMap(Function.identity(), Function.identity()));

		System.out.println("Map Obj = " + mapObj);
		
		
		System.out.println("---------------Stream Type--------------");
		Stream<Integer> streamInt = Stream.of(1,2,3,4,5);
		List<Integer> listNum = streamInt.filter( i -> i%2 == 0).collect(Collectors.toList());
		
		System.out.println(listNum);
		
		
		System.out.println("---------------IntStream Type--------------");
		IntStream numStream = IntStream.range(1, 10);
		long val = numStream.sum();
		System.out.println("Sum :"+ val);
		
		int[] numbers = {1,5,3,6,2};
		System.out.println("---------------Stream File--------------");
		Path filepath = Paths.get("C:\\Dev\\test.txt");
		Stream<String> lines = Files.lines(filepath);
		lines.forEach(display);
		
		System.out.println("--------------Stream Iterate------");
		Consumer<Integer> numValue = (n) -> System.out.println(n);
		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
		streamIterated.forEach(numValue);
		
		System.out.println("------------Radom number-----------");
		Random random = new Random();
		DoubleStream doubleStream = random.doubles(3);
		
		//Map<String,Integer> empTable = listEmp.stream().collect(Collectors.toMap(Employee::name,Employee::id,(o1,o2) -> o1, LinkedHashMap::new ));
		
		System.out.println("-----Example 1: Group the stream by Key--------");
		Map<String, List<Employee>> groupByName = listEmp.stream().collect(Collectors.groupingBy(Employee::getName));
		System.out.println("Group by Name :" + groupByName);

		System.out.println("------------------Example2: Group the stream by key and value---------------");
		Map<String, Long> countByName = listEmp.stream()
				.collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));
		System.out.println("Count by Name :" + countByName);
		
		
		System.out.println("-----------------Sort the Map by key in alphabetical order and print it:-p:----------------");
		Map<String, Integer> sortByKeyOrder = listEmp.stream()
		        .collect(Collectors.toMap(Employee::getName, Employee::getId, (o1,o2) -> o2))
		        .entrySet()
		        .stream()
		        .sorted(Map.Entry.comparingByKey())
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1,o2) -> o1, LinkedHashMap::new));
		
		System.out.println(sortByKeyOrder);

		System.out.println("-----------------Methods to consolidate lists :----------------");
		//Convert Array object to List of Integer using IntStream class.
		
		List<Integer> method1 = IntStream.of(numbers).boxed().collect(Collectors.toList());
		Stream<List<Integer>> method2 = Stream.of(method1, method1);
		List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(2,3,4,5), Arrays.asList(3,6,5,3));
		
		
		System.out.println("-----------------Consolidate :----------------");
		List<Integer> consolidate = method2.flatMap(e -> e.stream()).collect(Collectors.toList());
		System.out.println("Consolidated List :"+ consolidate);
		List<Integer> method3 = Arrays.asList(1,2,3,5,6);
		
		
		System.out.println("-----------------Sort the Map by key in reverse alphabetical order and collect to LinkedHashMap:----------------");
		Map<String, Integer> sortByKeyReverse = listEmp.stream()
		        .collect(Collectors.toMap(Employee::getName, Employee::getId, (o1,o2) -> o1))
		        .entrySet()
		        .stream()
		        .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1,o2) -> o1, LinkedHashMap::new));
		
		System.out.println(sortByKeyReverse);
		
		
		
		System.out.println("-----------------Char count details with Case Sensitive :----------------");
		String s ="MAgeshkumar";
		Map<String, Long> map = Arrays.stream(s.split(""))
                //.map(String::toLowerCase)
                .collect(Collectors
                .groupingBy(str -> str, 
                  LinkedHashMap::new, Collectors.counting()));
		System.out.println("Word Count :"+ map);
		
		
		System.out.println("-----------------Char count details :----------------");
		String sen = "My name is mageshkumarm.mca";

		Map<String, Long> result = Arrays.stream(sen.split("")).map(String::toLowerCase)
				.collect(Collectors.groupingBy(str -> str, LinkedHashMap::new, Collectors.counting()));
		System.out.println("Output :" + result);

		System.out.println("--------------Word counts------------------");
		String ss = "Welcome to Mphasis to Mphasis";
		Map<String, Long> findWordOccurences = Arrays.stream(ss.split("\s"))
				.collect(Collectors.groupingBy(str -> str, LinkedHashMap::new, Collectors.counting()));
		System.out.println("Words :" + findWordOccurences);

		System.out.println("--------------Covert to Map object------------------");
		Map<String, Integer> ou = listEmp.stream().collect(Collectors.toMap(Employee::getName, Employee::getId));
		System.out.println("Output :" + ou);

		System.out.println("--------------Covert to Map object Grouping------------------");
		Map<String, Long> groupingGroupBy = listEmp.stream()
				.collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));
		System.out.println("Output :" + groupingGroupBy);
		
		System.out.println("--------------CompletableFuture------------------");
		CompletableFuture future1 =  CompletableFuture.supplyAsync(()-> "Execute salary model");
		
		//CompletableFuture future2 = future1.thenAccept( s -> System.out.println("Output :"+ s));
		//future2.get();
		
		//--Continue
		//https://codingnconcepts.com/java/streams-with-map-java-8/#:~:text=Example%203%3A%20ConcurrentHashMap%2C%20LinkedHashMap%2C,return%20ConcurrentHashMap%2C%20LinkedHashMap%20or%20TreeMap. 
		
	}
	

}
