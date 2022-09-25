package com.nk.designpattern.behavioral.template;

public abstract class Game {

	public abstract void initialise();

	public abstract void startGame();

	public abstract void endGame();

	public void play() {
		initialise();

		startGame();

		endGame();
	}
}
