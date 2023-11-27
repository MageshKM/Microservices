package com.java8.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.java.practisesession.EmployeeObject;

public class SerializeAndDeSerialze {

	public static void main(String[] args) {
		
		EmployeeObject john = new EmployeeObject(111, "john", 32, "Female", "HR", 2011, 25000.0);

	        try {

	            FileOutputStream fileOut = new FileOutputStream("c://workspace//person.ser");

	            ObjectOutputStream out = new ObjectOutputStream(fileOut);

	            out.writeObject(john);

	            out.close();

	            fileOut.close();

	            System.out.println("Serialized data is saved in person.ser");

	        } catch (IOException i) {

	            i.printStackTrace();

	        }
	        

		john = null;

		try {

			FileInputStream fileIn = new FileInputStream("c://workspace//person.ser");

			ObjectInputStream in = new ObjectInputStream(fileIn);

			john = (EmployeeObject) in.readObject();

			in.close();

			fileIn.close();

		} catch (IOException i) {

			i.printStackTrace();

			return;

		} catch (ClassNotFoundException c) {

			System.out.println("Person class not found");

			c.printStackTrace();

			return;

		}

		System.out.println("Deserialized Person...");

		System.out.println(john);

	}

}
