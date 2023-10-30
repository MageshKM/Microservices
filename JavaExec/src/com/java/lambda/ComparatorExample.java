package com.java.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComparatorExample {
	public static void main(String args[]) {

		Employee[] empList = new Employee[5];

		empList[0] = new Employee(1, "Magesh", 50000, "Developer");
		empList[1] = new Employee(2, "Amit", 50000, "Developer");
		empList[2] = new Employee(3, "Banu", 50000, "Developer");
		empList[3] = new Employee(4, "John", 50000, "Developer");
		empList[4] = new Employee(5, "Zam", 50000, "Developer");

		Arrays.sort(empList, Employee.nameSort);

		System.out.println(Arrays.toString(empList));

		List<Employee> listEmp = new ArrayList<Employee>();

		listEmp.add(new Employee(1, "Magesh", 50000, "Developer"));
		listEmp.add(new Employee(2, "Amit", 50000, "QA"));
		listEmp.add(new Employee(3, "Banu", 50000, "TESTING"));
		listEmp.add(new Employee(4, "John", 63000, "Developer"));
		listEmp.add(new Employee(5, "Zam", 50000, "Developer"));

		Predicate<Employee> criteria = (e) -> (e.getSalary() <= 50000 && e.getDesg().equals("Developer"));
		Consumer<Employee> display = (emp) -> System.out
				.println(emp.getId() + "|" + emp.getName() + "|" + emp.getDesg());
		listEmp.stream().filter(criteria).map((e) -> {
			e.setSalary(e.getSalary() + 1000);
			return e;
		}).forEach(display);

	}
}
