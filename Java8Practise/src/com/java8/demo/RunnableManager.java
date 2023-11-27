package com.java8.demo;

public class RunnableManager extends Runnable3 implements Runnable  {
	public void  run() {
		System.out.println("Static block code...");
	}
	public static void main(String args[]) {
		Runnable3 runObj = new Runnable3();
		Thread t1 = new Thread(runObj);
		t1.start();
	}
}
