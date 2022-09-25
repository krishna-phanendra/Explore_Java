package com.nk.threads.racecondition;

public class RaceConditionExample {

	public static void main(String[] args) throws InterruptedException {

		test();

	}

	
	private static void test() throws InterruptedException {
		LongWrapper lw = new LongWrapper(0L);
		
		Runnable run = () -> {
			for (int i = 0; i < 1000; i++) {
				lw.increment();
			}
		};

		Thread[] t = new Thread[100];
		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(run);
			t[i].start();
		}

		for (int i = 0; i < t.length; i++) {
			t[i].join();
		}

		System.out.println("value : " + lw.getValue());
	}

}
