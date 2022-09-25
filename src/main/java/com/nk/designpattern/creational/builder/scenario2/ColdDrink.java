package com.nk.designpattern.creational.builder.scenario2;

public abstract class ColdDrink implements Item {

	public Packing packing() {
		return new Bottle();
	}

}
