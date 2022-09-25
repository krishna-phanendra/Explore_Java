package com.nk.threads.waitnotify;

/**
 * In the class, Producer and Consumer are synchronized but still behavior is
 * not consistent and causing deadlocks.
 * 
 * @author phanendra
 *
 */
public class ProducerConsumer_sync {

	/**
	 * Lock object
	 */
	private static Object lock = new Object();

	private static int[] buffer;
	private static int count;

	static class Producer {
		void produce() {
			synchronized (lock) {
				/**
				 * PROBLEM : thread holding the key and waiting here, and not releasing the lock
				 */
				while (isFull(buffer)) {
				}
				buffer[count++] = 1;
			}
		}
	}

	static boolean isFull(int[] buffer) {
		return count == buffer.length;
	}

	static class Consumer {
		void consume() {
			synchronized (lock) {
				/**
				 * PROBLEM : thread holding the key and waiting here, and not releasing the lock
				 */
				if (isEmpty(buffer)) {
				}
				buffer[--count] = 0;
			}
		}
	}

	static boolean isEmpty(int[] buffer) {
		return count == 0;
	}

	public static void main(String[] args) throws InterruptedException {

		buffer = new int[10];
		count = 0;

		Producer p = new Producer();
		Consumer c = new Consumer();

		Runnable pTask = () -> {
			for (int i = 0; i < 50; i++) {
				p.produce();
			}
			System.out.println("Done Producing");
		};

		Runnable cTask = () -> {
			for (int i = 0; i < 50; i++) {
				c.consume();
			}
			System.out.println("Done Producing");
		};

		Thread pt = new Thread(pTask);
		Thread ct = new Thread(cTask);

		pt.start();
		ct.start();

		pt.join();
		ct.join();

		System.out.println("Data in buffer : " + count);

	}

}
