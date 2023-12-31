package com.java.practisesession;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindEmployeeObjects {
	public static void main(String args[]) {
		List<EmployeeObject> employeeList = new ArrayList<EmployeeObject>();

		employeeList.add(new EmployeeObject(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new EmployeeObject(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new EmployeeObject(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new EmployeeObject(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(
				new EmployeeObject(144, "Magesh Kumar Muniyappa", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new EmployeeObject(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new EmployeeObject(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new EmployeeObject(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new EmployeeObject(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new EmployeeObject(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new EmployeeObject(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new EmployeeObject(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new EmployeeObject(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new EmployeeObject(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new EmployeeObject(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new EmployeeObject(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new EmployeeObject(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new EmployeeObject(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		double avgSal = employeeList.stream().collect(Collectors.averagingDouble(EmployeeObject::getSalary));

		System.out.println("Print two Decimal point -> Avg Salary : " + String.format("%.2f", avgSal));

		System.out.println("----------------------------Third Highest Salary-----------------------");
		Optional<EmployeeObject> employeedata = employeeList.stream()
				.sorted(Comparator.comparingDouble(EmployeeObject::getSalary)).limit(3)
				.max(Comparator.comparingDouble(EmployeeObject::getSalary));

		System.out.println("Name :" + employeedata.get().getName());
		System.out.println("Age :" + employeedata.get().getAge());
		System.out.println("Department :" + employeedata.get().getDepartment());
		System.out.println("Salary :" + employeedata.get().getSalary());

		System.out.println("-----------------------------Group By Age-----------------------");
		Map<Integer, Long> groupbyAge = employeeList.stream()
				.collect(Collectors.groupingBy(EmployeeObject::getAge, LinkedHashMap::new, Collectors.counting()));

		System.out.println("Group By Age :" + groupbyAge);

		System.out.println("-----------------------------Display Departments-----------------------");

		employeeList.stream().map(EmployeeObject::getDepartment).distinct().forEach(System.out::println);

		System.out.println("-----------------------------Group by Gender & find avg age-----------------------");
		Map<String, Double> groupByGenderAndAge = employeeList.stream().collect(Collectors.groupingBy(
				EmployeeObject::getGender, LinkedHashMap::new, Collectors.averagingDouble(EmployeeObject::getAge)));

		System.out.println(groupByGenderAndAge);

		System.out.println("---------- Get the details of highest paid employee in the organization?----------------");
		Optional<EmployeeObject> highestPaidEmployeeWrapper = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(EmployeeObject::getSalary)));

		EmployeeObject highestPaidEmployee = highestPaidEmployeeWrapper.get();

		System.out.println("Details Of Highest Paid Employee : ");

		System.out.println("==================================");

		System.out.println("ID : " + highestPaidEmployee.getId());

		System.out.println("Name : " + highestPaidEmployee.getName());

		System.out.println("Age : " + highestPaidEmployee.getAge());

		System.out.println("Gender : " + highestPaidEmployee.getGender());

		System.out.println("Department : " + highestPaidEmployee.getDepartment());

		System.out.println("Year Of Joining : " + highestPaidEmployee.getYearOfJoining());

		System.out.println("Salary : " + highestPaidEmployee.getSalary());

		System.out.println("------- Get the names of all employees who have joined after 2015?--------------");

		employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(EmployeeObject::getName)
				.forEach(System.out::println);

		System.out.println("------- Count the number of employees in each department?--------------");

		Map<String, Long> employeeCountByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(EmployeeObject::getDepartment, Collectors.counting()));

		Set<Entry<String, Long>> entrySet = employeeCountByDepartment.entrySet();

		for (Entry<String, Long> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());

		}

		System.out.println("-------What is the average salary of each department? -------");
		Map<String, Double> avgSalaryOfDepartments = employeeList.stream().collect(Collectors
				.groupingBy(EmployeeObject::getDepartment, Collectors.averagingDouble(EmployeeObject::getSalary)));

		Set<Entry<String, Double>> entrySetDouble = avgSalaryOfDepartments.entrySet();

		for (Entry<String, Double> entry : entrySetDouble) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		System.out.println("-------Who has the most working experience in the organization?--------------");

		Optional<EmployeeObject> seniorMostEmployeeWrapper = employeeList.stream()
				.sorted(Comparator.comparingInt(EmployeeObject::getYearOfJoining)).findFirst();

		EmployeeObject seniorMostEmployee = seniorMostEmployeeWrapper.get();

		System.out.println("Senior Most Employee Details :");

		System.out.println("----------------------------");

		System.out.println("ID : " + seniorMostEmployee.getId());

		System.out.println("Name : " + seniorMostEmployee.getName());

		System.out.println("Age : " + seniorMostEmployee.getAge());

		System.out.println("Gender : " + seniorMostEmployee.getGender());

		System.out.println("Age : " + seniorMostEmployee.getDepartment());

		System.out.println("Year Of Joinging : " + seniorMostEmployee.getYearOfJoining());

		System.out.println("Salary : " + seniorMostEmployee.getSalary());

		System.out.println(
				"-------How many male and female employees are there in the sales and marketing team?--------");

		Map<String, Long> countMaleFemaleEmployeesInSalesMarketing = employeeList.stream()
				.filter(e -> e.getDepartment() == "Sales And Marketing")
				.collect(Collectors.groupingBy(EmployeeObject::getGender, Collectors.counting()));

		System.out.println(countMaleFemaleEmployeesInSalesMarketing);

		System.out.println("-------What is the average salary of male and female employees?--------");
		Map<String, Double> avgSalaryOfMaleAndFemaleEmployees = employeeList.stream().collect(Collectors
				.groupingBy(EmployeeObject::getGender, Collectors.averagingDouble(EmployeeObject::getSalary)));

		System.out.println(avgSalaryOfMaleAndFemaleEmployees);

		System.out.println("-------List down the names of all employees in each department?--------");
		Map<String, List<EmployeeObject>> employeeListByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(EmployeeObject::getDepartment));

		Set<Entry<String, List<EmployeeObject>>> entrySetDepart = employeeListByDepartment.entrySet();

		for (Entry<String, List<EmployeeObject>> entry : entrySetDepart) {
			System.out.println("--------------------------------------");

			System.out.println("Employees In " + entry.getKey() + " : ");

			System.out.println("--------------------------------------");

			List<EmployeeObject> list = entry.getValue();

			for (EmployeeObject e : list) {
				System.out.println(e.getName());
			}
		}

		System.out.println("-------What is the average salary and total salary of the whole organization?--------");
		DoubleSummaryStatistics employeeSalaryStatistics = employeeList.stream()
				.collect(Collectors.summarizingDouble(EmployeeObject::getSalary));

		System.out.println("Average Salary = " + employeeSalaryStatistics.getAverage());

		System.out.println("Total Salary = " + employeeSalaryStatistics.getSum());

		System.out.println(
				"------ Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.--------");
		Map<Boolean, List<EmployeeObject>> partitionEmployeesByAge = employeeList.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() > 25));

		Set<Entry<Boolean, List<EmployeeObject>>> entrySetYear = partitionEmployeesByAge.entrySet();

		for (Entry<Boolean, List<EmployeeObject>> entry : entrySetYear) {
			System.out.println("----------------------------");

			if (entry.getKey()) {
				System.out.println("Employees older than 25 years :");
			} else {
				System.out.println("Employees younger than or equal to 25 years :");
			}

			System.out.println("----------------------------");

			List<EmployeeObject> list = entry.getValue();

			for (EmployeeObject e : list) {
				System.out.println(e.getName());
			}
		}

		System.out.println(
				"------ Who is the oldest employee in the organization? What is his age and which department he belongs to?--------");

		Optional<EmployeeObject> oldestEmployeeWrapper = employeeList.stream()
				.max(Comparator.comparingInt(EmployeeObject::getAge));

		EmployeeObject oldestEmployee = oldestEmployeeWrapper.get();

		System.out.println("Name : " + oldestEmployee.getName());

		System.out.println("Age : " + oldestEmployee.getAge());

		System.out.println("Department : " + oldestEmployee.getDepartment());

		System.out.println("------ Display Third Highest Salaried Employee Data?--------");
		List<EmployeeObject> highestSalaryList = employeeList.stream()
				.sorted(Comparator.comparingDouble(EmployeeObject::getSalary).reversed()).collect(Collectors.toList());

		EmployeeObject empObj = highestSalaryList.get(2);

		System.out.println("Name :" + empObj.getName());
		System.out.println("Salary :" + empObj.getSalary());
		System.out.println("------ GroupBy Third Highest Salaried Employee Data?--------");

		Map<Double, List<EmployeeObject>> map = employeeList.stream()
				.sorted(Comparator.comparingDouble(EmployeeObject::getSalary).reversed())
				.collect(Collectors.groupingBy(EmployeeObject::getSalary, LinkedHashMap::new, Collectors.toList()));

		Optional<Entry<Double, List<EmployeeObject>>> findMaxSalary = employeeList.stream()
				.sorted(Comparator.comparingDouble(EmployeeObject::getSalary).reversed())
				.collect(Collectors.groupingBy(EmployeeObject::getSalary, LinkedHashMap::new, Collectors.toList()))
				.entrySet().stream().limit(3).collect(Collectors.minBy(Map.Entry.comparingByKey()));

		findMaxSalary.get().getValue().stream().forEach(e -> {
			System.out.println(e);
		});
		
		List<EmployeeObject> list = employeeList.stream().map(e -> { e.setSalary(e.getSalary() * 20); return e;}).collect(Collectors.toList());
		
		list.stream().forEach(e -> {System.out.println("Name :"+ e.getName() +", Salary :"+ e.getSalary());});

	}
}
