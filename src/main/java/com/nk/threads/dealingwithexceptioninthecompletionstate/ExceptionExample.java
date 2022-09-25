package com.nk.threads.dealingwithexceptioninthecompletionstate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.nk.threads.triggerataskoncompletionofanothertask.model.User;

public class ExceptionExample {

	public static void main(String[] args) {

//		test1();
		testExceptionally();
		testWhenComplete();
		testHandle();

	}
	
	private static void testHandle() {

		Supplier<List<Long>> supplyIds = () -> {
			sleep(200);
			throw new IllegalStateException("No Data");
//			return Arrays.asList(1L, 2L, 3L);
		};

		Function<List<Long>, List<User>> fetchUsers = ids -> {
			sleep(300);
			return ids.stream().map(User::new).collect(Collectors.toList());
		};

		Consumer<List<User>> displayer = users -> users.forEach(System.out::println);

		CompletableFuture<List<Long>> supplyAsync = CompletableFuture.supplyAsync(supplyIds);

		CompletableFuture<List<Long>> exception = supplyAsync.handle((ids, e) -> {
			if (e != null) {
				System.out.println("exception : " + e.getMessage());
				e.printStackTrace();
				return List.of();
			} else {
				return ids;
			}
		});
		CompletableFuture<List<User>> fetch = exception.thenApply(fetchUsers);
		CompletableFuture<Void> display = fetch.thenAccept(displayer);

		sleep(1000);

		System.out.println(
				"Supply : done=" + supplyAsync.isDone() + ", exception=" + supplyAsync.isCompletedExceptionally());
		System.out.println("fetch : done=" + fetch.isDone() + ", exception=" + fetch.isCompletedExceptionally());
		System.out.println("display : done=" + display.isDone() + ", exception=" + display.isCompletedExceptionally());

	}

	private static void testWhenComplete() {
		Supplier<List<Long>> supplyIds = () -> {
			sleep(200);
			throw new IllegalStateException("No Data");
//			return Arrays.asList(1L, 2L, 3L);
		};

		Function<List<Long>, List<User>> fetchUsers = ids -> {
			sleep(300);
			return ids.stream().map(User::new).collect(Collectors.toList());
		};

		Consumer<List<User>> displayer = users -> users.forEach(System.out::println);

		CompletableFuture<List<Long>> supplyAsync = CompletableFuture.supplyAsync(supplyIds);

		CompletableFuture<List<Long>> exception = supplyAsync.whenComplete((ids, e) -> {
			if (e != null) {
				System.out.println("exception : " + e.getMessage());
				e.printStackTrace();
			}
		});
		CompletableFuture<List<User>> fetch = exception.thenApply(fetchUsers);
		CompletableFuture<Void> display = fetch.thenAccept(displayer);

		sleep(1000);

		System.out.println(
				"Supply : done=" + supplyAsync.isDone() + ", exception=" + supplyAsync.isCompletedExceptionally());
		System.out.println("fetch : done=" + fetch.isDone() + ", exception=" + fetch.isCompletedExceptionally());
		System.out.println("display : done=" + display.isDone() + ", exception=" + display.isCompletedExceptionally());

	}

	private static void testExceptionally() {
		Supplier<List<Long>> supplyIds = () -> {
			sleep(200);
			throw new IllegalStateException("No Data");
		};

		Function<List<Long>, List<User>> fetchUsers = ids -> {
			sleep(300);
			return ids.stream().map(User::new).collect(Collectors.toList());
		};

		Consumer<List<User>> displayer = users -> users.forEach(System.out::println);

		CompletableFuture<List<Long>> supplyAsync = CompletableFuture.supplyAsync(supplyIds);
		CompletableFuture<List<Long>> exception = supplyAsync.exceptionally(e -> List.of());
		CompletableFuture<List<User>> fetch = exception.thenApply(fetchUsers);		
		CompletableFuture<Void> display = fetch.thenAccept(displayer);

		supplyAsync.join();

		sleep(1000);

		System.out.println(
				"Supply : done=" + supplyAsync.isDone() + ", exception=" + supplyAsync.isCompletedExceptionally());
		System.out.println("fetch : done=" + fetch.isDone() + ", exception=" + fetch.isCompletedExceptionally());
		System.out.println("display : done=" + display.isDone() + ", exception=" + display.isCompletedExceptionally());

	}

	private static void test1() {
		Supplier<List<Long>> supplyIds = () -> {
			sleep(200);
//			throw new IllegalStateException("No Data");
			return Arrays.asList(1L, 2L, 3L);
		};

		Function<List<Long>, List<User>> fetchUsers = ids -> {
			sleep(300);
			throw new IllegalStateException("No Data");
//			return ids.stream().map(User::new).collect(Collectors.toList());
		};

		Consumer<List<User>> displayer = users -> users.forEach(System.out::println);

		CompletableFuture<List<Long>> supplyAsync = CompletableFuture.supplyAsync(supplyIds);
		CompletableFuture<List<User>> fetch = supplyAsync.thenApply(fetchUsers);
		CompletableFuture<Void> display = fetch.thenAccept(displayer);

		sleep(1000);

		System.out.println(
				"Supply : done=" + supplyAsync.isDone() + ", exception=" + supplyAsync.isCompletedExceptionally());
		System.out.println("fetch : done=" + fetch.isDone() + ", exception=" + fetch.isCompletedExceptionally());
		System.out.println("display : done=" + display.isDone() + ", exception=" + display.isCompletedExceptionally());
	}

	private static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
