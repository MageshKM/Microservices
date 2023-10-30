package com.java.lambda;

@FunctionalInterface
interface Calcu
{
	int m1(int i, int j);
	
}
public class LambdaExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calcu c = (i, j)-> i+j;
		int output = c.m1(2, 4);
		System.out.println("Output:"+output);

	}

}
