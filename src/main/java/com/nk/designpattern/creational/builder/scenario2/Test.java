package com.nk.designpattern.creational.builder.scenario2;

public class Test {
	public static void main(String[] args) {
		MealBuilder builder = new MealBuilder();
		Meal vegMeal = builder.prepareVegMeal();
		vegMeal.showItems();
		
		Meal nonVegMeal = builder.prepareNonVegMeal();
		nonVegMeal.showItems();

	}
}
