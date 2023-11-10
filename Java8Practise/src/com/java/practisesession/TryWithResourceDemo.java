package com.java.practisesession;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.File;
import java.util.Scanner;

public class TryWithResourceDemo {
	public static void main(String args[]) throws FileNotFoundException, IOException {
		//System.out.println(getValue());
		
		
		final Scanner scanner = new Scanner(new File("C://Dev//test.txt"));
		PrintWriter writer = new PrintWriter(new File("C://Dev//test1.txt"));
		try (scanner;writer) { 
		    // omitted
		}
		
		
		StringWriter sw = new StringWriter() {
	        @Override
	        public void close() throws IOException {
	            super.close();
	            System.out.println("closed");
	        }
	};
	try (PrintWriter pw = new PrintWriter(sw)) {};
	}
	
	private static String getValue() throws FileNotFoundException, IOException {
		String path = "c://Dev//test.txt";
		 try (FileReader fr = new FileReader(path);
		         BufferedReader br = new BufferedReader(fr)) {
		        return br.readLine();
		    }
	}

}
