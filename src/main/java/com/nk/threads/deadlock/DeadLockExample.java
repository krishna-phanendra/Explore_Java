package com.nk.threads.deadlock;

public class DeadLockExample {

	public static void main(String[] args) throws InterruptedException {
		
		A a = new A();
		
		Runnable run = a::a;
		
		Runnable run1 = a::b;
		
		
		Thread t = new Thread(run);
		Thread t1 = new Thread(run1);
		
		t.start();
		t1.start();
		
		t.join();
		t1.join();
		
	}
}
