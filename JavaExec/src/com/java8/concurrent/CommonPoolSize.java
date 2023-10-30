package com.java8.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class CommonPoolSize {
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		long total = LongStream.rangeClosed(1, 3_000_000).parallel().sum();
		System.out.println("Total :"+total);
		
		int poolsize = ForkJoinPool.commonPool().getPoolSize();
		System.out.println("pool size:"+poolsize);
		System.out.println("Process "+Runtime.getRuntime().availableProcessors());
		
		ForkJoinPool pool = new ForkJoinPool(15);
		ForkJoinTask<Long> task = pool.submit(() -> LongStream.range(0, 3_000_000).parallel().sum());
		
		System.out.println(task.get());
	}

}
