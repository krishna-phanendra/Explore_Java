package com.nk.threads;

public class MyRunnableSeparate implements Runnable {

	private int count = 0;

	@Override
	public void run() {

		synchronized (this) {
			for (int i = 0; i < 1000000; i++)
				count++;
		}
		System.out.println(Thread.currentThread().getName() + ", count : " + count);

	}

}
