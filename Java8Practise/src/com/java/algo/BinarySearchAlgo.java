package com.java.algo;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchAlgo {

	public static void main(String[] args) {
		
		ArrayList<Integer> listInt = new ArrayList<Integer>();
		listInt.add(2);
		listInt.add(4);
		listInt.add(1);
		listInt.add(5);
		listInt.add(8);
		
		int position = Collections.binarySearch(listInt, 2);
		System.out.println("The Position of 3 is = "+ position);

	}

}
