package com.nk.designpattern.creational.builder.scenario2;

public class Coke extends ColdDrink{

	@Override
	public String name() {
		return "Coke";
	}

	@Override
	public float price() {
		return 2.50f;
	}

}
