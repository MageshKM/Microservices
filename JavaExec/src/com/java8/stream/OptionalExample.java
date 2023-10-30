package com.java8.stream;

import java.util.Optional;

public class OptionalExample {
	public static void main(String args[]) {
		String[] stringAry = new String[5];
		stringAry[0] = "A";
		stringAry[1] = "B";

		Optional<String> optionalFlag = Optional.of(stringAry[1]);

		if (optionalFlag.isPresent()) {
			System.out.println("Present"+ optionalFlag.get());
		} else {
			System.out.println("not Present");
		}

	}

}
