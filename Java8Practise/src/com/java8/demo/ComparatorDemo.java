package com.java8.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
	public static void main(String args[]) {
		List<Integer> list = Arrays.asList(33, 66, 65, 55);

		Comparator<Integer> numStore = (n1, n2) -> (n1 > n2) ? 1 : (n1 < n2) ? -1 : 0;

		Collections.sort(list, numStore);

		System.out.println(list);
	}
}
