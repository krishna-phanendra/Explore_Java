package com.nk.threads.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class CompletableFutureEx2 {

	public static ForkJoinPool fjp = new ForkJoinPool(10);
	
	// compute method will execute async in different thread
	public static int compute() {
		System.out.println("compute method : " + Thread.currentThread());
		return 2;
	}

	// Here printIt method may execute in new Thread or in the main thread.
	public static void printIt(int value) {
		System.out.println(value);
		System.out.println("printIt method : " + Thread.currentThread());
	}

	public static CompletableFuture<Integer> create() {
		System.out.println("completableFuture : " + Thread.currentThread());
		/**
		 * Here assigning new ForkJoinPool to execute instead of common pool.
		 */
		return CompletableFuture.supplyAsync(() -> compute(), fjp);

	}

	public static void main(String[] args) {
		System.out.println("main : " + Thread.currentThread());
		
		create().thenAccept(data -> printIt(data));
	}

	private static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
