package com.nk.threads;

public class SeparateRunnableTest {
	
	public static void main(String[] args) {
		
		MyRunnableSeparate mrs = new MyRunnableSeparate();
		
		Thread t = new Thread(mrs,"Thread-1");
		Thread t1 = new Thread(mrs, "Thread-2");
		t.start();
		t1.start();
	}

}
