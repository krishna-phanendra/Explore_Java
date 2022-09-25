package com.nk.designpattern.structural.bridge;

public class Test {
	public static void main(String[] args) {
		Shape s1 = new Circle(new RedCircle());
		s1.draw();
		Shape s2 = new Circle(new GreenCircle());
		s2.draw();
	}
}
