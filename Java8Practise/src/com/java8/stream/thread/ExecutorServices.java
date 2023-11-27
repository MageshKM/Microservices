package com.java8.stream.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

public class ExecutorServices {
	public static void main(String args[]) throws InterruptedException, ExecutionException {

		ExecutorService services = Executors.newFixedThreadPool(10);

		Future<List<EmployeeObject>> result = services.submit(() -> {
			Thread.sleep(5000);
			return getList().stream().filter(e -> e.getAge() > 30).collect(Collectors.toList());
		});

		System.out.println("Result :" + result.get().size() + ", Status :" + result.isDone());
	}

	private static List<EmployeeObject> getList() {
		List<EmployeeObject> employeeList = new ArrayList<EmployeeObject>();

		employeeList.add(new EmployeeObject(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new EmployeeObject(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new EmployeeObject(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new EmployeeObject(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
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

		return employeeList;
	}
}
