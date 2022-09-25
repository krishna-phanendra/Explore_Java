package com.nk.threads.triggerataskoncompletionofanothertask;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.nk.threads.triggerataskoncompletionofanothertask.model.User;

public class AsyncExample {

	public static void main(String[] args) {
//		test1();
//		test2();
		test3();

	}

	private static void test3() {
		ExecutorService executor1 = Executors.newSingleThreadExecutor();
		ExecutorService executor2 = Executors.newSingleThreadExecutor();

		Supplier<List<Long>> supplyIds = () -> {
			System.out.println("Id's Supplier running in ..." + Thread.currentThread().getName());
			sleep(200);
			return Arrays.asList(1L, 2L, 3L);
		};

		Function<List<Long>, CompletableFuture<List<User>>> userList = (ids) -> {
			sleep(300);
			System.out.println("Function running in ..." + Thread.currentThread().getName());
			Supplier<List<User>> userSupplier = () -> {
				System.out.println("Function supplier running in ..." + Thread.currentThread().getName());
				return ids.stream().map(User::new).collect(Collectors.toList());
			};
			return CompletableFuture.supplyAsync(userSupplier, executor2);
		};

		Consumer<List<User>> displayUsers = (users) -> {
			System.out.println("Running in... " + Thread.currentThread().getName());
			users.forEach(System.out::println);
		};

		CompletableFuture<List<Long>> supplyAsync = CompletableFuture.supplyAsync(supplyIds);
		supplyAsync.thenComposeAsync(userList, executor2).thenAcceptAsync(displayUsers, executor1);

		sleep(1_000);
		executor1.shutdown();
		executor2.shutdown();
	}

	private static void test2() {
		ExecutorService executor = Executors.newFixedThreadPool(5);

		Supplier<List<Long>> supplyIds = () -> {
			System.out.println("supplyIds running in ..." + Thread.currentThread().getName());
			sleep(200);
			return Arrays.asList(1L, 2L, 3L);
		};

		/**
		 * making this function async with CompletableFuture<List<User>>
		 */
		Function<List<Long>, CompletableFuture<List<User>>> userList = (ids) -> {
			sleep(300);
			Supplier<List<User>> userSupplier = () -> {
				System.out.println("Currently running in ..." + Thread.currentThread().getName());
				return ids.stream().map(User::new).collect(Collectors.toList());
			};
			return CompletableFuture.supplyAsync(userSupplier,executor);
		};

		Consumer<List<User>> displayUsers = (users) -> {
			System.out.println("Running in... " + Thread.currentThread().getName());
			users.forEach(System.out::println);
		};

		CompletableFuture<List<Long>> supplyAsync = CompletableFuture.supplyAsync(supplyIds, executor);
		supplyAsync.thenComposeAsync(userList, executor).thenAcceptAsync(displayUsers, executor);
		sleep(1_000);
		executor.shutdown();
	}

	private static void test1() {
		ExecutorService executor = Executors.newSingleThreadExecutor();

		Supplier<List<Long>> supplyIds = () -> {
			System.out.println("supplyIds running in ..." + Thread.currentThread().getName());
			sleep(200);
			return Arrays.asList(1L, 2L, 3L);
		};

		Function<List<Long>, List<User>> userList = (ids) -> {
			System.out.println("Function userList running in ..." + Thread.currentThread().getName());
			sleep(300);
			return ids.stream().map(User::new).collect(Collectors.toList());
		};

		Consumer<List<User>> displayUsers = (users) -> {
			System.out.println("Running in... " + Thread.currentThread().getName());
			users.forEach(System.out::println);
		};

		CompletableFuture<List<Long>> supplyAsync = CompletableFuture.supplyAsync(supplyIds);
		supplyAsync.thenApply(userList).thenAcceptAsync(displayUsers, executor);
		sleep(1_000);
		executor.shutdown();

	}

	private static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
