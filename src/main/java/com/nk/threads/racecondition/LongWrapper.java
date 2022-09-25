package com.nk.threads.racecondition;

public class LongWrapper {

	/**
	 * added a key object, to lock the instance on this key
	 */
	private Object key = new Object();

	private long value;

	public LongWrapper(long value) {
		this.value = value;
	}

	public long getValue() {
		return value;
	}

	public void increment() {
		/**
		 * to avoid race condition, added lock on key
		 */
		synchronized (key) {
			value = value + 1;
		}
	}

}
