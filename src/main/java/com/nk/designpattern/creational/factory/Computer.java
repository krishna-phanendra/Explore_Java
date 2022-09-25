package com.nk.designpattern.creational.factory;

public abstract class Computer {

	public abstract String getRAM();

	public abstract String getHDD();

	public abstract String getCPU();

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getRAM() + ":" + getHDD() + ":" + getCPU();
	}

}
