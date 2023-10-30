package com.java.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

enum Day { MONDAY, TUESDAY, FRIDAY};
public class FindProcessor {
	public static void main(String args[]) {
		int coreCount = Runtime.getRuntime().availableProcessors();
		
		System.out.println("Available Process is :"+ coreCount);
		
		
		// Creating an object of Set and  
        // declaring object of type String 
        Set<String> hs = new HashSet<String>(); 
  
        // Adding elements to above object 
        // using add() method 
        hs.add("B"); 
        hs.add("B"); 
        hs.add("C"); 
        hs.add("A"); 
  
        // Printing the elements inside the Set object 
        System.out.println(hs); 
        
        
        Map<String,String> cache = new HashMap<String, String>();
        cache.put(null, "test");
        
        Map<String,String> cache1 = new Hashtable<String, String>();
        //cache1.put(null, "test"); //NullPointer Exception will throw...
        
        List<Integer> integers = new CopyOnWriteArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        Iterator<Integer> itr = integers.iterator();
        while (itr.hasNext()) {
            Integer a = itr.next();
            integers.remove(a);
        }
        
        Day d = Day.FRIDAY;
        
        System.out.println("Day :"+d);
	}

}
