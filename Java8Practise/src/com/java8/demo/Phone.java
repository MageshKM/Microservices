package com.java8.demo;

public interface Phone {

	String getPhoneMode();
	
	default void getlogges() {
		System.out.println("Executed");
	}
	
	static double getPrice()
	{
		return 125000;
	}
}
