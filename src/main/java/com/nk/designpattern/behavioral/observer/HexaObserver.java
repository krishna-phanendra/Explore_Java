package com.nk.designpattern.behavioral.observer;

public class HexaObserver extends Observer {
	
	protected HexaObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Hexa Observer : "+ Integer.toHexString(subject.getState()));
		
	}

}
