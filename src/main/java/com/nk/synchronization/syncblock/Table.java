package com.nk.synchronization.syncblock;

public class Table {

	public void printSyncTable(int n) {
		synchronized (this) {
			for (int i = 1; i <= 10; i++) {
				System.out.println(i * n);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		for (int j = 0; j < 5; j++) {
			System.out.println("outside sync block : " + j * n * 100);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
