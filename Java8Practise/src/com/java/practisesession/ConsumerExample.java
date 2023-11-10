package com.java.practisesession;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerExample {
	public static void main(String args[]) {
		Consumer<String> consumer = (t) -> System.out.println(t);
		consumer.accept("Ramesh");
		
		Supplier<Date> supplier  = () -> new Date();
		
		supplier.get().getDate();
	}

}
