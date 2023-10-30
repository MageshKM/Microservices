package com.java.lambda;

interface Communication{
	public static void message() {
		System.out.println("I'm static method...");
	}
	public default void receiver() {
		System.out.println("I'm default method..");
		
	}
	private static void message(String str) {
		System.out.println("Overload method"+str);
	}
}

interface AirtelCommunication extends Communication {
	public static void message() {
		System.out.println("I'm AirtelCommunication static method...");
	}
	public default void receiver() {
		System.out.println("I'm AirtelCommunication default method..");
		
	}
}
public class DefaultStaticInterface implements Communication, AirtelCommunication {
	public static void main (String args[]) {
		Communication com = new DefaultStaticInterface();
		com.receiver();
		Communication.message();
		DefaultStaticInterface.message();
		
	}
	public static void message() {
		System.out.println("I'm from Main Class");
	}/*
		 * public void receiver() { System.out.println("I'm main default method."); }
		 * 
		 */
	@Override
	public void receiver() {
		// TODO Auto-generated method stub
		AirtelCommunication.super.receiver();
	}
}
