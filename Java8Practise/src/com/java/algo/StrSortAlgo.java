package com.java.algo;

import java.util.ArrayList;
import java.util.Collections;

public class StrSortAlgo {
	
	public static void main(String args[])
	{
		ArrayList<Integer> listInt = new ArrayList<Integer>();
		listInt.add(2);
		listInt.add(4);
		listInt.add(1);
		listInt.add(5);
		listInt.add(8);
		System.out.println(listInt);
		
		Collections.sort(listInt);
		
		System.out.println(listInt);
	}

}
