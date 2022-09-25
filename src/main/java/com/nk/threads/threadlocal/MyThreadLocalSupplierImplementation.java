package com.nk.threads.threadlocal;

import java.util.function.Supplier;

public class MyThreadLocalSupplierImplementation {

	private ThreadLocal<String> tl = ThreadLocal.withInitial(new Supplier<String>() {
		public String get() {
			return "initialValue";
		}
	});

	public String get() {
		return this.tl.get();
	}

	public void set(String value) {
		this.tl.set(value);
	}

	public void remove() {
		this.tl.remove();
	}

	public static void main(String[] args) {
		MyThreadLocalSupplierImplementation mtls = new MyThreadLocalSupplierImplementation();
		System.out.println("initial value : " + mtls.get());
		mtls.set("value 1");
		System.out.println("updated value : " + mtls.get());
		mtls.remove();
		System.out.println("initial value : " + mtls.get());
	}
}
