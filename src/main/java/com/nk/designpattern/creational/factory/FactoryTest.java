package com.nk.designpattern.creational.factory;

public class FactoryTest {
	
	public static void main(String[] args) {
		Computer ins1 = MyFactory.getInstance("PC");
		System.out.println("PC :"+ins1.toString());
		
		Computer ins2 = MyFactory.getInstance("PC1");
		System.out.println("PC2 :"+ins2.toString());
	}

}
