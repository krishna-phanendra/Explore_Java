package com.nk.designpattern.behavioral.observer;

public class Test {

	public static void main(String[] args) {
		Subject sub = new Subject();
		new BinaryObserver(sub);
		new HexaObserver(sub);
		new OctaObserver(sub);

		sub.setState(29);
		sub.notifyAllObservers();

		sub.setState(14);
		sub.notifyAllObservers();
	}

}
