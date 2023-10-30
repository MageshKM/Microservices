package com.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class SortingStreamExample {

	public static void main(String args[]) {

		System.out.println("**************************** Natural Order ******************");
		Stream<Integer> numStream = Stream.of(1, 3, 5, 4, 2);

		numStream.sorted(Comparator.naturalOrder()).forEach(System.out::println);

		System.out.println("**************************** Reverse Order ******************");
		Stream<Integer> numStream1 = Stream.of(1, 3, 5, 4, 2);

		numStream1.sorted(Comparator.reverseOrder()).forEach(System.out::println);

		System.out.println("**************************** Employee Details Order ******************");

		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("Magesh", 36, 45600));
		empList.add(new Employee("Rajesh", 36, 45600));
		empList.add(new Employee("Suresh", 37, 47600));
		empList.add(new Employee("Mani", 40, 49600));
		Consumer<Employee> consumer = (e) -> System.out
				.println(e.getEmployeeName() + "|" + e.getAge() + "|" + e.getSalary());
		while (true) {
			empList.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).forEach(System.out::println);
		}
	}

}
