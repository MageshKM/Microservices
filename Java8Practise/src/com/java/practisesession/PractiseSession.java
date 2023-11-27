package com.java.practisesession;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PractiseSession {
	public static void main(String args[]) {

		Stream.iterate(1, n -> n < 20, n -> n * 2).forEach(x -> System.out.println(x));

		List<Employee2> emplist = IntStream.range(1, 10).mapToObj(i -> new Employee2("User" + i, (10 + i), 10000 + i))
				.collect(Collectors.toList());

		Map<String, Long> output = emplist.stream().sorted(Comparator.comparing(Employee2::getName))
				.collect(Collectors.groupingBy(Employee2::getName, LinkedHashMap::new, Collectors.counting()));
		System.out.println("Result :" + output);

		System.out.println("Below Person got max Salary:");

		Optional<Employee2> avg = emplist.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee2::getSalary)));

		System.out.println("Name :" + avg.get().getName());
		System.out.println("Age :" + avg.get().getAge());
		System.out.println("Salary :" + avg.get().getSalary());
		System.out.println("Below Person is the Avg Salary:");
		double avgSalary = emplist.stream().collect(Collectors.averagingDouble(Employee2::getSalary));
		System.out.println("Avg Salary :" + avgSalary);

	}

}

class Employee2 {
	String name;
	int age;
	double salary;

	public Employee2(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
