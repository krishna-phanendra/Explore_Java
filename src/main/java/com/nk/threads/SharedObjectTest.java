package com.nk.threads;

public class SharedObjectTest {
	
	public static void main(String[] args) {
		
		MyObject obj = new MyObject();
		MyRunnable r = new MyRunnable(obj);
		MyRunnable r1 = new MyRunnable(obj);
		
		Thread t = new Thread(r, "Thread-1");
		t.start();
		try {
			t.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t1 = new Thread(r, "Thread-2");
		
		t1.start();
		
	}

}
