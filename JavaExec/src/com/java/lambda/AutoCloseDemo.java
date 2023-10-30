package com.java.lambda;

class TestDB implements AutoCloseable {

	TestDB() {
		System.out.println("Object Created");
	}

	@Override
	public void close() throws Exception {
		System.out.print("Disconnected");
	}

}

public class AutoCloseDemo {
	public static void main(String args[]) throws Exception {
		try (TestDB ob = new TestDB()) {

		}
	}
}
