package com.nk.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutorService {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(10);
		pool.execute(() -> System.out.println("Thread : " + Thread.currentThread().getName()));
		pool.shutdown();
	}

}
