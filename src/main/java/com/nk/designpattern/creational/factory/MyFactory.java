package com.nk.designpattern.creational.factory;

public class MyFactory {

	public static Computer getInstance(String type) {

		if (type.equalsIgnoreCase("PC")) {
			return new PC();
		} else if (type.equalsIgnoreCase("PC1")) {
			return new PC2();
		}
		return null;
	}

}
