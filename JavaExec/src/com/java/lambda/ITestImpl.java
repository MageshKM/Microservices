package com.java.lambda;

public class ITestImpl implements ITest{

	public static void main(String args[]) {
		ITest it = new ITestImpl();
		//it.test2();
		System.out.println("Ouptut :"+it.test1());
	}
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}
	
	static void test2() {
		System.out.println("Sub Class Static method..");
	}
	public String test1() {
		return "Test1";
	}

}
