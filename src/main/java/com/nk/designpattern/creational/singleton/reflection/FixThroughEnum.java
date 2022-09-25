package com.nk.designpattern.creational.singleton.reflection;

import java.lang.reflect.Constructor;

enum MyEnumSingleton {
	INSTANCE;

	public double compute(double a, double b) {
		return a * b;
	}
	
	public static MyEnumSingleton getInstance() {
		return INSTANCE;
	}
	
}

public class FixThroughEnum {

	public static void main(String[] args) {
		MyEnumSingleton ins1 = MyEnumSingleton.getInstance();
		
		MyEnumSingleton ins2 = MyEnumSingleton.getInstance();
		
		Constructor<?>[] declaredConstructors = MyEnumSingleton.class.getDeclaredConstructors();
		for (Constructor<?> constructor : declaredConstructors) {
			constructor.setAccessible(true);
			try {
				ins2 = (MyEnumSingleton) constructor.newInstance();
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("ins1 : "+ins1.hashCode());
		System.out.println("ins2 : "+ins2.hashCode());
	}
}
