package com.nk.threads;

public class MyObject {

	private long inc = 0;

	public void increment() {
		for (int i = 0; i < 100; i++)
			inc++;
	}

	public long getvalue() {
		return inc;
	}

}
