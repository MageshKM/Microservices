package com.java8.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunAsyncExample {

	public static void main(String args[]) throws InterruptedException, ExecutionException {
		System.out.println("Main Thread:" + Thread.currentThread().getName());

		ExecutorService executor = Executors.newFixedThreadPool(10);
 
		CompletableFuture<Void> completedFuture = CompletableFuture.runAsync(() -> {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Future Thread Name :" + Thread.currentThread().getName());
		}, executor);

		completedFuture.get();
	}

}
