package com.nk.threads;

public class Example1 {

	public static class MyThread extends Thread {

		public void run() {
			System.out.println(" Thread running.....");
		}
	}

	public static class MyThreadRunnable implements Runnable {

		public void run() {
			System.out.println(" Thread running.....");
		}
	}

	public static void main(String[] args) {

		Thread t = new MyThread();
		t.start();
		System.out.println("---->" + t.getName());

		MyThreadRunnable tr = new MyThreadRunnable();
		Thread t1 = new Thread(tr);
		t1.start();

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("This is from Runnable Anonymous class");
			}
		});
		t2.start();

		Runnable r = () -> {
			System.out.println("This is from Runnable Lambda expression...");
		};
		Thread t3 = new Thread(r);
		t3.start();

		Thread t4 = new Thread(() -> {
			System.out.println("This is from Thread Lambda expression...");
		});
		t4.start();

	}

}
