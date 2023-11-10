package com.java.practisesession;

import java.util.function.Predicate;

public class PredicateExample {
	public static void main(String args[])
	{
		Predicate<Integer> check = i -> (i > 2);
		
		System.out.print(check.test(1));
	}

}
