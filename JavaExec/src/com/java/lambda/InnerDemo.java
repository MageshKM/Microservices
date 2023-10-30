package com.java.lambda;


class OuterClass{
	void show() {
		System.out.println("Outer class method");
	}
	class InnerClass{
		void show() {
			System.out.println("Inner Class method");
		}
	}
}
public class InnerDemo {
	public static void main(String a[])
	{
		OuterClass.InnerClass outerInner = new OuterClass().new InnerClass();
		outerInner.show();
	}

}
