package com.nk.threads;

public class SharedRunnableTest {

	public static void main(String[] args) {
		
		MyRunnable r = new MyRunnable();
		MyRunnable r1 = new MyRunnable();
		
		Thread t = new Thread(r, "Thread-1");
		Thread t1 = new Thread(r1, "Thread-2");
		
		t.start();
		t1.start();
	}

}
