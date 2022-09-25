package com.nk.generics.genericfunction;

public class Test {
	
	public static <T> void print(T t) {
		System.out.println("T : "+t);
	}

	public static void main(String[] args) {
		print(12);
		print("Test");
		print(Double.valueOf(12.5466));
	}
}
