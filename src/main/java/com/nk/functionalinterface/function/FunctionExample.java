package com.nk.functionalinterface.function;

import java.util.function.Function;

public class FunctionExample {

	public static void main(String[] args) {
		Function<String, Integer> func = x -> x.length();
		Integer length = func.apply("krishna");
		System.out.println("length : " + length);
		
		
	}

}
