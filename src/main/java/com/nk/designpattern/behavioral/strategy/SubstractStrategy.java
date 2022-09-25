package com.nk.designpattern.behavioral.strategy;

public class SubstractStrategy implements Strategy {

	@Override
	public void doCalculation(int num1, int num2) {
		System.out.println("SUBSTRACT : " + (num1 - num2));
	}
}
