package com.nk.innerclasses.member;

/**
 * A non-static class that is created inside a class but outside a method is
 * called member inner class.
 * 
 * Inner class variable cannot be accessed by Outer class
 * 
 *
 */

public class Outer {

	private String str = "outer variable";

	class Inner {

		public void printOuterClassVariable() {
			System.out.println("str : " + str);
		}

	}

	public void printInnerClassVariable() {
		str = "";
	}

//	public static void main(String[] args) {
//		Outer.Inner i = new Outer().new Inner();
//		i.printOuterClassVariable();
//		
//		Inner inr = new Outer().new Inner();
//		inr.printOuterClassVariable();
//	}

}
