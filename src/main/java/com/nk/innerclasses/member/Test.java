package com.nk.innerclasses.member;

import com.nk.innerclasses.member.Outer.Inner;

public class Test {
	public static void main(String[] args) {
		Outer.Inner i = new Outer().new Inner();
		i.printOuterClassVariable();
		
		Inner inr = new Outer().new Inner();
		inr.printOuterClassVariable();
	}

}
