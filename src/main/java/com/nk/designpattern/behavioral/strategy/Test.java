package com.nk.designpattern.behavioral.strategy;

public class Test {

	public static void main(String[] args) {
		Context ctx = new Context(new AddStrategy());
		ctx.executeStrategy(10, 20);

		Context ctx1 = new Context(new SubstractStrategy());
		ctx1.executeStrategy(10, 20);

	}
}
