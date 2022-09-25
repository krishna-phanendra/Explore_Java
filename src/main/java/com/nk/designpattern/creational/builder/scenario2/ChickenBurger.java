package com.nk.designpattern.creational.builder.scenario2;

public class ChickenBurger extends Burger {

	@Override
	public String name() {
		return "Chicken Burger";
	}

	@Override
	public float price() {
		return 11.99f;
	}

}
