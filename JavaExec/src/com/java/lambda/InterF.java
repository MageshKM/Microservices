package com.java.lambda;

interface T
{
	public void test();
	//public void test1(int i);
}
public class InterF {
	public static void main(String args[])
	{
		T t = () -> { System.out.println("Test");};
		t.test();
	}

}
