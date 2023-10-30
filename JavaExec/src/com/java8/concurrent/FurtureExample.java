package com.java8.concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FurtureExample {
	
	public static void main(String args[]) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		Future<Integer> future = service.submit(new NewTask());
		
		Integer output;
		try {
			output = future.get();
			System.out.println("Output :"+output);
		} catch (InterruptedException|ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}

class NewTask implements Callable<Integer>
{

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return new Random().nextInt();
	}
	
}