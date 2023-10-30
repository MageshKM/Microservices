package com.java.lambda;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<EmployeeComparator> {
	
	int id;
	String name;
	public EmployeeComparator(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public EmployeeComparator() {
		// TODO Auto-generated constructor stub
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
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compare(EmployeeComparator o1, EmployeeComparator o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
	
	

}
