package com.nk.designpattern.creational.builder.scenario2;

public class Pepsi extends ColdDrink{

	@Override
	public String name() {
		return "PEPSI";
	}

	@Override
	public float price() {
		return 1.76f;
	}

}
