package com.java.algo;

import java.util.ArrayList;
import java.util.Collections;

public class RoutineDataManipulAlgo {
	
	public static void main(String args[])
	{
		ArrayList<Integer> listInt = new ArrayList<Integer>();
		listInt.add(2);
		listInt.add(4);
		listInt.add(1);
		listInt.add(5);
		listInt.add(8);
		System.out.println(listInt);
		
		Collections.reverse(listInt);
		
		System.out.println("reverse:"+listInt);
		
		Collections.swap(listInt, 0,1);
		
		System.out.println("swap:"+listInt);
		
		ArrayList<Integer> newList = new ArrayList();
		
		newList.addAll(listInt);
		
		System.out.println("Add All:"+newList);
		
		Collections.fill(newList, -1);
		System.out.println("Fill :"+newList);
		
		Collections.copy(newList, listInt);
		System.out.println("Copy :"+ newList);
		
	}

}
