package com.nk.designpattern.structural.adapter;

public class MediaAdapter implements MediaPlayer {

	private AdvanceMediaPlayer advPlayer;

	MediaAdapter(String audioType) {
		if (audioType.equalsIgnoreCase("MP4"))
			advPlayer = new MP4Player();
		if (audioType.equalsIgnoreCase("VLC"))
			advPlayer = new VLCPlayer();
	}

	@Override
	public void play(String audioType) {
		if (audioType.equalsIgnoreCase("MP4"))
			advPlayer.playMP4();
		if (audioType.equalsIgnoreCase("VLC"))
			advPlayer.playVLC();
	}

}
