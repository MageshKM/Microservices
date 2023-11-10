package com.java.practisesession;

@FunctionalInterface
interface A{
	
	public void test();
	
}
interface B extends A{
	public void test1();
	
}
public class FunctionalInterfaceExample {
	
	public static void main (String args[])
	{
		A b = () -> System.out.println("test method called..!");
		b.test();
	}

}
