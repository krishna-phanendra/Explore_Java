package com.nk.designpattern.creational.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonTest {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 150; i++) {
//			executor.execute(() -> {
//				System.out.println("hashcode : " + MySingletonObject.getInstance());
			
			executor.execute(() -> {
				System.out.println("hashcode : " + BillPughSingleton.getInstance());
			
			});
		}
	}
}
