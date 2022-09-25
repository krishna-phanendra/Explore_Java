package com.nk.generics.genericclass;

public class Test<T> {

	T obj;

	public void set(T obj) {
		this.obj = obj;
	}

	public T get() {
		return this.obj;
	}

	public static void main(String[] args) {
		Test<Integer> t = new Test<>();
		t.set(20);

		System.out.println("T Integer type : " + t.get());
		
		Test<String> t1 = new Test<>();
		t1.set("20");
		System.out.println("T String type: " + t1.get());
	}
}
