package com.nk.threads.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureEx3 {

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
		return CompletableFuture.supplyAsync(() -> compute());

	}

	public static void main(String[] args) {
		System.out.println("main : " + Thread.currentThread());
		
		/**
		 * CompletableFuture never ends
		 */
		create()
			.thenApply(data -> data * 2)
			.thenApply(data -> data + 1)
			.thenAccept(data -> printIt(data))
			.thenRun(() -> System.out.println("all done"))
			.thenRun(() -> System.out.println("keep on going"));
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
