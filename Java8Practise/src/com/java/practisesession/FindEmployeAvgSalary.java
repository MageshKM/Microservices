package com.java.practisesession;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FindEmployeAvgSalary {
	public static void main(String[] args) {// w w w . j a v a 2 s . co m
		EmployeeNew[] employees = { new EmployeeNew("J", "Red", 51000, "IT"),
				new EmployeeNew("A", "Green", 71600, "IT"), new EmployeeNew("M", "Black", 35187.5, "Sales"),
				new EmployeeNew("K", "Yellow", 47100.77, "Marketing"), new EmployeeNew("L", "Pink", 62001, "IT"),
				new EmployeeNew("D", "Blue", 32001, "Sales"), new EmployeeNew("W", "Brown", 42361.4, "Marketing") };

		// get List view of the Employees
		List<EmployeeNew> list = Arrays.asList(employees);

		// display all Employees
		System.out.println("Complete Employee list:");
		list.stream().forEach(System.out::println);

		// average of Employee salaries with DoubleStream average method
		System.out.printf("Average of Employees' salaries: %.2f%n",
				list.stream().mapToDouble(EmployeeNew::getSalary).average().getAsDouble());

		double avgSalary = list.stream().mapToDouble(EmployeeNew::getSalary).average().getAsDouble();
		
		Consumer<EmployeeNew> display = (e) -> { System.out.println("First Name:"+ e.getFirstName()+"| Name: "+ e.getName()+"| Salary :"+e.getSalary());};
		list.stream().filter(emp -> (emp.getSalary() < avgSalary)).forEach(display);

	}
}

class EmployeeNew {
	private String firstName;
	private String lastName;
	private double salary;
	private String department;

	// constructor
	public EmployeeNew(String firstName, String lastName, double salary, String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.department = department;
	}

	// set firstName
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// get firstName
	public String getFirstName() {
		return firstName;
	}

	// set lastName
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// get lastName
	public String getLastName() {
		return lastName;
	}

	// set salary
	public void setSalary(double salary) {
		this.salary = salary;
	}

	// get salary
	public double getSalary() {
		return salary;
	}

	// set department
	public void setDepartment(String department) {
		this.department = department;
	}

	// get department
	public String getDepartment() {
		return department;
	}

	// return Employee's first and last name combined
	public String getName() {
		return String.format("%s %s", getFirstName(), getLastName());
	}

	// return a String containing the Employee's information
	@Override
	public String toString() {
		return String.format("%-8s %-8s %8.2f   %s", getFirstName(), getLastName(), getSalary(), getDepartment());
	}
}
