package com.nk.threads.completablefutureallof;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;

public class MultipleCF {

	public static void main(String[] args) {

		multipleTasks();

	}

	private static void multipleTasks() {

		ExecutorService pool1 = Executors.newFixedThreadPool(5);

		Supplier<List<String>> supplyNames = () -> {
			List<String> asList = Arrays.asList("p1", "p2", "p3", "p4", "p5");
			System.out.println(Thread.currentThread().getName() + " :: supplying arrayList---" + asList);
			return asList;
		};

		Function<List<String>, CompletableFuture> downloadPkgs = (pkgName) -> {
			CompletableFuture runAsync = null;
			
			for (String pkg : pkgName) {
				System.out.println("pkg : " + pkg);
				CompletableFuture.runAsync(() -> {
					sleep(500);
					System.out.println(Thread.currentThread().getName() + " :: downloading package with name : " + pkg);
				}, pool1);
			}
			return runAsync;
		};

		CompletableFuture<List<String>> cf = CompletableFuture.supplyAsync(supplyNames, pool1);
		cf.thenApplyAsync(downloadPkgs, pool1).thenRun(() -> {
			System.out.println(Thread.currentThread().getName() + " :: task completed");
		});
		
		

		try {
			cf.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------DONE-----"); 	
//		pool1.shutdown();

	}

	private static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}