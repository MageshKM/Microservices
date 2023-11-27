package com.java.practisesession;

//Java code to illustrate 
//Fail Fast Iterator in Java 
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class FailFastExample {
	public static void main(String[] args) {
		Map<String, String> cityCode = new HashMap<String, String>();
		cityCode.put("Delhi", "India");
		cityCode.put("Moscow", "Russia");
		cityCode.put("New York", "USA");

		Iterator iterator = cityCode.keySet().iterator();

		while (iterator.hasNext()) {
			System.out.println(cityCode.get(iterator.next()));

			// adding an element to Map
			// exception will be thrown on next call
			// of next() method.
			//cityCode.put("Istanbul", "Turkey");
		}

		Hashtable<String, String> kvObj = new Hashtable<String, String>();
		kvObj.put("Delhi", "India");
		kvObj.put("Moscow", "Russia");
		kvObj.put("New York", "USA");

		Iterator iter = kvObj.keySet().iterator();

		while (iter.hasNext()) {
			System.out.println(iter.next());

			kvObj.put("test", "put");
		}

	}
}


