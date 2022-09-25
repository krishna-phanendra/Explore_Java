package com.nk.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class WaitTillExecuteAllThreads {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

//		ExecutorService tdPool = Executors.newFixedThreadPool(10);
//
//		String[] init = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14" };
//
//		ConcurrentHashMap<String, String> m = new ConcurrentHashMap<String, String>();
//		List<Future> futList = new ArrayList(14);
//
//		for (String str : init) {
//			Future<?> fut = tdPool.submit(() -> {
//				System.out.println("------" + Thread.currentThread().getName());
//				m.put(str, str + "-" + Thread.currentThread().getName());
//				
//				try {
//					Thread.sleep(10000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			});
//			futList.add(fut);
//		}
//		
//		for (Future fut : futList) {
//			System.out.println("---->" + fut.get());
//		}
//
//		tdPool.shutdown();
//
//		try {
//			if (tdPool.awaitTermination(5, TimeUnit.SECONDS)) {
//				tdPool.shutdownNow();
//			}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		System.out.println("map  : " + m);

		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		List<Future<Integer>> resultList = new ArrayList<>();

		Random random = new Random();

		for (int i = 0; i < 20; i++) {
			System.out.println("ii :: "+i);
			Integer number = random.nextInt(10);
//			FactorialCalculator calculator  = new FactorialCalculator(number);
			
            Future result = executor.submit(() -> {
            	System.out.println("Thread :: "+Thread.currentThread().getName());
                int result1 = 1;
                if ((number == 0) || (number == 1)) {
                    result1 = 1;
                } else {
                    for (int j = 2; j <= number; j++) {
                        result1 *= j;
                        TimeUnit.MILLISECONDS.sleep(200);
                    }
                }
                System.out.println("Result for number - " + number + " -> " + result1);
                return result1;
            });
            
//			resultList.add(result);
			
//			FactorialCalculatorR calculator  = new FactorialCalculatorR(number);
//			executor.execute(calculator);
		}
		
		System.out.println("==================");
		
		System.out.println("count : "+resultList.size());

//		for (Future<Integer> future : resultList) {
//				future.isDone();
//				try {
//					System.out.println(
//							"Future result is - " + " - " + future.get(300, TimeUnit.MILLISECONDS) + "; And Task done is " + future.isDone());
//				} catch (TimeoutException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		}
		System.out.println("========00==========");
		executor.shutdown();
		System.out.println("========11==========");
		try {
			if (!executor.awaitTermination(15, TimeUnit.MINUTES)) {
				System.out.println("========22==========");
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// shut down the executor service now
	}

}

class FactorialCalculator implements Callable<Integer>
{
 
    private Integer number;
 
    public FactorialCalculator(Integer number) {
        this.number = number;
    }
 
    @Override
    public Integer call() throws Exception {
    	System.out.println("Thread :: "+Thread.currentThread().getName());
        int result = 1;
        if ((number == 0) || (number == 1)) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(2000);
            }
        }
        System.out.println("Result for number - " + number + " -> " + result);
        return result;
    }
}

class FactorialCalculatorR implements Runnable
{
 
    private Integer number;
 
    public FactorialCalculatorR(Integer number) {
        this.number = number;
    }
 
    @Override
    public void run() {
    	System.out.println("Thread :: "+Thread.currentThread().getName());
        int result = 1;
        if ((number == 0) || (number == 1)) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                try {
					TimeUnit.MILLISECONDS.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
        }
        System.out.println("Result for number - " + number + " -> " + result);
//        return result;
    }
}
