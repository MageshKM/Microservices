package com.java.practisesession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

public class ExecutorServiceDemo {
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(6);
		Callable<String> callableTask = () -> {
			System.out.println("Call method called.");
			Thread.sleep(2000);
			return "Task execution in call method" + new Date();
		};

//submit single callable task to executorService, that is returning a Future
		Future<String> future = executorService.submit(callableTask);
		System.out.println(future.get());

//Create list of callable tasks
		List<Callable<String>> callableTasks = new ArrayList<>();
		callableTasks.add(callableTask);
		callableTasks.add(callableTask);
		callableTasks.add(callableTask);

//submit the list of callable tasks to invokeAny method that returns a result.
		String result = executorService.invokeAny(callableTasks);
		System.out.println(result);

//submit the list of callable tasks to invokeAll method that returns a list
//of futures representing results of asynchronous tasks.
		List<Future<String>> futures = executorService.invokeAll(callableTasks);
		Consumer<Future> display = (f) -> {
			try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		futures.stream().forEach(display);
//shutdown the executorService after completing all tasks to reclaim memory.
		executorService.shutdown();

	}

}
