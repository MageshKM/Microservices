package com.java.lambda;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class ConcurrentHashMapExample extends Thread {
	ConcurrentHashMap<Integer, String> ch = new ConcurrentHashMap<Integer, String>();

	public void run() {

		IntStream genList = IntStream.range(0, 10000);

		IntConsumer print = (i)->  System.out.println("Thread Name : ["+Thread.currentThread().getName()+"]"+ i);
		genList.forEach(print);
	}

	public static void main(String args[])
	{
		ExecutorService executor = Executors.newFixedThreadPool(2);
		ConcurrentHashMapExample t1 = new ConcurrentHashMapExample();
		ConcurrentHashMapExample t2 = new ConcurrentHashMapExample();
		ConcurrentHashMapExample t3 = new ConcurrentHashMapExample();
		ConcurrentHashMapExample t4 = new ConcurrentHashMapExample();
		
		executor.execute(t1);
		executor.execute(t2);
		executor.execute(t3);
		executor.execute(t4);
		
	}

}
