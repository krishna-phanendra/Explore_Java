package com.nk.synchronization.syncmethod;

public class Table {

	public void printTable(int n) {
		for (int i = 0; i < 10; i++) {
			System.out.println(i * n);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void printSyncTable(int n) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i * n);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
