package com.nk.designpattern.structural.bridge;

public class GreenCircle implements DrawAPI {

	@Override
	public void draw() {
		System.out.println("Green Circle");
	}

}
