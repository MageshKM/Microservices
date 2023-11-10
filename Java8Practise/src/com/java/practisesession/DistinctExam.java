package com.java.practisesession;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctExam {
	public static void main(String args[]) {
		String str = "qewrqpnqweirjqiopwerjoqijonopinin";
		StringBuffer sb = new StringBuffer();
		str.chars().distinct().forEach(c -> sb.append((char) c));
		System.out.println(sb.toString());
		
		String sample = "abcabc";
		StringBuffer sbb = new StringBuffer();
		sample.chars().distinct().forEach(c -> sbb.append((char)c));
		System.out.println(sbb);

		List<String> val = Arrays.asList("MAgesh", "Magesh", "Ashok", "Ashok");

		val.stream().map(c -> c.toLowerCase()).distinct().collect(Collectors.toList()).forEach(System.out::println);

		// val.stream().map(m ->
		// m.toLowerCase()).distinct().collect(Collectors.toList()).forEach(System.out::println);
	}

}
