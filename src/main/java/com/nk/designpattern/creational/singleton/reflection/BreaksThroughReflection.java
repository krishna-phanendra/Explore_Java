package com.nk.designpattern.creational.singleton.reflection;

import java.lang.reflect.Constructor;

class MySingleton {

	private static final MySingleton ms = new MySingleton();

	private MySingleton() {

	}

	public static MySingleton getInstance() {
		return ms;
	}
}

public class BreaksThroughReflection {

	public static void main(String[] args) {
		MySingleton ins1 = MySingleton.getInstance();
		System.out.println("ins1 : " + ins1);
		MySingleton ins2 = null;

		Constructor<?>[] declaredConstructors = MySingleton.class.getDeclaredConstructors();
		for (Constructor<?> constructor : declaredConstructors) {
			constructor.setAccessible(true);
			try {
				ins2 = (MySingleton) constructor.newInstance();
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("ins2 : "+ins2);
		
//		Integer i1 = 10;
//		Integer i2 = 10;
//		
//		System.out.println("equals : "+ (i1 == i2));
//		
//		Integer i3 = new Integer(10);
//		Integer i4 = new Integer(10);
//		
//		System.out.println("equals : "+ (i3 == i4));
//		System.out.println("equals : "+ (i3.equals(i4)));
		
		
		
	}

}
