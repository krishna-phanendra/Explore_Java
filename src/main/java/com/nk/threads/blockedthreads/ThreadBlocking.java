package com.nk.threads.blockedthreads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ThreadBlocking {

	public static void main(String[] args) {

//		blockingMainThread();

		completeMethodExample();
	}

	private static void completeMethodExample() {

		/**
		 * completable future, which can he completed only by calling complete()
		 */
		CompletableFuture cf = new CompletableFuture();

		Runnable run = () -> {
			try {
				Thread.sleep(500);
				System.out.println("running task....");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cf.complete(null);
		};

//		CompletableFuture.runAsync(run).thenCombine(other, fn);

		Void nil = (Void) cf.join();

		System.out.println("we are done..");

	}

	private static void blockingMainThread() {

		ExecutorService executor = Executors.newSingleThreadExecutor();
		ExecutorService executor1 = Executors.newSingleThreadExecutor();
		ExecutorService exec2 = Executors.newSingleThreadExecutor();
		ExecutorService exec3 = Executors.newSingleThreadExecutor();
		ExecutorService exec4 = Executors.newSingleThreadExecutor();
		ExecutorService exec5 = Executors.newSingleThreadExecutor();

		Supplier<List<Long>> supplyIds = () -> {
			System.out.println("supplier..." + Thread.currentThread().getName());
			sleep(1000);
			return Arrays.asList(1L, 2L, 3L);
		};

		Function<List<Long>, List<Long>> compute = ids -> {

			System.out.println("ids : " + ids);

			System.out.println("in Function..." + Thread.currentThread().getName());
			sleep(100);
			return ids.stream().map(id -> id * 100).collect(Collectors.toList());
		};

		System.out.println("START");
		CompletableFuture cf = CompletableFuture.supplyAsync(supplyIds, executor).thenApplyAsync(compute, executor1)
				.thenRun(() -> System.out.println(" consume1 runnable")).thenAccept(id -> {
					System.out.println("consume1 : " + id + "---" + Thread.currentThread().getName());
				});

		CompletableFuture cf1 = CompletableFuture.supplyAsync(supplyIds, exec2).thenApplyAsync(compute, exec3)
				.thenAccept(id -> {
					System.out.println("consume2 : " + id + "---" + Thread.currentThread().getName());
				});

		CompletableFuture cf2 = CompletableFuture.supplyAsync(supplyIds, exec4).thenApplyAsync(compute, exec5)
				.thenAccept(id -> {
					System.out.println("consume3 : " + id + "---" + Thread.currentThread().getName());
				});

		CompletableFuture<Void> allOf = CompletableFuture.allOf(cf, cf1, cf2);
		try {
			allOf.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		allOf.complete(null);
	
		executor.shutdown();
		executor1.shutdown();
		exec2.shutdown();
		exec3.shutdown();
		exec4.shutdown();
		exec5.shutdown();

		System.out.println("END");

	}

	private static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}