package com.nk.designpattern.behavioral.template;

public class Cricket extends Game {

	@Override
	public void initialise() {
		System.out.println("Initializing Cricket Game..");

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
