package com.nk.designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	private int state;

	private List<Observer> observerList = new ArrayList<Observer>();

	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return this.state;
	}

	public void attach(Observer observer) {
		observerList.add(observer);
	}

	public void notifyAllObservers() {
		for (Observer o : observerList) {
			o.update();
		}
	}

}
