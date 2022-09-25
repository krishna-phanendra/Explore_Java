package com.nk.threads;

public class MyRunnable implements Runnable {

	private int count = 0;
	private MyObject myObj = null;

	public MyRunnable() {
	}

	public MyRunnable(MyObject obj) {
		this.myObj = obj;
	}

	@Override
	public void run() {
		myObj = new MyObject();
//		int count=0;
		myObj.increment();

		System.out.println(Thread.currentThread().getName() + ", inc : " + myObj.getvalue() + ", object : " + myObj);

		for (int i = 0; i < 100; i++) {
			count++;
		}
		System.out.println(Thread.currentThread().getName() + ", count : " + count);
	}

}
