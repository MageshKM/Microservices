package com.java8.demo;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;

public class ParallelDemo {
public static int doubleIt(int n) {
	try {
		Thread.sleep(100);
		System.out.println("Thread Name :"+Thread.currentThread().getName()+" With n = "+ n);
	}
	catch(InterruptedException e) {
		
	}
	return n*2;
}

public static void main(String args[])
{
	Instant before = Instant.now();
	
	int total = IntStream.of(1,4,5,6,8).parallel().map(ParallelDemo::doubleIt).sum();
	
	Instant after = Instant.now();
	
	Duration duration = Duration.between(before, after);
	System.out.println("Total of doubles ="+total);
	System.out.println("Time = "+duration.toMillis()+" ms");
}
}
