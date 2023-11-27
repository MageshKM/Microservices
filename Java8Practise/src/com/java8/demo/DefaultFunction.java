package com.java8.demo;

import java.util.function.Function;

@FunctionalInterface
public interface DefaultFunction<A, B, C> {
	C add(A a, B b);

	default Function<A, C> multiple(B b) {
		return a -> this.add(a, b);
	}

}
