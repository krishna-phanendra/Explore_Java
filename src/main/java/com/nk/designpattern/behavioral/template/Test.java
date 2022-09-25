package com.nk.designpattern.behavioral.template;

public class Test {

	public static void main(String[] args) {
		Game g = new Cricket();
		g.play();
		
		g = new Football();
		g.play();
	}

}
