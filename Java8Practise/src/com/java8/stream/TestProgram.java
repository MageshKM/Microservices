package com.java8.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestProgram {
	public static void main(String args[]) {
		List<Integer> list = Arrays.asList(16, 12, 9, 19, 11, 8);

		// list.stream().forEach(System.out::println);
		long output = list.stream().limit(3).reduce(0, (i, j) -> i + j);
		// System.out.println(output);
		int init = 3;
		int sum = 0;
		Set<Integer> sumSet = new TreeSet<Integer>();
		for (int i = 0; i < list.size(); i++) {
			sum = 0;
			for (int j = i; j < init; j++) {
				try {
					if (j <= list.size()) {
						System.out.println(list.get(j));
						sum += list.get(j);
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("error");
				}

			}
			init++;
			sumSet.add(sum);
			System.out.println("output:" + sum);
		}
		System.out.println("consolidate Values:" + sumSet);

	}
}
