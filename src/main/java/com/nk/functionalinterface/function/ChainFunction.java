package com.nk.functionalinterface.function;

import java.util.function.Function;

public class ChainFunction {

	public static void main(String[] args) {

		Function<String, Integer> func = x -> x.length();

		Function<Integer, Integer> func1 = x -> x * x;

		Integer length = func.andThen(func1).apply("Phanendra");

		System.out.println("length : " + length);

	}

}
