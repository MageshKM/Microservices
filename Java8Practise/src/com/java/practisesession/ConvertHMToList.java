package com.java.practisesession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertHMToList {
	public static void main(String args[]) {

		Map<String, String> hmObj = new HashMap<String, String>();

		hmObj.put("Magesh", "Developer");
		hmObj.put("Rajesh", "Developer");
		hmObj.put("Kumer", "Developer");
		hmObj.put("Ram", "Developer");

		List<String> consolidate = Stream.of(hmObj.keySet(), hmObj.values()).flatMap(l -> l.stream())
				.collect(Collectors.toList());
		System.out.println("Consolidate list :" + consolidate);
		Map<String, Long> resultMap = hmObj.values().stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println("GroupBy Value : " + resultMap);
		
 

	}
}
