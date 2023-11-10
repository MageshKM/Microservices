package com.java.practisesession;

import java.util.ArrayList;
import java.util.Spliterator;

public class TrySpliterator {
	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(2);

		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(3);
		list.add(null);
		list.add(5);
		list.add(6);
		list.add(7);

		Spliterator<Integer> spliterator1 = list.spliterator();
		Spliterator<Integer> spliterator2 = spliterator1.trySplit();
		Spliterator<Integer> spliterator3 = spliterator2.trySplit();
		Spliterator<Integer> spliterator4 = spliterator3.trySplit();

		spliterator1.forEachRemaining(System.out::println);

		System.out.println("========" + spliterator1.getExactSizeIfKnown());

		spliterator2.forEachRemaining(System.out::println);

		System.out.println("========" + spliterator2.getExactSizeIfKnown());

		spliterator3.forEachRemaining(System.out::println);

		System.out.println("========" + spliterator3.getExactSizeIfKnown());

		spliterator4.forEachRemaining(System.out::println);

		int expected = Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;

		System.out.println(spliterator2.characteristics() == expected); // true

		if (spliterator2.hasCharacteristics(Spliterator.ORDERED)) {
			System.out.println("ORDERED");
		}

		if (spliterator2.hasCharacteristics(Spliterator.DISTINCT)) {
			System.out.println("DISTINCT");
		}

		if (spliterator2.hasCharacteristics(Spliterator.SORTED)) {
			System.out.println("SORTED");
		}

		if (spliterator2.hasCharacteristics(Spliterator.SIZED)) {
			System.out.println("SIZED");
		}

		if (spliterator2.hasCharacteristics(Spliterator.CONCURRENT)) {
			System.out.println("CONCURRENT");
		}

		if (spliterator2.hasCharacteristics(Spliterator.IMMUTABLE)) {
			System.out.println("IMMUTABLE");
		}

		if (spliterator2.hasCharacteristics(Spliterator.NONNULL)) {
			System.out.println("NONNULL");
		}

		if (spliterator2.hasCharacteristics(Spliterator.SUBSIZED)) {
			System.out.println("SUBSIZED");
		}
	}

}
