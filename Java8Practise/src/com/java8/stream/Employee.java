package com.java8.stream;

public class Employee {
	String employeeName;
	int age;
	double salary;
	
	public Employee(String employeeName, int age, double salary) {
		super();
		this.employeeName = employeeName;
		this.age = age;
		this.salary = salary;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
		return "Employee [employeeName=" + employeeName + ", age=" + age + ", salary=" + salary + "]";
	}
	
	

}
