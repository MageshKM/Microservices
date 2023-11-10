package com.eureka.demo.service;

import org.springframework.stereotype.Component;

import com.eureka.demo.model.Employee;
@Component
public class EmployeeService {
	
	public void setData(Employee emp) {
		emp.setSalary(152000);
		emp.setEmpName("Magesh");
		emp.setAge(36);
		emp.setRollNumber(1245786);
		
	}

}
