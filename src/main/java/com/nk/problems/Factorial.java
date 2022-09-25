package com.nk.problems;

public class Factorial {

	public static void main(String[] args) {
		int factorialOf = 5;
		int result = 1;
		String str = "";
		for (int i = factorialOf; i > 0; i--) {
			str = str + i + "*";
			result = result * i;
		}

		System.out.println(str + " = " + result);
	}

}
