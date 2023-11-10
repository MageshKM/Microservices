package com.java.practisesession;

import java.util.ArrayList;
import java.util.Spliterator;

public class SpliteratorExam {
	public static void main(String args[])
	{
		ArrayList<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
        
		Spliterator<String> spliterator = list.spliterator();
		 
		int expected = Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;
		 
		System.out.println(spliterator.characteristics() == expected);  //true
		 
		if (spliterator.hasCharacteristics(Spliterator.ORDERED)) {
		    System.out.println("ORDERED");
		}
		 
		if (spliterator.hasCharacteristics(Spliterator.DISTINCT)) {
		    System.out.println("DISTINCT");
		}
		 
		if (spliterator.hasCharacteristics(Spliterator.SORTED)) {
		    System.out.println("SORTED");
		}
		 
		if (spliterator.hasCharacteristics(Spliterator.SIZED)) {
		    System.out.println("SIZED");
		}
		 
		if (spliterator.hasCharacteristics(Spliterator.CONCURRENT)) {
		    System.out.println("CONCURRENT");
		}
		 
		if (spliterator.hasCharacteristics(Spliterator.IMMUTABLE)) {
		    System.out.println("IMMUTABLE");
		}
		 
		if (spliterator.hasCharacteristics(Spliterator.NONNULL)) {
		    System.out.println("NONNULL");
		}
		 
		if (spliterator.hasCharacteristics(Spliterator.SUBSIZED)) {
		    System.out.println("SUBSIZED");
		}
	}

}
