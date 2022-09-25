package com.nk.synchronization.syncmethod;

public class SyncTableTest {

	public static void main(String[] args) {
		Table tb = new Table();
		Runnable r = () -> {
			tb.printSyncTable(5);
		};

		Thread t = new Thread(r);

		Thread t1 = new Thread(() -> {
//			Table tb1 = new Table();
			tb.printSyncTable(100);
		});

		t.start();
		t1.start();
	}
}
