package com.java8.concurrent;

import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class MyRunnable implements Callable {

	@Override
	public Object call() throws Exception {
		TimeUnit.MILLISECONDS.sleep(5000);
		return "Callable data :" + Instant.now();
	}

}

public class FutureTest {
	public static void main(String args[]) {
		ExecutorService executor = Executors.newSingleThreadExecutor();

		Future<String> result = executor.submit(new MyRunnable());
		Future<String> result1 = executor.submit(new MyRunnable());
		Future<String> result2 = executor.submit(new MyRunnable());
		Future<String> result3 = executor.submit(new MyRunnable());
		Future<String> result4 = executor.submit(new MyRunnable());

		while (true) {
			if (result.isDone() && result1.isDone() && result2.isDone() && result3.isDone() && result4.isDone()) {
				System.out.println("Execution Completed Thread :" + Thread.currentThread().getName());
				break;
			}

			if (result.isDone()) {
				System.out.println("Result one is completed...!!" + Thread.currentThread().getName());
			}

			if (result1.isDone()) {
				System.out.println("Result1 one is completed...!!" + Thread.currentThread().getName());
			}

			if (result2.isDone()) {
				System.out.println("Result2 one is completed...!!" + Thread.currentThread().getName());
			}
			if (result3.isDone()) {
				System.out.println("Result3 one is completed...!!" + Thread.currentThread().getName());
			}
			if (result4.isDone()) {
				System.out.println("Result4 one is completed...!!" + Thread.currentThread().getName());
			}
		}
		executor.shutdown();
		
		CompletableFuture<Void> run = CompletableFuture.runAsync(()-> System.out.println("hello"));
	}

}
