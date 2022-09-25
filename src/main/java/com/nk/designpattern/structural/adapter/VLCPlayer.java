package com.nk.designpattern.structural.adapter;

public class VLCPlayer implements AdvanceMediaPlayer {

	@Override
	public void playVLC() {
		System.out.println("Playing VLC format.");
	}

	@Override
	public void playMP4() {
		// TODO Auto-generated method stub

	}

}
