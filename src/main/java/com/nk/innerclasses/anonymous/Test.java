package com.nk.innerclasses.anonymous;

public class Test {
	public static void main(String[] args) {
		
		Person p = new Person() {
			void update() {
				System.out.println("updating person details...."+str);
				
			}
		};
		
		p.update();
	}

}
