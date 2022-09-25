package com.nk.designpattern.creational.factory;

public class PC2 extends Computer {

	@Override
	public String getRAM() {
		return "16";
	}

	@Override
	public String getHDD() {
		return "1024";
	}

	@Override
	public String getCPU() {
		return "3.2";
	}
}
