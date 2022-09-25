package com.nk.threads.threadlocal;

public class MyThreadLocal {

	private ThreadLocal<String> tl = new ThreadLocal<>() {
		/* initializing thread local variable */
		protected String initialValue() {
			return "Initial Value";
		};
	};

	public String get() {
		return tl.get();
	}

	public void set(String value) {
		this.tl.set(value);
	}

	public void remove() {
		this.tl.remove();
	}

	public static void main(String[] args) {
		MyThreadLocal mtl = new MyThreadLocal();
		System.out.println("------->" + mtl.get());
	}
}
