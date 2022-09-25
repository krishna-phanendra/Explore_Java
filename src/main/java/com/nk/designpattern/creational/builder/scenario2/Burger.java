package com.nk.designpattern.creational.builder.scenario2;

public abstract class Burger implements Item {

	@Override
	public Packing packing() {
		return new Wrapper();
	}
}
