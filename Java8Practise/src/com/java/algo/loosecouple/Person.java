package com.java.algo.loosecouple;

public class Person {
public static void main(String args[]) {
	Vehicel car = new Car();
	Vehicel bus = new Bus();
	
	TravelMode tm = new TravelMode(bus);
	tm.check();
}
}
