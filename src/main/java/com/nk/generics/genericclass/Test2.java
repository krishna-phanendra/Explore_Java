package com.nk.generics.genericclass;

public class Test2<T, M> {

	T obj;
	M obj2;

	public Test2(T obj, M obj2) {
		this.obj = obj;
		this.obj2 = obj2;
	}

	public void print() {
		System.out.println("Obj1 : " + obj + ", Obj2 : " + obj2);
	}
	
	public static void main(String[] args) {
		Test2<Integer, String> t = new Test2<>(124, "text1");
		t.print();
		
		Test2<String, String> t1 = new Test2<>("124", "text2");
		t1.print();
	}

}
