package com.java.practisesession;

public interface ITest {
public void test();
 default String test1() {
	return "Test";
}
private static void test2() {
	System.out.println("Super Class Static method..");
}
}
