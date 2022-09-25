package com.nk.designpattern.structural.adapter;

public class Test {
	
	public static void main(String[] args) {
		MediaPlayer player = new AudioPlayer();
		player.play("MP4");
		player.play("VLC");
		player.play("MP3");
	}

}
