package com.eureka.demo.config;

import java.util.concurrent.Callable;

public class EmployeeCallable implements Callable<Employee>{

	@Override
	public Employee call() throws Exception {
		Employee emp = new Employee();
		emp.setAge(13);
		emp.setName("Magesh");
		emp.setSalary(2500); 
		
		return emp;
	}

}
