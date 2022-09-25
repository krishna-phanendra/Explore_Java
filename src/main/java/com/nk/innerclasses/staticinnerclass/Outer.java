package com.nk.innerclasses.staticinnerclass;

/**
 * A static class i.e. created inside a class is called static nested class in
 * java. It cannot access non-static data members and methods. It can be
 * accessed by outer class name.
 * 
 * - It can access static data members of outer class including private. -
 * Static nested class cannot access non-static (instance) data member or
 * method.
 *
 */
public class Outer {

	private static String str = "Outer Class Variable";

	static class Inner {
		
		public Inner() {
			
		}
		
		public void print() {
			System.out.println("From Static Inner Class....." + str);
		}

		public static void printStatic() {
			System.out.println("From Static Inner Class , static method....." + str);
		}
	}

}
