package com.nk.designpattern.structural.adapter;

public class AudioPlayer implements MediaPlayer {

	MediaAdapter mediaAdpt;

	@Override
	public void play(String audioType) {
		if (audioType.equalsIgnoreCase("MP3"))
			System.out.println("Playing MP3 Format.");

		if (audioType.equalsIgnoreCase("VLC") || audioType.equalsIgnoreCase("MP4")) {
			mediaAdpt = new MediaAdapter(audioType);
			mediaAdpt.play(audioType);
		}
	}
}
