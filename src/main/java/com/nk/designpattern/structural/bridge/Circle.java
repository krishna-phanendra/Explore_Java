package com.nk.designpattern.structural.bridge;

public class Circle extends Shape {

	Circle(DrawAPI drawapi) {
		super(drawapi);
	}

	@Override
	public void draw() {
		drawapi.draw();
	}
}
