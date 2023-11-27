package com.java.practisesession;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MapObjDemo {

	public static void main(String[] args) {
		Map<String, String> map = Arrays
				.stream(new String[][] { { "1", "GFG" }, { "2", "Geek" }, { "3", "GeeksForGeeks" } })
				.collect(Collectors.toMap(keyMapper -> keyMapper[0], valueMapper -> valueMapper[1]));

		System.out.println("Map Object :" + map);

		String[][] nestStr = new String[][] { { "Magehs", "Kumar" }, { "Rajesh", "Kumar" }, { "Ram", "Kumar" } };
		Map<String, String> mapObj = Arrays.stream(nestStr).collect(Collectors.toMap(k -> k[0], v -> v[1]));
		System.out.println("Map Object :" + mapObj);

	}

}
