package com.java8.demo;

import java.util.Comparator;

public class SortByName implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		double age1 = o1.getSalary();
		double age2 = o2.getSalary();

		if (age1 == age2)
			return 0;
		else if (age1 > age2)
			return 1;
		else
			return -1;

	}

}
