package com.nk.designpattern.creational.factory;

public class PC extends Computer {

	@Override
	public String getRAM() {
		return "8";
	}

	@Override
	public String getHDD() {
		return "512";
	}

	@Override
	public String getCPU() {
		return "2.4";
	}

}
