package com.nk.threads.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureEx4 {
	
	/**
	 * creating a  pipeline to do some operations after assigning some data
	 */
	public static void process(CompletableFuture<Integer> cf) {
		cf.exceptionally(throwable -> handle(throwable))
			.thenApply(data ->  data * 2)
			.thenApply(data -> data + 1)
			.thenAccept(data -> printIt(data));
	}

	private static int handle(Throwable throwable) {
		System.out.println("ERROR : "+throwable);
		throw new RuntimeException("Beyond repair..");
//		return 100;
	}

	// Here printIt method may execute in new Thread or in the main thread.
	public static void printIt(int value) {
		System.out.println(value);
		System.out.println("printIt method : " + Thread.currentThread());
	}


	public static void main(String[] args) {
		System.out.println("main : " + Thread.currentThread());
		CompletableFuture<Integer> cf = new CompletableFuture<>();
		//cf.completeOnTimeout(500, 1000, TimeUnit.MILLISECONDS);
		cf.orTimeout(2000, TimeUnit.MILLISECONDS);
		process(cf);
		sleep(5000);
//		cf.complete(2);
//		cf.completeExceptionally(new RuntimeException("something went wrong.."));
//		sleep(3000);
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
