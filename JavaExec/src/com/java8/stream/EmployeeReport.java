package com.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeReport {
	public static void main(String args[])
	{
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("Magesh",36,45600));
		empList.add(new Employee("Rajesh",36,45600));
		empList.add(new Employee("Suresh",37,47600));
		empList.add(new Employee("Mani",40,49600));
		
		
		Predicate<Employee> condForAge = (e) -> e.getAge() > 36;
		Predicate<Employee> condForSal = (e) -> e.getSalary() > 45600;
		Predicate<Employee> condForName = (e) -> e.getEmployeeName().startsWith("M");
		
		Consumer<Employee> consumer = (e) -> System.out.println(e.getEmployeeName()+"|"+e.getAge()+"|"+e.getSalary());
		empList.stream().filter(condForAge.and(condForSal).and(condForName)).sorted().collect(Collectors.toList()).forEach(consumer);
		
	}

}
