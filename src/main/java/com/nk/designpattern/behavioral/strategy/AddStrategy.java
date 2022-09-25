package com.nk.designpattern.behavioral.strategy;

public class AddStrategy implements Strategy {

	@Override
	public void doCalculation(int num1, int num2) {
		System.out.println("SUM : " + (num1 + num2));
	}

}
