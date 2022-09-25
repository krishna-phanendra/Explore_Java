package com.nk.designpattern.creational.builder.scenario2;

import java.util.ArrayList;
import java.util.List;

public class Meal {

	private List<Item> itemsList = new ArrayList<>();

	public void addItem(Item item) {
		itemsList.add(item);
	}

	public float getCost() {
		float cost = 0f;
		for (Item item : itemsList) {
			cost += item.price();
		}
		return cost;
	}
	
	public void showItems() {
		for (Item item : itemsList) {
			System.out.println("item : "+item.name());
			System.out.println("pricer : "+item.price());
			System.out.println("packing : "+item.packing().pack());
		}
	}

}
