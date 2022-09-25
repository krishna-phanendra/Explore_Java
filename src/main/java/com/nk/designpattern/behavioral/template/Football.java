package com.nk.designpattern.behavioral.template;

public class Football extends Game {

	@Override
	public void initialise() {
		System.out.println("Initializing foot ball....");

	}

	@Override
	public void startGame() {
		System.out.println("Start Game");

	}

	@Override
	public void endGame() {
		System.out.println("End Game");
	}

}
