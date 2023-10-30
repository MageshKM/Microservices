package com.java.lambda;

public class ExceptionWorking {

	public static void main(String[] args) throws ExceptionCheckDemo {
		test();
		test1();
	}

	private static void test() throws ExceptionCheckDemo {
		throw new ExceptionCheckDemo("Testing error");
	}

	private static void test1() {
		throw new ExceptionRuntimeDemo("Error Msg", new Throwable());
	}

}
