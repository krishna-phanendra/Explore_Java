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

import com.nk.threads.triggerataskoncompletionofanothertask.model.Email;
import com.nk.threads.triggerataskoncompletionofanothertask.model.User;

public class AsyncExampleMultiBranch {

	public static void main(String[] args) {
//		test1();
		
		// Triggering a task on the completion of the first task
		test2();
	}

	private static void test2() {

		ExecutorService executor1 = Executors.newSingleThreadExecutor();

		Supplier<List<Long>> supplyIds = () -> {
			System.out.println("Id's Supplier running in ..." + Thread.currentThread().getName());
			sleep(200);
			return Arrays.asList(1L, 2L, 3L);
		};

		Function<List<Long>, CompletableFuture<List<User>>> fetchUsers1 = ids -> {
			sleep(150);
			System.out.println("Function running in ..." + Thread.currentThread().getName());
			Supplier<List<User>> userSupplier = () -> {
				System.out.println("Function supplier running in ..." + Thread.currentThread().getName());
				return ids.stream().map(User::new).collect(Collectors.toList());
			};
			return CompletableFuture.supplyAsync(userSupplier);
		};
		
		Function<List<Long>, CompletableFuture<List<User>>> fetchUsers2 = ids -> {
			sleep(5000);
			System.out.println("Function running in ..." + Thread.currentThread().getName());
			Supplier<List<User>> userSupplier = () -> {
				System.out.println("Function supplier running in ..." + Thread.currentThread().getName());
				return ids.stream().map(User::new).collect(Collectors.toList());
			};
			return CompletableFuture.supplyAsync(userSupplier);
		};

		Consumer<List<User>> displayUsers = (users) -> {
			System.out.println("Running in... " + Thread.currentThread().getName());
			users.forEach(System.out::println);
		};

		CompletableFuture<List<Long>> supplyAsync = CompletableFuture.supplyAsync(supplyIds);
		CompletableFuture<List<User>> users1 = supplyAsync.thenComposeAsync(fetchUsers1);
		CompletableFuture<List<User>> users2 = supplyAsync.thenComposeAsync(fetchUsers2);
		
		users1.thenRun(() -> System.out.println("Users 1"));
		users2.thenRun(() -> System.out.println("Users 2"));
		
		
		users1.acceptEither(users2, displayUsers);


		sleep(6000);
		executor1.shutdown();
	

		
	}

	private static void test1() {
		ExecutorService executor1 = Executors.newSingleThreadExecutor();

		Supplier<List<Long>> supplyIds = () -> {
			System.out.println("Id's Supplier running in ..." + Thread.currentThread().getName());
			sleep(200);
			return Arrays.asList(1L, 2L, 3L);
		};

		Function<List<Long>, CompletableFuture<List<User>>> fetchUsers = ids -> {
			sleep(250);
			System.out.println("Function running in ..." + Thread.currentThread().getName());
			Supplier<List<User>> userSupplier = () -> {
				System.out.println("Function supplier running in ..." + Thread.currentThread().getName());
				return ids.stream().map(User::new).collect(Collectors.toList());
			};
			return CompletableFuture.supplyAsync(userSupplier);
		};

		Function<List<Long>, CompletableFuture<List<Email>>> fetchEmail = ids -> {
			sleep(350);
			Supplier<List<Email>> emailSupplier = () -> {
				return ids.stream().map(Email::new).collect(Collectors.toList());
			};
			return CompletableFuture.supplyAsync(emailSupplier);
		};

		Consumer<List<User>> displayUsers = (users) -> {
			System.out.println("Running in... " + Thread.currentThread().getName());
			users.forEach(System.out::println);
		};

		CompletableFuture<List<Long>> supplyAsync = CompletableFuture.supplyAsync(supplyIds);

		CompletableFuture<List<User>> userFuture = supplyAsync.thenCompose(fetchUsers);
		CompletableFuture<List<Email>> emailFuture = supplyAsync.thenCompose(fetchEmail);

		userFuture.thenAcceptBoth(emailFuture, (users, emails) -> {
			System.out.println(users.size() + " : " + emails.size());
		});

		sleep(1000);
		executor1.shutdown();
	}

	private static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
