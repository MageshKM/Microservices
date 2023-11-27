package com.java8.demo;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringJoinerDemo {
	public static void main(String args[]) {

		System.out.println("1. Type to add delimiter to string sepration");
		StringJoiner sj = new StringJoiner(",", "[", "]");

		sj.add("Magesh");
		sj.add("Kumar");
		sj.add("Rajesh");
		sj.add("Ramesh");
		sj.add("Suresh");
		sj.add("John");
		sj.add("Micheal");

		System.out.println(sj.toString());

		System.out.println("2. Type to add delimiter to string sepration");
		List<String> list = Arrays.asList("life insurance", "health insurance", "car insurance");
		String fromStream = list.stream().map(String::toUpperCase).collect(Collectors.joining(", "));

		System.out.println(fromStream);

		System.out.println("3. Type to add delimiter to string sepration");
		List<String> typesOfLoan = Arrays.asList("home loan", "personal loan", "car loan", "balance transfer");
		String loans = String.join(",", typesOfLoan);
		System.out.println("joining list elements: " + loans);

		// 1. test string 1
		String str1 = "in.bench.resources.java8.string.methods";
		System.out.println("Original String :- " + str1);

		// 1.1 split String on the basis of Dot/Period (.) delimiter
		String[] dotDelimiterArr = Stream.of(str1).map(str -> str.split("\\.")).findFirst().get();
		System.out.println("Dot/Period splitted String :- " + Arrays.toString(dotDelimiterArr));

		// 2. test string 2
		String str2 = "24-July-1985";
		System.out.println("\nOriginal String :- " + str2);

		// 2.1 split String on the basis of Hyphen (-) delimiter
		String[] hyphenDelimiterArr = Stream.of(str2).map(str -> str.split("\\-")).findFirst().get();
		System.out.println("Hyphen splitted String :- " + Arrays.toString(hyphenDelimiterArr));

		// 3. test string 3
		String str3 = "Java is super cool language";
		System.out.println("\nOriginal String :- " + str3);

		// 3.1 split String on the basis of space ( ) delimiter
		String[] spaceDelimiterArr = Stream.of(str3).map(str -> str.split("\\s")).findFirst().get();
		System.out.println("Space splitted String :- " + Arrays.toString(spaceDelimiterArr));

		// 4. test string 4
		String str4 = "16/02/1987";
		System.out.println("\nOriginal String :- " + str4);

		// 4.1 split String on the basis of forward-slash (/) delimiter
		String[] fwdSlashDelimiterArr = Stream.of(str4).map(str -> str.split("\\/")).findFirst().get();
		System.out.println("Forward-slash splitted String :- " + Arrays.toString(fwdSlashDelimiterArr));

		// 5. test string 5
		String str5 = "Mango|Apple|Melon|Grape|Cherry";
		System.out.println("\nOriginal String :- " + str5);

		// 5.1 split String on the basis of pipe (|) delimiter
		String[] pipeDelimiterArr = Stream.of(str5).map(str -> str.split("\\|")).findFirst().get();
		System.out.println("Pipe splitted String :- " + Arrays.toString(pipeDelimiterArr));

		// 6. test string 6
		String str6 = "20:35:24";
		System.out.println("\nOriginal String :- " + str6);

		// 6.1 split String on the basis of colon (:) delimiter
		String[] colonDelimiterArr = Stream.of(str6).map(str -> str.split("\\:")).findFirst().get();
		System.out.println("Colon splitted String :- " + Arrays.toString(colonDelimiterArr));

		// 7. test string 7
		String str7 = "Simran;Sneha;Meena;Soundarya;Roja;Nagma;Kushbhu";
		System.out.println("\nOriginal String :- " + str7);

		// 7.1 split String on the basis of semi-colon (;) delimiter
		String[] semiColonDelimiterArr = Stream.of(str7).map(str -> str.split("\\;")).findFirst().get();
		System.out.println("Semi-Colon splitted String :- " + Arrays.toString(semiColonDelimiterArr));

		// 8. test string 8
		String str8 = "1,SJ,Admin,BRN,800,2014,2022";
		System.out.println("\nOriginal String :- " + str8);

		// 8.1 split String on the basis of comma (,) delimiter
		String[] commaDelimiterArr = Stream.of(str8).map(str -> str.split("\\,")).findFirst().get();
		System.out.println("Comma splitted String :- " + Arrays.toString(commaDelimiterArr));
	}
}
