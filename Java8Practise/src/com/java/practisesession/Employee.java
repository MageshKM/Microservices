package com.java.practisesession;

import java.util.Comparator;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
	
	int id; 
	String name;
	int salary;
	String desg;
	public Employee(int id, String name, int salary, String desg) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.desg = desg;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.id - o.getId();
	}
	
	public static Comparator<Employee> nameSort = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return o1.getName().compareTo(o2.getName());
		}

	};

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public static Comparator<Employee> getNameSort() {
		return nameSort;
	}

	public static void setNameSort(Comparator<Employee> nameSort) {
		Employee.nameSort = nameSort;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public String getDesg() {
		return desg;
	}
	
	

}
