package com.nk.synchronization.syncmethod;

public class TableTest {

	public static void main(String[] args) {

		Table tb = new Table();
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
//				Table t = new Table();
				tb.printTable(5);
			}
		});
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
//				Table t = new Table();
				tb.printTable(100);
			}
		});
		
		t.start();
		t1.start();

	}

}
