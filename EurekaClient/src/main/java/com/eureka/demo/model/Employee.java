package com.eureka.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	int rollNumber;
	String empName;
	int age;
	double salary;
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
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
	@Override
	public String toString() {
		return "Employee [rollNumber=" + rollNumber + ", empName=" + empName + ", age=" + age + ", salary=" + salary
				+ "]";
	}

}
