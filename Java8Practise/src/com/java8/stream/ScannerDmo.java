package com.java8.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerDmo {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(new File("C:\\workspace\\test.txt"))) {
		    while (scanner.hasNext()) {
		        System.out.println(scanner.nextLine());
		    }
		} catch (FileNotFoundException fnfe) {
		    fnfe.printStackTrace();
		}

	}

}
