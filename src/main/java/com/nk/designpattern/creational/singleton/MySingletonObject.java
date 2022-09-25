package com.nk.designpattern.creational.singleton;

public class MySingletonObject {

	private static MySingletonObject singletonObject;

	private MySingletonObject() {

	}

	public static MySingletonObject getInstance() {
		if (singletonObject == null) {
			synchronized (MySingletonObject.class) {
				if (singletonObject == null) {
					singletonObject = new MySingletonObject();
				}
			}
		}
		return singletonObject;
	}
}
