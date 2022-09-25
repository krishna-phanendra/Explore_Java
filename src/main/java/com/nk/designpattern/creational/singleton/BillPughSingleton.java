package com.nk.designpattern.creational.singleton;

public class BillPughSingleton {

	private BillPughSingleton() {
	}

	private static class MySingletonInstance {
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}

	public static BillPughSingleton getInstance() {
		return MySingletonInstance.INSTANCE;
	}
}
