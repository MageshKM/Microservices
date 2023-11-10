package com.java.practisesession;

public class RecursiveExample2 {
	public static void main(String args[]) {
		
		int result = calc(10);
		System.out.println("Result:"+result);
	}

	private static int calc(int i) {
		if (i > 0) {
			return i + calc(i-1);
		} else {
			return 0;
		}
	}
}
