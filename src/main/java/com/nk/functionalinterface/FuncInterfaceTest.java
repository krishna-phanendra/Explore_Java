package com.nk.functionalinterface;

public class FuncInterfaceTest {

	public static void main(String[] args) {

		FuncInterface fi = (s1, s2) -> s1.equalsIgnoreCase(s2);

		boolean equals = fi.isEquals("A", "ab");
		System.out.println("isEquals : " + equals);
	}

}
