package com.nk.innerclasses.local;

/**
 * A class i.e. created inside a method is called local inner class in java. If
 * you want to invoke the methods of local inner class, you must instantiate
 * this class inside the method.
 *
 */
public class LocalInnerClass {

	private String str = "Local Inner Class.....";

	public void localClassMethod() {
		class Local {
			private void localMethod() {
				System.out.println("Outer class variable str : " + str);
			}
		}

		Local l = new Local();
		l.localMethod();
	}

}
