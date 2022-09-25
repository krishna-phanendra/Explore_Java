package com.nk.threads.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureEx {

	// compute method will execute async in different thread
	public static int compute() {
		System.out.println("compute method : " + Thread.currentThread());
		sleep(500);
		return 2;
	}

	// Here printIt method may execute in new Thread or in the main thread.
	public static void printIt(int value) {
		System.out.println(value);
		System.out.println("printIt method : " + Thread.currentThread());
	}

	public static CompletableFuture<Integer> create() {
		System.out.println("completableFuture : " + Thread.currentThread());
		return CompletableFuture.supplyAsync(() -> compute());

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("main : " + Thread.currentThread());
//		create().thenAccept(data -> printIt(data));

		sleep(1000);
		CompletableFuture<Integer> cf = create();

		/*
		 * by the time execution come here, async call(compute()) may be completed then
		 * below printIt() will run in the main thread, because compute() thread won't wait or
		 * don't block its thread to execute below piece of code.
		 */ 
		cf.thenAccept(data -> printIt(data));
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
