package com.nk.datastructures.stack;

public class CustomStackTest {

	public static void main(String[] args) {
		CustomStack<String> stack = new CustomStack<String>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		stack.push("E");
		stack.push("F");
		
		System.out.println("Initial size : " + stack.size());
		
//		System.out.println("POP : " + stack.pop());
		System.out.println("POP : " + stack.access("F"));

		System.out.println("size : " + stack.size());
	}

}
