package com.java.lambda;

import java.util.Optional;

public class OptionalExample {
	public static void main(String args[])
	{
		String[] names = new String[5];
		Optional<String> option = Optional.ofNullable(names[4]);
		if(option.isPresent())
			System.out.println("Value is present");
		else
			System.out.println("Value null");
	}

}
