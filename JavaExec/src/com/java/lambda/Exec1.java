package com.java.lambda;

public class Exec1 {
	interface Maths {
		public static final String comp ="Compiler";
		int add(int i);
		default void setTimeOut()
		{
			System.out.println("Print out..!");
		}
		public String toString();
	}

	public static void main(String args[]) {
		Maths a = (int i) -> i * 2;
		Exec1 e = new Exec1();
		a.setTimeOut();
		e.addition(a);

	}

	public void addition(Maths m) {
		System.out.println("Calc :" + m.add(8));
	}

}
