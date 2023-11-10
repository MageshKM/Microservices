package com.java.practisesession;

/**
 * Example for Integer Autobox and unboxing..
 * 
 * @author mages
 *
 */

@FunctionalInterface
interface TestView {
	int test();
	default void power()
	{
		System.out.println("Static Callled");
	}
}

public class IntWrapper {

	public static void main(String[] args) {

		Integer i = 2000;
		Integer ii = 2000;

		if (i == ii)
			System.out.println("Equal value");
		else
			System.out.println("Not Equal value");

		TestView t = () -> {
			int m = 6;
			int k = 6;
			
			return (m * k);
		};
		int output = t.test();
		System.out.println("Output :"+ output);
		t.power();
	}

}
