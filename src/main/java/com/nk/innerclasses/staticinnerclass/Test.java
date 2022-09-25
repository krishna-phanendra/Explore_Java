package com.nk.innerclasses.staticinnerclass;

import com.nk.innerclasses.staticinnerclass.Outer.Inner;

public class Test {
	public static void main(String[] args) {
		Outer.Inner inr = new Outer.Inner();
		inr.print();
		
		Outer.Inner.printStatic();
		
		Inner.printStatic();
	}
}
