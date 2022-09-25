package com.nk.designpattern.behavioral.observer;

public class OctaObserver extends Observer {

	protected OctaObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Octal Observer : " + Integer.toOctalString(subject.getState()));
	}

}
