package com.java8.demo;

public interface Interface1   {
	default void run() {
		System.out.println("Interface1 Run method");
	} 
	
	static void print() {
		System.out.println("Print Static method");
	}
	
}
