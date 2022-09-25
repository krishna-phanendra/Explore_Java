package com.nk.designpattern.structural.adapter;

public class MP4Player implements AdvanceMediaPlayer {

	@Override
	public void playVLC() {
		// TODO Auto-generated method stub

	}

	@Override
	public void playMP4() {
		System.out.println("Playing MP4 format.");
	}

}
