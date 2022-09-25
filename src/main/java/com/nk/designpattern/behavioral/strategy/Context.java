package com.nk.designpattern.behavioral.strategy;

public class Context {

	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public void executeStrategy(int num1, int num2) {
		strategy.doCalculation(num1, num2);
	}
}
